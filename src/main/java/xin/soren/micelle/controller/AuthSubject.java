package xin.soren.micelle.controller;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.exception.ExceptionCodeConst;
import xin.soren.micelle.exception.ServiceException;

/**
 * 
 * @Description: 认证 token 中的 subject 结构
 * @author soren
 * @date 2017年10月11日 下午1:42:08
 *
 */
@Data
@Builder
@Slf4j
@AllArgsConstructor
public class AuthSubject {
	public Long userId;

	static public class Helper {
		static private ObjectMapper mapper = new ObjectMapper();

		static public String to(AuthSubject subject) {
			try {
				return mapper.writeValueAsString(subject);
			} catch (JsonProcessingException e) {
				log.error(ExceptionUtils.getStackTrace(e));
				throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR, "AuthSubject 序列化失败");
			}
		};

		static public AuthSubject from(String subject) {
			try {
				return mapper.readValue(subject, AuthSubject.class);
			} catch (IOException e) {
				log.error(ExceptionUtils.getStackTrace(e));
				throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR, "AuthSubject 反序列化失败");
			}
		}
	};
}
