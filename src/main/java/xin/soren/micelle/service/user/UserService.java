package xin.soren.micelle.service.user;

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
}
