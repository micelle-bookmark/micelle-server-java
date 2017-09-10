package xin.soren.micelle.service.user;

/**
 * 
 * @Description: 用户服务
 * @author yangsonglin
 * @date 2017年9月6日 上午10:37:42
 * @version V2.0
 */
public interface UserService {
	/**
	 * 保存一个用户实体
	 * 
	 * @param id
	 * @param userName
	 * @return
	 */
	public Long insertUser(Long id, String userName);
}
