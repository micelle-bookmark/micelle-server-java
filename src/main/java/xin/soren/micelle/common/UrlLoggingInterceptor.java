package xin.soren.micelle.common;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UrlLoggingInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info(MessageFormat.format("访问 URL: {0}", request.getRequestURL().toString()));

		// this.addmdc(request);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// this.clenmdc();
	}

	// /**
	// * 向MDC中加入请求批次号、token、会员id信息，以便在logback日志打印时输出
	// *
	// * @param request
	// */
	// private void addmdc(HttpServletRequest request) {
	// String request_batch_number =
	// request.getParameter("request_batch_number");
	// request_batch_number = StringUtils.isBlank(request_batch_number) ? "" :
	// request_batch_number;
	// String token = HttpHeaderUtil.getAccessToken();
	// token = StringUtils.isBlank(token) ? "" : token;
	// MDC.put("rbn", request_batch_number);
	// MDC.put("token", token);
	// MDC.put("memberId", "");
	// }
	//
	// /**
	// * 清除之前加入的请求批次号、token、会员id信息
	// */
	// private void clenmdc() {
	// MDC.remove("rbn");
	// MDC.remove("token");
	// MDC.remove("memberId");
	// }
}
