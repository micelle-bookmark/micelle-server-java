package xin.soren.micelle.domain.model.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
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
	private Long accountId;
	private String userName;
	private String avatar;
	private String email;
	private Date createTime;
	private Date modifyTime;
}
