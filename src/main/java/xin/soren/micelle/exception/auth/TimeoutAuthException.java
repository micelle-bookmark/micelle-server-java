package xin.soren.micelle.exception.auth;

import xin.soren.micelle.exception.ExceptionCodeConst;

/**
 * 
 * @Description: token 失效
 * @author soren
 * @date 2017年10月10日 下午5:11:14
 *
 */
@SuppressWarnings("serial")
public class TimeoutAuthException extends AuthException {

	public TimeoutAuthException() {
		super(ExceptionCodeConst.C_AUTH_TIMEOUT, "token 已过期");
	}

}
