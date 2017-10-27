package xin.soren.micelle.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.Define;
import xin.soren.micelle.common.exception.auth.InvalidAuthException;
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
	static private ObjectMapper mapper = new ObjectMapper();

	/**
	 * TOKEN 失效时间, 2小时
	 */
	static private final Long TTL_MILLIS = 2 * 3600 * 1000L;

	static private final String AUTH_ATTRIBUTE_NAME = "AuthSubject";

	@Autowired
	public void setAuthService(AuthService authService) {
		log.info("设置 AuthService");

		AuthTokenHelper.authService = authService;
	}

	/**
	 * 
	 * @Description: 创建 token
	 * @param subject
	 * @return
	 * @throws JsonProcessingException
	 * @Throws
	 * @Date 2017年10月11日 下午1:31:12
	 */
	static public String create(AuthSubject subject) throws JsonProcessingException {
		return Define.TOKEN_HEADER_VALUE_PREFIX
				+ AuthTokenHelper.authService.create(mapper.writeValueAsString(subject), AuthTokenHelper.TTL_MILLIS);
	}

	/**
	 * 
	 * @Description: 解析并验证 token
	 * @param token
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @Throws
	 * @Date 2017年10月11日 下午1:31:30
	 */
	static public AuthSubject parse(String token) throws JsonParseException, JsonMappingException, IOException {
		assert token != null;

		if (!token.startsWith(Define.TOKEN_HEADER_VALUE_PREFIX)) {
			throw new InvalidAuthException("token 格式错误");
		}

		String subject = AuthTokenHelper.authService.parse(token.replace(Define.TOKEN_HEADER_VALUE_PREFIX, ""));
		return mapper.readValue(subject, AuthSubject.class);
	}

	/**
	 * 
	 * @Description: 保存 AuthSubject 到 request
	 * @param subject
	 * @Throws
	 * @Date 2017年10月11日 下午2:05:13
	 */
	static public void setAuthSubject(AuthSubject subject) {
		RequestAttributes attribute = RequestContextHolder.getRequestAttributes();
		attribute.setAttribute(AUTH_ATTRIBUTE_NAME, subject, RequestAttributes.SCOPE_REQUEST);
	}

	/**
	 * 
	 * @Description: 从当前 request 获取 AuthSubject
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:05:31
	 */
	static public AuthSubject getAuthSubject() {
		return (AuthSubject) RequestContextHolder.getRequestAttributes().getAttribute(AUTH_ATTRIBUTE_NAME,
				RequestAttributes.SCOPE_REQUEST);
	}
}
