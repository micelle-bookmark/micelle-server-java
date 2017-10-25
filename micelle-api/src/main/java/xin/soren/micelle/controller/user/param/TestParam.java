package xin.soren.micelle.controller.user.param;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestParam {
	@Data
	@NoArgsConstructor
	static public class Param {
		@NotNull(message = "param 参数为空")
		@Length(min = 1, message = "param 参数长度错误")
		public String param;
	}

	@Valid
	@NotNull(message = "file 不能为空")
	@Size(min = 1, message = "列表不能空0")
	public List<Param> file;

	@NotNull(message = "size 不能为空")
	// @Size(min = 1, max = 3)
	@Range(min = 1, max = 3, message = "需要在 [1,3] 的范围内")
	public Long size;
}
