package xin.soren.micelle.service.account;

import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.common.exception.WrongPasswordException;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.account.AccountMapper;
import xin.soren.micelle.domain.model.account.AccountEntity;

/**
 * 
 * @Description: 帐号服务实现类
 * @author soren
 * @date 2017年9月19日 下午9:33:11
 *
 */
@Service
@Slf4j
public class DefaultAccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Transactional
	@Override
	@WriteLog(value = "'创建帐号, accountId: '+#args[0]")
	public Long createAccount(Long accountId, String password) {
		assert accountId != null;
		assert password != null;

		Pair<String, String> pwdPair = CommonUtils.encrypt(password);
		String salt = pwdPair.getRight();
		String accountName = String.valueOf(accountId);

		log.info("帐号名: {}, 帐号ID: {}", accountName, accountId);

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(accountId);
		accountEntity.setAccountName(accountName);
		accountEntity.setPassword(pwdPair.getLeft());
		accountEntity.setSalt(salt);

		accountMapper.insertSelective(accountEntity);

		return accountId;
	}

	@Override
	@Transactional
	@WriteLog("'修改帐号['+#args[0]+'密码'")
	public Long updateAccountPassword(Long id, String password, String oldPwd) {
		AccountEntity accountEntity = accountMapper.getById(id);
		assert accountEntity != null;

		String oldEnPwd = CommonUtils.encrypt(oldPwd, accountEntity.getSalt());
		if (!Objects.equals(oldEnPwd, accountEntity.getPassword())) {
			throw new WrongPasswordException();
		}

		Pair<String, String> pwdPair = CommonUtils.encrypt(password);
		return accountMapper.updatePassword(id, pwdPair.getLeft(), pwdPair.getRight());
	}

	@Override
	public AccountEntity getAccountById(Long id) {
		return accountMapper.getById(id);
	}
}
