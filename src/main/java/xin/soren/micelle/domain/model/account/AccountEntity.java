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
	private Long id;
	private String accountName;
	private String password;
	private String salt;
	private Date createTime;
	private Date modifyTime;
}
