package xin.soren.micelle.domain.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import xin.soren.micelle.domain.model.user.UserEntity;

@Mapper
public interface UserMapper {
	// @Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into user(id, account_id, user_name, avatar, email, create_time, modify_time) "
			+ "values(#{user.id}, #{user.accountId}, #{user.userName}, #{user.avatar}, #{user.email}, #{user.createTime}, #{user.modifyTime})")
	public Long insert(@Param("user") UserEntity user);

	@Insert({ "<script>" + "INSERT INTO user" + "<trim prefix='(' suffix=')' suffixOverrides=',' >"
			+ "id, account_id, user_name, " + "<if test='#{user.avatar} != null'> avatar, </if>"
			+ "<if test='#{user.email} != null'> email, </if>"
			+ "<if test='#{user.createTime} != null'> create_time, </if>"
			+ "<if test='#{user.modifyTime} != null'> modify_time, </if>" + "</trim>" + " VALUES"
			+ "<trim prefix='(' suffix=')' suffixOverrides=',' >" + "#{user.id}, #{user.accountId}, #{user.userName}, "
			+ "<if test='#{user.avatar} != null'> #{user.avatar}, </if>"
			+ "<if test='#{user.email} != null'> #{user.email}, </if>"
			+ "<if test='#{user.createTime} != null'> #{user.createTime}, </if>"
			+ "<if test='#{user.modifyTime} != null'> #{user.modifyTime}, </if>" + "</trim>" + "</script>" })
	public Long insertSelective(@Param("user") UserEntity account);

	@SelectProvider(type = UserSqlProvider.class, method = "getByUserId")
	@Results(id = "default", value = { @Result(property = "accountId", column = "account_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public UserEntity getByUserId(Long userId);

	@Select("select id, account_id, user_name, avatar, email, create_time, modify_time "
			+ "from user where user_name=#{userName}")
	@ResultMap("default")
	public UserEntity getByUserName(@Param("userName") String userName);

	// @Update({ "<script>" + "UPDATE user SET " + "<trim prefix=' ' suffix=' '
	// suffixOverrides=',' >"
	// + "<if test='#{c.userName} != null'> user_name=#{c.userName}, </if>"
	// + "<if test='#{c.avatar} != null'> avatar=#{c.avatar}, </if>"
	// + "<if test='#{c.email} != null'> email=#{c.email}, </if>" + "</trim>" +
	// " WHERE id=#{c.id}"
	// + "</script>" })
	@UpdateProvider(type = UserSqlProvider.class, method = "updateSelective")
	public Long updateSelective(@Param("c") UserEntity account);
}
