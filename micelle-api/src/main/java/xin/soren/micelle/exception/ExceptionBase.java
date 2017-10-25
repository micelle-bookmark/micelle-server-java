package xin.soren.micelle.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @Description: 异常基类
 * @author soren
 * @date 2017年9月13日 下午8:49:55
 *
 */
@Data
@AllArgsConstructor
public class ExceptionBase extends RuntimeException {
	/**
	 * @Fields serialVersionUID : version
	 */
	private static final long serialVersionUID = 1L;

	private long errorCode = ExceptionCodeConst.UNKNOWN_ERROR;
	private String errorMsg = "未知错误";
	private HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

	@Override
	public String toString() {
		return String.format("[错误码 {%d}] {%s}", errorCode, errorMsg);
	}

	@Override
	public String getMessage() {
		return toString();
	}
}
