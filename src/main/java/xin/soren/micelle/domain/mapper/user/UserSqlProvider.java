package xin.soren.micelle.domain.mapper.user;

import org.apache.ibatis.jdbc.SQL;

/**
 * 
 * @Description: 用户相关部分 SqlBuilder
 * @author soren
 * @date 2017年10月11日 下午5:27:56
 *
 */
public class UserSqlProvider {
	public static String getByUserId(Long userId) {
		// Long userId = (Long) params.get("arg0");

		return new SQL() {
			{
				SELECT("id, account_id, user_name, avatar, email, create_time, modify_time");
				FROM("user");
				WHERE("id=#{arg0}");
			}
		}.toString();
	}
}
