package xin.soren.micelle.common.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 对 Api 接口进行参数校验和结果转换
 * @author soren
 * @date 2017年9月12日 下午8:10:48
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Api {
	String value() default "";
}
