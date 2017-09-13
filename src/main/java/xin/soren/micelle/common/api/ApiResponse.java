package xin.soren.micelle.common.api;

import lombok.Data;

@Data
public class ApiResponse {
	private long errorCode = 0;
	private String message = "OK";
	private Object data = null;

	public ApiResponse(long errorCode, String message, Object data) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}
}
