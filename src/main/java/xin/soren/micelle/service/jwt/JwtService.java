package xin.soren.micelle.service.jwt;

/**
 * 
 * @Description: JWT 认证接口类
 * @author soren
 * @date 2017年10月8日 上午10:21:00
 *
 */
public interface JwtService {
	public String create(String subject, long ttlMillis);

	public String parse(String jwt);
}
