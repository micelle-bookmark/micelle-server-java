package xin.soren.micelle.service.account;

import xin.soren.micelle.domain.model.account.AccountEntity;

/**
 * 
 * @Description: 帐号服务接口类
 * @author soren
 * @date 2017年9月19日 下午9:32:41
 *
 */
public interface AccountService {
	public Long createAccount(String accountName, String password, String salt);

	public AccountEntity getAccountById(Long id);
}
