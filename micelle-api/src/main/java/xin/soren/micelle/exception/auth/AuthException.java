package xin.soren.micelle.exception.auth;

import java.text.MessageFormat;

import xin.soren.micelle.exception.Const;
import xin.soren.micelle.exception.ExceptionBase;

/**
 * 
 * @Description: 认证相关异常类基类
 * @author soren
 * @date 2017年10月10日 下午4:47:52
 *
 */
public class AuthException extends ExceptionBase {

	/**
	 * @Fields serialVersionUID : version
	 */
	private static final long serialVersionUID = 1L;

	public AuthException(long code, String msg) {
		super(code, msg, Const.StatusCode.FORBIDDEN);
	}

	@Override
	public String toString() {
		return MessageFormat.format("[认证错误] {0}", super.toString());
	}
}
