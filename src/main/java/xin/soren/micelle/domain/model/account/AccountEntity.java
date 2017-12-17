package xin.soren.micelle.domain.model.account;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @Description: 帐号实体
 * @author soren
 * @date 2017年9月19日 下午9:04:30
 *
 */
@Data
public class AccountEntity {
	/**
	 * 帐号 ID, primary key
	 */
	private Long id;

	/**
	 * 帐号名称
	 */
	private String accountName;

	/**
	 * 密码, md5(用户密码+salt), 可以使用 bcrypt 来避免业务关注 salt 值
	 */
	private String password;

	/**
	 * 随机盐值
	 */
	private String salt;

	/**
	 * 帐号创建时间
	 */
	private Date createTime;

	/**
	 * 上次修改时间
	 */
	private Date modifyTime;
}
