package xin.soren.micelle.common;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.exception.DatabaseException;

/**
 * 
 * @Description: WrapDataAccessException 注解实现切面
 * @author soren
 * @date 2017年9月18日 下午3:47:23
 *
 */
@Component
@Aspect
@Slf4j
public class WrapDataAccessExceptionAspect {

	@Pointcut("@annotation(xin.soren.micelle.common.WrapDataAccessException)")
	public void annotationPointCut() {
	}

	// @Around("annotationPointCut()")
	// public Object around(ProceedingJoinPoint pjp) throws Throwable {
	// try {
	// return pjp.proceed();
	// } catch (DataAccessException e) {
	// log.error("数据访问错误, {}", ExceptionUtils.getStackTrace(e));
	// throw new DatabaseException("数据库错误");
	// }
	// }

	@AfterThrowing(pointcut = "annotationPointCut()", throwing = "ex")
	public void doDataAccessException(DataAccessException ex) {
		log.error("数据访问错误, {}", ExceptionUtils.getStackTrace(ex));
		throw new DatabaseException("数据库错误");
	}
}
