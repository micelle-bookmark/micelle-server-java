package xin.soren.micelle.common.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

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
	@Pointcut("@annotation(xin.soren.micelle.common.api.Api")
	public void annotationPointCut() {
	}

	@Around("annotationPointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		return pjp.proceed();
	}
}
