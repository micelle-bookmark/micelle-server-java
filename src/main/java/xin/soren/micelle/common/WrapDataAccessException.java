package xin.soren.micelle.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 包裹 DataAccessException, 转换为自定义异常
 * @author soren
 * @date 2017年9月18日 下午3:45:18
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WrapDataAccessException {
	String value() default "";
}
