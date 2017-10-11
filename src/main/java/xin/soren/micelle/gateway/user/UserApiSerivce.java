package xin.soren.micelle.gateway.user;

import xin.soren.micelle.controller.user.param.ModifyPasswordParam;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;

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

	/**
	 * 
	 * @Description: 获取用户信息
	 * @param userId
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:47:47
	 */
	public User getUserInfo(Long userId);

	/**
	 * 
	 * @Description: 修改用户信息
	 * @param userId
	 * @param param
	 * @Throws
	 * @Date 2017年10月11日 下午3:30:10
	 */
	public void modifyUserInfo(Long userId, ModifyUserInfoParam param);

	/**
	 * 
	 * @Description: 修改用户密码
	 * @param userId
	 * @param param
	 * @Throws
	 * @Date 2017年10月11日 下午3:30:18
	 */
	public void modifyUserPassword(Long userId, ModifyPasswordParam param);
}
