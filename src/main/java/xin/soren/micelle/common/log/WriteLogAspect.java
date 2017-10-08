package xin.soren.micelle.common.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;

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

	private final ExpressionParser parser = new SpelExpressionParser();

	protected static final String ARGS = "args";

	protected static final String RET_VAL = "retVal";

	protected static final String HASH = "hash";

	protected static final String EMPTY = "empty";

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
		String value = writeLog.value();
		if (value.indexOf("#") != -1 || value.indexOf("'") != -1) {
			StandardEvaluationContext context = new StandardEvaluationContext();

			// Iterator<Map.Entry<String, Method>> it =
			// funcs.entrySet().iterator();
			// while (it.hasNext()) {
			// Map.Entry<String, Method> entry = it.next();
			// context.registerFunction(entry.getKey(), entry.getValue());
			// }
			context.setVariable(ARGS, pjp.getArgs());
			// if (hasRetVal) {
			context.setVariable(RET_VAL, ret);
			// }
			// Expression expression = expCache.get(keySpEL);
			// if (null == expression) {
			Expression expression = parser.parseExpression(value);
			// expCache.put(keySpEL, expression);
			// }
			value = expression.getValue(context, String.class);
		}

		log.info(value);
	}

	private void doLogBefore(ProceedingJoinPoint pjp, WriteLog writeLog) {
		log.info("doLogBefore");
	}
}
