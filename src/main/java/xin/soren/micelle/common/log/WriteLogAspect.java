package xin.soren.micelle.common.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.common.script.IScriptParser;

/**
 * 
 * @Description: WriteLog 注解实现切面
 * @author soren
 * @date 2017年10月8日 下午1:28:54
 *
 */
@Component
@Aspect
@Slf4j
public class WriteLogAspect {

	@Autowired
	IScriptParser scriptParser;

	@Pointcut("@annotation(xin.soren.micelle.common.log.WriteLog)")
	public void annotationPointCut() {
	}

	@Around("annotationPointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		WriteLog writeLog = CommonUtils.getAspect(pjp, WriteLog.class);
		assert writeLog != null;

		Object ret = null;
		if (WriteLog.WriteType.BEFORE == writeLog.type()) {
			doLogBefore(pjp, writeLog);
			ret = pjp.proceed();
		} else {
			ret = pjp.proceed();
			doLogAfter(pjp, ret, writeLog);
		}

		return ret;
	}

	private void doLogAfter(ProceedingJoinPoint pjp, Object ret, WriteLog writeLog) {
		doLog(writeLog.level(), scriptParser.getValue(writeLog.value(), pjp.getArgs(), ret));
	}

	private void doLogBefore(ProceedingJoinPoint pjp, WriteLog writeLog) {
		doLog(writeLog.level(), scriptParser.getValue(writeLog.value(), pjp.getArgs()));
	}

	private void doLog(WriteLog.LogLevel logLevel, String logString) {
		switch (logLevel) {
		case DEBUG:
			log.debug(logString);
			break;
		case INFO:
			log.info(logString);
			break;
		case WARN:
			log.warn(logString);
			break;
		case ERROR:
			log.error(logString);
			break;
		default:
			break;
		}
	}
}
