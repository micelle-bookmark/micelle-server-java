package xin.soren.micelle.common.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 方法日志记录切面
 * @author soren
 * @date 2017年10月8日 上午11:58:56
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
@Documented
public @interface WriteLog {
	public String value() default "";

	public WriteType type() default WriteType.AFTER;

	public LogLevel level() default LogLevel.INFO;

	public enum WriteType {
		BEFORE, AFTER
	}

	public enum LogLevel {
		DEBUG, INFO, WARN, ERROR, CRITICAL
	}
}
