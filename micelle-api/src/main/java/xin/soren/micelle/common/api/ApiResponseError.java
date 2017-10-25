package xin.soren.micelle.common.api;

import java.util.HashMap;

import lombok.Data;

/**
 * 
 * @Description: API 错误应答返回结构
 * @author soren
 * @date 2017年9月13日 下午8:33:12
 *
 */
@Data
public class ApiResponseError extends ApiResponse {
	public ApiResponseError(long errorCode, String message) {
		super(errorCode, message, new HashMap<>());
	}
}
