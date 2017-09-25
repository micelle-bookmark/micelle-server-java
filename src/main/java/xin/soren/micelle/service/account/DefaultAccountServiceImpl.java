package xin.soren.micelle.service.account;

import org.springframework.stereotype.Service;

import xin.soren.micelle.domain.model.account.AccountEntity;

/**
 * 
 * @Description: 帐号服务实现类
 * @author soren
 * @date 2017年9月19日 下午9:33:11
 *
 */
@Service
public class DefaultAccountServiceImpl implements AccountService {

	@Override
	public Long createAccount(String accountName, String password, String salt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountEntity getAccountById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
