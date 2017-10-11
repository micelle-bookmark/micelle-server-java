package xin.soren.micelle.controller.user.param;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 修改用户信息参数
 * @author soren
 * @date 2017年10月11日 下午1:37:02
 *
 */
@Data
@NoArgsConstructor
public class ModifyUserInfoParam {
	public String userName;
	public String email;
	public String avatar;
}
