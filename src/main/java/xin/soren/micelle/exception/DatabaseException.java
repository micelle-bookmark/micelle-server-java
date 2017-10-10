package xin.soren.micelle.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;

/**
 * 
 * @Description: 数据访问异常
 * @author soren
 * @date 2017年9月18日 下午3:49:35
 *
 */
public class DatabaseException extends ExceptionBase {

	/**
	 * @Fields serialVersionUID : version
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg) {
		super(ExceptionCodeConst.S_DATABASE_ERROR, msg, HttpStatus.OK);
	}

	@Override
	public String toString() {
		return MessageFormat.format("[数据访问错误] {0}", super.toString());
	}
}
