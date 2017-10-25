package xin.soren.micelle.common.api;

import java.util.HashMap;

import lombok.Data;

/**
 * 
 * @Description: API 正常应答返回结构
 * @author soren
 * @date 2017年9月13日 下午8:33:34
 *
 */
@Data
public class ApiResponseSuccess extends ApiResponse {
	public ApiResponseSuccess(Object data) {
		super(0, "OK", data);

		if (data == null) {
			setData(new HashMap<>());
		}
	}
}
