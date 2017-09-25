package xin.soren.micelle.service.user;

import xin.soren.micelle.domain.model.user.UserEntity;

/**
 * 
 * @Description: 用户服务接口类
 * @author soren
 * @date 2017年9月12日 上午11:38:14
 *
 */
public interface UserService {
	/**
	 * 保存一个用户实体
	 * 
	 * @param id
	 * @param userName
	 * @return
	 */
	public Long createUser(Long id, String userName);

	/**
	 * 
	 * @Description: 通过用户 ID 获取用户信息
	 * @param id
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:58:27
	 */
	public UserEntity getUserById(Long id);

	/**
	 * 
	 * @Description: 通过用户名获取用户信息
	 * @param userName
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:58:40
	 */
	public UserEntity getUserByName(String userName);
}
