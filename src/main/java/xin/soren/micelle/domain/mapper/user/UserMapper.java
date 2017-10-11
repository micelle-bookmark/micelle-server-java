package xin.soren.micelle.domain.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xin.soren.micelle.domain.model.user.UserEntity;

@Mapper
public interface UserMapper {
	@Select("select id, account_id, user_name, avatar, email, create_time, modify_time " + "from user where id=#{arg0}")
	@Results(id = "default", value = { @Result(property = "accountId", column = "account_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public UserEntity getByUserId(Long userId);

	@Select("select id, account_id, user_name, avatar, email, create_time, modify_time "
			+ "from user where user_name=#{userName}")
	@ResultMap("default")
	public UserEntity getByUserName(@Param("userName") String userName);

	// @Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into user(id, account_id, user_name, avatar, email) "
			+ "values(#{user.id}, #{user.accountId}, #{user.userName}, #{user.avatar}, #{user.email})")
	public Long insert(@Param("user") UserEntity user);

	@Update("update user set user_name=#{userName} where id=#{id}")
	public Long updateUserName(@Param("id") Long id, @Param("userName") String userName);

	@Update({ "<script>" + "UPDATE user SET " + "<trim prefix=' ' suffix=' ' suffixOverrides=',' >"
			+ "<if test='#{c.userName} != null'> user_name=#{c.userName}, </if>"
			+ "<if test='#{c.avatar} != null'> avatar=#{c.avatar}, </if>"
			+ "<if test='#{c.email} != null'> email=#{c.email}, </if>" + "</trim>" + " WHERE id=#{c.id}"
			+ "</script>" })
	public Long updateSelective(@Param("c") UserEntity account);
}
