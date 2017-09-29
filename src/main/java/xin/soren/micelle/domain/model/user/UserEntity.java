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
	/**
	 * 用户 ID, primary key
	 */
	private Long id;

	/**
	 * 该用户关联的 accountId
	 */
	private Long accountId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * email
	 */
	private String email;

	/**
	 * 注册时间
	 */
	private Date createTime;

	/**
	 * 上次修改时间
	 */
	private Date modifyTime;
}
