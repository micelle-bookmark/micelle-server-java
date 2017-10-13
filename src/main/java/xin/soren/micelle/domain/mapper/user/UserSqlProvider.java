package xin.soren.micelle.domain.mapper.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.model.user.UserEntity;

/**
 * 
 * @Description: 用户相关部分 SqlBuilder
 * @author soren
 * @date 2017年10月11日 下午5:27:56
 *
 */
@Slf4j
public class UserSqlProvider {
	public static String getByUserId(Long userId) {
		return new SQL() {
			{
				SELECT("id, account_id, user_name, avatar, email, create_time, modify_time");
				FROM("user");
				WHERE("id=#{arg0}");
			}
		}.toString();
	}

	public static String updateSelective(@Param("c") UserEntity userEntity) {
		return new SQL() {
			{
				UPDATE("user");
				if (userEntity.getUserName() != null) {
					SET("user_name=#{c.userName}");
				}
				if (userEntity.getAvatar() != null) {
					SET("avatar=#{c.avatar}");
				}
				if (userEntity.getEmail() != null) {
					SET("email=#{c.email}");
				}
				WHERE("id=#{c.id}");
			}
		}.toString();
	}
}
