package xin.soren.micelle.exception.auth;

import xin.soren.micelle.exception.ExceptionCodeConst;

/**
 * 
 * @Description: 无效的 token 值
 * @author soren
 * @date 2017年10月10日 下午5:09:39
 *
 */
@SuppressWarnings("serial")
public class InvalidAuthException extends AuthException {

	public InvalidAuthException(String msg) {
		super(ExceptionCodeConst.C_AUTH_INVALID, msg);
	}

	public InvalidAuthException() {
		this("无效的 token 值");
	}
}
