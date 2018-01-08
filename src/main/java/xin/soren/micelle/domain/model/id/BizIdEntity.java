package xin.soren.micelle.domain.model.id;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @Description: ID记录表
 * @author soren
 * @date 2017年12月17日 上午10:11:57
 */
@Data
public class BizIdEntity {
	// 记录ID
	private Long id;
	// 业务名称, 唯一
	private String bizTag;
	// 当前已分配的最大 ID 值
	private Long maxId;
	// 步长, 不使用
	private Long step;
	// 描述文本
	private String desc;
	private Date createTime;
	private Date updateTime;
}
