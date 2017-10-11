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
	/**
	 * 
	 * @Description: 创建帐号
	 * @param id
	 * @param accountName
	 * @param password
	 * @param salt
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:54:51
	 */
	public Long createAccount(Long id, String accountName, String password, String salt);

	/**
	 * 
	 * @Description: 创建帐号
	 * @param accountId
	 * @param password
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:30:33
	 */
	public Long createAccount(Long accountId, String password);

	/**
	 * 
	 * @Description: 根据帐号 ID 获取帐号信息
	 * @param id
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:55:08
	 */
	public AccountEntity getAccountById(Long id);
}
