package xin.soren.micelle.domain.model.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
