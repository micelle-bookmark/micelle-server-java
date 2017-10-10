package xin.soren.micelle.exception.auth;

import xin.soren.micelle.exception.ExceptionCodeConst;

/**
 * 
 * @Description: 缺少 token 认证异常
 * @author soren
 * @date 2017年10月10日 下午4:50:01
 *
 */
@SuppressWarnings("serial")
public class LessTokenAuthException extends AuthException {

	public LessTokenAuthException() {
		super(ExceptionCodeConst.C_AUTH_LESS_TOKEN, "缺少 token 字段");
	}

}
