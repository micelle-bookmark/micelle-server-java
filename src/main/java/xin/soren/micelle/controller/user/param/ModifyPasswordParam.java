package xin.soren.micelle.controller.user.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 修改用户密码参数
 * @author soren
 * @date 2017年10月11日 下午1:38:08
 *
 */
@Data
@NoArgsConstructor
public class ModifyPasswordParam {
	@NotNull(message = "缺少参数 oldPassword")
	@Length(min = 1, message = "参数 oldPassword 长度错误")
	public String oldPassword;

	@NotNull(message = "缺少参数 newPassword")
	@Length(min = 1, message = "参数 newPassword 长度错误")
	public String newPassword;
}
