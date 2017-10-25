package xin.soren.micelle.gateway.bookmark;

import java.util.Date;

import lombok.Data;
import xin.soren.micelle.common.define.BookmarkOperateType;

/**
 * 
 * @Description: 书签操作记录
 * @author soren
 * @date 2017年10月20日 下午9:40:27
 *
 */
@Data
public class Record {
	private Long id;

	private Long userId;
	private BookmarkOperateType op;
	private Long bookmarkId;

	public String name;
	public String url;
	public Long parentId;
	public String category;

	private Date createTime;
}
