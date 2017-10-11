package xin.soren.micelle.domain.mapper.account;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xin.soren.micelle.domain.model.account.AccountEntity;

/**
 * 
 * @Description: 帐号实体操作类
 * @author soren
 * @date 2017年9月19日 下午9:06:35
 *
 */
@Mapper
public interface AccountMapper {
	@Insert("insert into account(id, account_name, password, salt, create_time, modify_time) "
			+ "values(#{account.id}, #{account.accountName}, #{account.password}, #{account.salt}, "
			+ "#{account.createTime}, #{account.modifyTime})")
	public Long insert(@Param("account") AccountEntity account);

	@Insert({ "<script>" + "INSERT INTO account" + "<trim prefix='(' suffix=')' suffixOverrides=',' >" + "id, "
			+ "<if test='#{c.accountName} != null'> account_name, </if>" + "password, salt, "
			+ "<if test='#{c.createTime} != null'> create_time, </if>"
			+ "<if test='#{c.modifyTime} != null'> modify_time, </if>" + "</trim>" + " VALUES"
			+ "<trim prefix='(' suffix=')' suffixOverrides=',' >" + "#{c.id}, "
			+ "<if test='#{c.accountName} != null'> #{c.accountName}, </if>" + "#{c.password}, #{c.salt}, "
			+ "<if test='#{c.createTime} != null'> #{c.createTime}, </if>"
			+ "<if test='#{c.modifyTime} != null'> #{c.modifyTime}, </if>" + "</trim>" + "</script>" })
	public Long insertSelective(@Param("c") AccountEntity account);

	@Select("select id, account_name, password, salt, create_time, modify_time from account " + "where id=#{id}")
	@Results(id = "default", value = { @Result(property = "accountName", column = "account_name"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public AccountEntity getById(@Param("id") Long id);

	@Update("update account set password=#{password}, " + "salt=#{salt} where id=#{id}")
	public Long updatePassword(@Param("id") Long id, @Param("password") String password, @Param("salt") String salt);
}
