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
public class UserBO {
	private Long userId;
	private String userName;
	private String avatar;
	private String email;
}
