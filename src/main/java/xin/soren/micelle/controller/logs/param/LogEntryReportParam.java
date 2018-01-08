package xin.soren.micelle.controller.logs.param;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import xin.soren.micelle.common.define.BookmarkOperateType;
import xin.soren.micelle.common.valid.Url;

/**
 * 
 * @Description: 上报 LogEntry 参数
 * @author soren
 * @date 2018年1月8日 上午11:42:26
 */
@Data
public class LogEntryReportParam {
	@Data
	public static class LogEntryReportItem {
		@NotNull(message = "缺少参数操作类型 op")
		private BookmarkOperateType op;

		@NotNull(message = "缺少参数书签名称 name")
		@Length(min = 1, message = "参数 name 长度错误")
		private String name;

		@NotNull(message = "缺少参数书签 URL")
		@Url(message = "参数 url 格式错误")
		private String url;

		@NotNull(message = "缺少参数 parentId")
		private Long parentId;

		@NotNull(message = "缺少参数书签分类 category")
		@Pattern(regexp = "^(dir)|(bookmark)$", message = "参数 category 取值错误")
		private String category;

		private Date createTime;
	}

	@Valid
	@NotNull(message = "参数 entry 不能为空")
	@Size(min = 1, message = "列表 entry 数量不能为0")
	private List<LogEntryReportItem> entry;
}
