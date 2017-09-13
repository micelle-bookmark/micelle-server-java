package xin.soren.micelle.exception;

import java.text.MessageFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionBase extends RuntimeException {
	/**
	 * @Fields serialVersionUID : version
	 */
	private static final long serialVersionUID = 1L;

	private String errorMsg = "未知错误";
	private long errorCode = ExceptionCodeConst.UNKNOWN_ERROR;

	@Override
	public String toString() {
		return MessageFormat.format("[错误码 {0}] {1}", errorCode, errorMsg);
	}
}
