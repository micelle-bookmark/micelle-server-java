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
	// 日志记录ID
	private Long id;

	// 所属用户
	private Long userId;
	// 操作类型
	private BookmarkOperateType op;

	// 操作目标ID, 如果为新增书签则服务端分配
	private Long bookmarkId;
	// 书签名称
	public String name;
	// 书签URL
	public String url;
	// 父目录ID, 没有则为 0
	public Long parentId;
	// 书签分类
	public String category;

	private Date createTime;
	private Date modifyTime;
}
