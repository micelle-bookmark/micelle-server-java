package xin.soren.micelle.domain.model.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UserEntity
 * @Description: 用户实体
 * @author soren
 * @date 2017年9月12日 上午11:38:34
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	private Long id;
	private String userName;
	private String avatar;
	private String email;
	private String password;
	private String salt;
	private Date create_time;
	private Date modify_time;
}
