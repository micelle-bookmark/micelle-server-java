package xin.soren.micelle.gateway.user;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @Description: 用户信息
 * @author soren
 * @date 2017年10月11日 下午2:48:46
 *
 */
@Data
@Builder
public class User {
	public Long userId;
	public String userName;
	public String avatar;
	public String email;
}
