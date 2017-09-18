package xin.soren.micelle.controller.user.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 登录参数定义
 * @author soren
 * @date 2017年9月12日 下午5:04:56
 *
 */
@Data
@NoArgsConstructor
public class LoginParam {
	@NotNull(message = "参数 userName 不能为空")
	@Length(min = 1, message = "参数 userName 长度错误")
	public String userName;

	@NotNull(message = "参数 password 不能为空")
	@Length(min = 1, message = "参数 password 长度错误")
	public String password;
}
