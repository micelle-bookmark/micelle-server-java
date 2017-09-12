package xin.soren.micelle.domain.mapper.bookmark;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import xin.soren.micelle.domain.model.bookmark.BookmarkEntity;

@Mapper
public interface BookmarkMapper {
	@Insert("<script>INSERT INTO bookmark(user_id, name, url, parent_id, depth, category) " + "VALUES"
			+ "<foreach item='bookmark' collection='bookmarks' open='' separator=',' close=''>" + "("
			+ "#{bookmark.userId}, #{bookmark.name}, #{bookmark.url}, "
			+ "#{bookmark.parentId}, #{bookmark.depth}, #{bookmark.category, jdbcType=VARCHAR})</foreach></script>")
	public Long insert(@Param("bookmarks") List<BookmarkEntity> bookmarks);
}
