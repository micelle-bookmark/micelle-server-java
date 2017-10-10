package xin.soren.micelle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.Define;
import xin.soren.micelle.exception.auth.LessTokenAuthException;

/**
 * 
 * @Description: 认证支持拦截器
 * @author soren
 * @date 2017年10月10日 下午6:26:21
 *
 */
@Component
@Slf4j
public class AuthTokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String token = request.getHeader(Define.TOKEN_HEADER_NAME);
		if (null == token) {
			log.info("请求 {} 中的 {} 认证字段不存在", request.getRequestURL().toString(), Define.TOKEN_HEADER_NAME);
			throw new LessTokenAuthException();
		}

		String body = AuthTokenHelper.parse(token);
		return true;
	}
}
