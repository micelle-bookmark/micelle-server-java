package xin.soren.micelle.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: 公共方法
 * @author soren
 * @date 2017年9月24日 上午9:48:08
 *
 */
@Data
@Slf4j
public class CommonUtils {
	/**
	 * 
	 * @Description: 获取 JoinPoint 上指定的 annotation
	 * @param jp
	 * @param aspectClass
	 * @return
	 * @Throws
	 * @Date 2017年9月24日 上午9:59:58
	 */
	static public <T extends Annotation> T getAspect(JoinPoint jp, Class<T> aspectClass) {
		log.debug("getAspectValue, jp={}, aspectClass={}", jp, aspectClass);

		Signature signature = jp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		return targetMethod.getAnnotation(aspectClass);
	}
}
