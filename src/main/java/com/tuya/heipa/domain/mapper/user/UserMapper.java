package com.tuya.heipa.domain.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tuya.heipa.domain.model.user.UserEntity;

@Mapper
public interface UserMapper {
	@Select("select id, user_name from user where id=#{arg0}")
	@Results(id = "default", value = { @Result(property = "userName", column = "user_name") })
	public UserEntity selectById(Long userId);

	@Insert("insert into user(id, user_name) values(#{user.id}, #{user.userName})")
	public Long insert(@Param("user") UserEntity user);

	@Update("update user set user_name=#{user.userName} where id=#{user.id}")
	public Long update(@Param("user") UserEntity user);
}
