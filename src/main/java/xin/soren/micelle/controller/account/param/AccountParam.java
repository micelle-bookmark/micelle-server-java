package xin.soren.micelle.controller.account.param;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;
import xin.soren.micelle.common.valid.Email;
import xin.soren.micelle.common.valid.Url;

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
	@NotNull(message = "{param.userName.null}")
	@Length(min = 1, message = "参数 userName 长度错误")
	public String userName;

	/*
	 * 密码为 Base64 编码的字符串
	 */
	@NotNull(message = "缺少参数 password")
	@Length(min = 1, message = "参数 password 长度错误")
	public String password;

	@NotNull(message = "缺少参数 avatar", groups = { Register.class })
	@Url(message = "参数 avatar 格式错误", groups = { Register.class })
	public String avatar;

	@NotNull(message = "缺少参数 email", groups = { Register.class })
	@Email(message = "参数 email 格式错误", groups = { Register.class })
	public String email;

	public interface Login extends Default {
	};

	public interface Register {
	};
}
