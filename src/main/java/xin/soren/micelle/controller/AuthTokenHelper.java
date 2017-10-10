package xin.soren.micelle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.Define;
import xin.soren.micelle.exception.auth.InvalidAuthException;
import xin.soren.micelle.service.auth.AuthService;

/**
 * 
 * @Description: Auth Token 帮助类
 * @author soren
 * @date 2017年10月10日 下午6:49:18
 *
 */
@Component
@Slf4j
public class AuthTokenHelper {
	static private AuthService authService;

	/**
	 * TOKEN 失效时间, 2小时
	 */
	static private final Long TTL_MILLIS = 2 * 3600 * 1000L;

	@Autowired
	public void setAuthService(AuthService authService) {
		log.info("设置 AuthService");

		AuthTokenHelper.authService = authService;
	}

	static public String create(String subject) {
		return Define.TOKEN_HEADER_VALUE_PREFIX
				+ AuthTokenHelper.authService.create(subject, AuthTokenHelper.TTL_MILLIS);
	}

	static public String parse(String token) {
		assert token != null;

		if (!token.startsWith(Define.TOKEN_HEADER_VALUE_PREFIX)) {
			throw new InvalidAuthException("token 格式错误");
		}

		return AuthTokenHelper.authService.parse(token.replace(Define.TOKEN_HEADER_VALUE_PREFIX, ""));
	}
}
