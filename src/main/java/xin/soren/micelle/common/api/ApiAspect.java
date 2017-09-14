package xin.soren.micelle.common.api;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.Define;
import xin.soren.micelle.exception.ExceptionCodeConst;
import xin.soren.micelle.exception.ServiceException;

/**
 * 
 * @Description: Api 注解实现切面
 * @author soren
 * @date 2017年9月12日 下午8:12:59
 *
 */
@Aspect
@Component
@Slf4j
public class ApiAspect {

	/**
	 * 将 String 解析为 Long 时使用的默认值
	 */
	private static final Long PARSE_LONG_DEFAULT = 0L;

	@Pointcut("@annotation(xin.soren.micelle.common.api.Api)")
	public void annotationPointCut() {
	}

	@Around("annotationPointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		checkValidationError(pjp);

		return pjp.proceed();
	}

	/**
	 * 
	 * @Description: 检查切面中的 java bean validation errors
	 * @param pjp
	 * @return
	 * @Throws
	 * @Date 2017年9月14日 下午6:15:10
	 */
	private static boolean checkValidationError(ProceedingJoinPoint pjp) {
		Object args[] = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof Errors) {
				Errors errors = (Errors) arg;
				if (errors.hasErrors()) {
					doThrowValidationException(errors.getFieldError().getDefaultMessage());
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @Description: 抛出 validation 异常
	 * @param errorMessage
	 * @Throws
	 * @Date 2017年9月14日 下午6:17:53
	 */
	private static void doThrowValidationException(String errorMessage) {
		log.info("参数 validation 错误, {}", errorMessage);

		List<String> messages = Arrays.asList(StringUtils.split(errorMessage, Define.VALIDATION_MESSAGE_SPLIT_STRING));
		if (messages.size() == 2) {
			Long errorCode = NumberUtils.toLong(messages.get(0), PARSE_LONG_DEFAULT);
			if (PARSE_LONG_DEFAULT.equals(errorCode)) {
				throw new ServiceException(errorCode, messages.get(1));
			}
		}

		throw new ServiceException(ExceptionCodeConst.C_API_ARGS_ERROR, errorMessage);
	}
}
