package xin.soren.micelle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: 日志支持拦截器
 * @author soren
 * @date 2017年10月10日 下午6:26:09
 *
 */
@Component
@Slf4j
public class UrlLoggingInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("访问 URL: {}", request.getRequestURL().toString());

		String request_batch_number = request.getParameter("request_batch_number");
		request_batch_number = StringUtils.isBlank(request_batch_number) ? "" : request_batch_number;
		MDC.put("rbn", request_batch_number);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		MDC.remove("rbn");
	}
}
