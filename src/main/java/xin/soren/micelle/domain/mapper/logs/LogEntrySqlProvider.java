package xin.soren.micelle.domain.mapper.logs;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import xin.soren.micelle.domain.model.logs.LogEntryEntity;

/**
 * 
 * @Description: 日志相关部分 SqlBuilder
 * @author soren
 * @date 2018年1月8日 上午11:21:42
 */
public class LogEntrySqlProvider {
	public static String insertLogEntrys(@Param("entrys") List<LogEntryEntity> entrys) {
		return new SQL() {
			{
				INSERT_INTO("log_entry");
				INTO_COLUMNS("id", "user_id", "op", "bookmark_id", "name", "url", "parent_id", "category",
						"create_time");
				// for (LogEntryEntity value : entrys) {
				// INTO_VALUES(values);
				// }
			}
		}.toString();
	}
}
