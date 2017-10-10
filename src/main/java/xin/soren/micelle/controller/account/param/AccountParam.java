package xin.soren.micelle.controller.account.param;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
public class AccountParam {
	@NotNull(message = "缺少参数 userName")
	@Length(min = 1, message = "参数 userName 长度错误")
	public String userName;

	/*
	 * 密码为 Base64 编码的字符串
	 */
	@NotNull(message = "缺少参数 password")
	@Length(min = 1, message = "参数 password 长度错误")
	public String password;

	@NotBlank(message = "参数 avatar 不存在或为空", groups = { Register.class })
	public String avatar;

	@NotNull(message = "缺少参数 email", groups = { Register.class })
	@Length(min = 1, message = "参数 email 长度错误", groups = { Register.class })
	public String email;

	public interface Login extends Default {
	};

	public interface Register {
	};
}
