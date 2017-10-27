package xin.soren.micelle.common.exception.auth;

import xin.soren.micelle.common.exception.ExceptionCodeConst;

/**
 * 
 * @Description: 内部认证错误
 * @author soren
 * @date 2017年10月10日 下午5:07:31
 *
 */
@SuppressWarnings("serial")
public class InternalAuthException extends AuthException {

	public InternalAuthException(String msg) {
		super(ExceptionCodeConst.C_AUTH_INTERVAL_ERROR, msg);
	}

	public InternalAuthException() {
		this("服务器内部认证异常");
	}
}
