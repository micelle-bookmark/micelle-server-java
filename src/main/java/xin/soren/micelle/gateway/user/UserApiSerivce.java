package xin.soren.micelle.gateway.user;

/**
 * 
 * @Description: 用户 API 接口类
 * @author soren
 * @date 2017年9月25日 下午9:22:59
 *
 */
public interface UserApiSerivce {
	/**
	 * 
	 * @Description: 创建用户帐号及信息
	 * @param userName
	 * @param password
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:23:44
	 */
	public Long createUser(String userName, String password);
}
