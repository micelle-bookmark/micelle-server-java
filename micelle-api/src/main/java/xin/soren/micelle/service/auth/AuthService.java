package xin.soren.micelle.service.auth;

/**
 * 
 * @Description: 认证服务接口类
 * @author soren
 * @date 2017年9月29日 下午2:41:26
 *
 */
public interface AuthService {
	/**
	 * 
	 * @Description: 创建 token
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @Throws
	 * @Date 2017年10月8日 上午11:26:11
	 */
	public String create(String subject, long ttlMillis);

	/**
	 * 
	 * @Description: 解析 token
	 * @param jwt
	 * @return
	 * @Throws
	 * @Date 2017年10月8日 上午11:26:19
	 */
	public String parse(String jwt);
}
