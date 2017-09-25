package xin.soren.micelle.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
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
	AccountMapper accountMapper;

	@Override
	@Transactional
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

}
