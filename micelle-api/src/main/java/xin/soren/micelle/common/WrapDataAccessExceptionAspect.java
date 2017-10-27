package xin.soren.micelle.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.exception.DatabaseException;

/**
 * 
 * @Description: WrapDataAccessException 注解实现切面
 * @author soren
 * @date 2017年9月18日 下午3:47:23
 *
 */
@Component
@Aspect
@Order(1)
@Slf4j
public class WrapDataAccessExceptionAspect {

	@Pointcut("@annotation(xin.soren.micelle.common.WrapDataAccessException)")
	public void annotationPointCut() {
	}

	@AfterThrowing(value = "annotationPointCut()", throwing = "ex")
	public void doDataAccessException(JoinPoint jp, DataAccessException ex) {

		String value = "";

		WrapDataAccessException annotation = CommonUtils.getAspect(jp, WrapDataAccessException.class);
		if (annotation != null) {
			value = annotation.value();
		}

		if (StringUtils.isBlank(value)) {
			log.error("数据访问错误, {}", ExceptionUtils.getStackTrace(ex));
		} else {
			log.error("{}, 数据访问错误, {}", value, ExceptionUtils.getStackTrace(ex));
		}

		throw new DatabaseException("数据库错误");
	}
}
