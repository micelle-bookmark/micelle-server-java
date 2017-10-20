package xin.soren.micelle.domain.mapper.bookmark;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xin.soren.micelle.common.define.DeleteStatus;
import xin.soren.micelle.common.define.EnumIntHandler;
import xin.soren.micelle.domain.model.bookmark.BookmarkEntity;

@Mapper
public interface BookmarkMapper {
	@Select("select id, user_id, name, url, parent_id, is_delete, category, create_time, modify_time from bookmark where id=#{id}")
	@Results(id = "default", value = { @Result(property = "userId", column = "user_id"),
			@Result(property = "parentId", column = "parent_id"),
			@Result(property = "isDelete", column = "is_delete", typeHandler = EnumIntHandler.class, javaType = DeleteStatus.class),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public BookmarkEntity getById(@Param("id") Long id);

	@Select("select id, user_id, name, url, parent_id, is_delete, category, create_time, modify_time from bookmark where user_id=#{userId} and is_delete=0")
	@ResultMap("default")
	public List<BookmarkEntity> listAll(@Param("userId") Long userId);

	@Insert("<script>INSERT INTO bookmark(user_id, name, url, parent_id, category, is_delete) " + "VALUES"
			+ "<foreach item='bookmark' collection='bookmarks' open='' separator=',' close=''>" + "("
			+ "#{bookmark.userId}, #{bookmark.name}, #{bookmark.url}, "
			+ "#{bookmark.parentId}, #{bookmark.category, jdbcType=VARCHAR}, "
			+ "#{bookmark.isDelete, jdbcType=INTEGER, javaType=xin.soren.micelle.common.define.DeleteStatus, typeHandler=xin.soren.micelle.common.define.EnumIntHandler})</foreach></script>")
	public Long insert(@Param("bookmarks") List<BookmarkEntity> bookmarks);
}
