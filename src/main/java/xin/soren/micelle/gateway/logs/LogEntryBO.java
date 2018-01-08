package xin.soren.micelle.gateway.logs;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import xin.soren.micelle.common.define.BookmarkOperateType;

/**
 * 
 * @Description: 日志实体业务对象
 * @author soren
 * @date 2018年1月8日 下午3:53:34
 */
@Data
@Builder
public class LogEntryBO {
	private Long id;
	private Long userId;
	private BookmarkOperateType op;
	private Long bookmarkId;
	private String name;
	private String url;
	private Long parentId;
	private String category;
	private Date createTime;
}
