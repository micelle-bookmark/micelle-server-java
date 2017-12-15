package xin.soren.micelle.domain.model.logs;

import java.util.Date;

import lombok.Data;
import xin.soren.micelle.common.define.BookmarkOperateType;

/**
 * 
 * @Description: 数据操作记录 DO, 仿造 raft 协议命名为 LogEntry
 * @author soren
 * @date 2017年9月29日 下午2:38:48
 *
 */
@Data
public class LogEntryEntity {
	private Long id;

	private Long userId;
	private BookmarkOperateType op;
	private Long bookmarkId;

	public String name;
	public String url;
	public Long parentId;
	public String category;

	private Date createTime;
	private Date modifyTime;
}
