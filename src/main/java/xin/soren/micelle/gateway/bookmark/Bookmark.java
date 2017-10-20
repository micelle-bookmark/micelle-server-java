package xin.soren.micelle.gateway.bookmark;

import java.util.Date;

import lombok.Data;
import xin.soren.micelle.common.define.BookmarkCategory;

/**
 * 
 * @Description: 书签信息
 * @author soren
 * @date 2017年10月20日 下午9:39:02
 *
 */
@Data
public class Bookmark {
	public Long id;
	public Long userId;
	public String name;
	public String url;
	public Long parentId;
	public BookmarkCategory category;
	public Date createTime;
}
