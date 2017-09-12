package xin.soren.micelle.domain.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xin.soren.micelle.domain.model.user.UserEntity;

@Mapper
public interface UserMapper {
	@Select("select id, user_name, avatar, email, password, salt, create_time, modify_time "
			+ "from user where id=#{arg0}")
	@Results(id = "default", value = { @Result(property = "userName", column = "user_name"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public UserEntity selectById(Long userId);

	@Insert("insert into user(id, user_name, avatar, email, password, salt) "
			+ "values(#{user.id}, #{user.userName}, #{user.avatar}, #{user.email}, #{user.password}, #{user.salt})")
	public Long insert(@Param("user") UserEntity user);

	@Update("update user set user_name=#{user.userName} where id=#{user.id}")
	public Long update(@Param("user") UserEntity user);

	@Update("update user set password=#{password}, salt=#{salt} where id=#{id}")
	public Long updatePassword(@Param("id") Long id, @Param("password") String password, @Param("salt") String salt);
}
