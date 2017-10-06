package xin.soren.micelle.domain.model.record;

import java.util.Date;

import lombok.Data;
import xin.soren.micelle.common.define.Define;

/**
 * 
 * @Description: 数据操作记录 DO
 * @author soren
 * @date 2017年9月29日 下午2:38:48
 *
 */
@Data
public class RecordEntity {
	private Long id;

	private Long userId;
	private Define.BookmarkOperateType op;
	private Long bookmarkId;
	public String name;
	public String url;
	public Long parentId;
	public String category;

	private Date createTime;
	private Date modifyTime;
}
