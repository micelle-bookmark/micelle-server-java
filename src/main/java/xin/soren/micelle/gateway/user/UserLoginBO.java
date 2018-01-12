package xin.soren.micelle.gateway.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 用户登陆返回信息
 * @author soren
 * @date 2018年1月12日 下午1:56:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginBO {
	@Data
	@Builder
	static public class TokenBO {
		private String token;
		private Long expiresIn;
	};

	private UserBO user;
	private TokenBO token;
}
