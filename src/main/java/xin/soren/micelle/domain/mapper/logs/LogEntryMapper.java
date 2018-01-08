package xin.soren.micelle.domain.mapper.logs;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xin.soren.micelle.domain.model.logs.LogEntryEntity;

/**
 * 
 * @Description: 对书签操作记录 mapper
 * @author soren
 * @date 2017年9月29日 下午2:38:08
 *
 */
@Mapper
public interface LogEntryMapper {
	@Select("SELECT id, user_id, op, bookmark_id, name, url, parent_id, category, create_time, modify_time "
			+ "FROM log_entry WHERE #{userId} = user_id AND #{id} > lastLogsId SORT BY id ASC")
	@Results(id = "default", value = { @Result(property = "userId", column = "user_id"),
			@Result(property = "bookmarkId", column = "bookmark_id"),
			@Result(property = "parentId", column = "parent_id"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public List<LogEntryEntity> listLogEntryById(@Param("userId") Long userId, @Param("lastLogsId") Long lastLogsId);

	@Insert({ "<script>",
			"INSERT INTO log_entry(id, user_id, op, bookmark_id, name, url, parent_id, category, create_time) "
					+ "VALUES" + "<foreach item='entry' collection='entrys' open='' separator=',' close=''>" + "("
					+ "#{entry.id}, #{entry.userId}, #{entry.op}, #{entry.bookmarkId}, #{entry.name}, #{entry.url}, #{entry.parentId}, #{entry.category}, #{entry.createTime, jdbcType=TIMESTAMP}"
					+ ")" + "</foreach>",
			"</script>" })
	public Long insertLogEntrys(@Param("entrys") List<LogEntryEntity> entrys);
}
