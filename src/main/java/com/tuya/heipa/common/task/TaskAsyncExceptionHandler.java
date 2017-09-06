package com.tuya.heipa.common.task;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 异步任务的异常处理
 * @author yangsonglin
 * @date 2017年8月31日 上午10:57:51
 * @version V2.0
 */
@Slf4j
public class TaskAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
		log.error(MessageFormat.format("异步任务执行失败, {0}", ExceptionUtils.getStackTrace(arg0)));
	}

}
