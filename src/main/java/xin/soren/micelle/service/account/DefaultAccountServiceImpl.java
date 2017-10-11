package xin.soren.micelle.service.account;

import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.account.AccountMapper;
import xin.soren.micelle.domain.model.account.AccountEntity;
import xin.soren.micelle.exception.WrongPasswordException;

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
	AccountMapper accountMapper;

	@Override
	@Transactional
	@WriteLog("'创建帐号, accountId: '+#args[0]+' , name: '+#args[1]")
	public Long createAccount(Long id, String accountName, String password, String salt) {
		log.info("创建账户, id={}, accountName={}, password={}, salt={}", id, accountName, password, salt);

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(id);
		accountEntity.setAccountName(accountName);
		accountEntity.setPassword(password);
		accountEntity.setSalt(salt);

		accountMapper.insertSelective(accountEntity);

		return id;
	}

	@Override
	public AccountEntity getAccountById(Long id) {
		return accountMapper.getById(id);
	}

	@Transactional
	@Override
	@WriteLog(value = "'创建帐号, accountId: '+#args[0]")
	public Long createAccount(Long accountId, String password) {
		assert accountId != null;
		assert password != null;

		Pair<String, String> pwdPair = CommonUtils.encrypt(password);
		String salt = pwdPair.getRight();
		String accountName = String.valueOf(accountId);

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(accountId);
		accountEntity.setAccountName(accountName);
		accountEntity.setPassword(pwdPair.getLeft());
		accountEntity.setSalt(salt);

		return accountId;
	}

	@Override
	@Transactional
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
}
