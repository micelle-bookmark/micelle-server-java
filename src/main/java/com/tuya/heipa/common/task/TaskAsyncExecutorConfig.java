package com.tuya.heipa.common.task;

import java.text.MessageFormat;
import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 异步任务初始化
 * @author yangsonglin
 * @date 2017年8月31日 上午10:59:13
 * @version V2.0
 */
@Configuration
@EnableAsync
@Component
@Slf4j
public class TaskAsyncExecutorConfig implements AsyncConfigurer {
	@Autowired
	private TaskAsyncSettings taskAsyncSettings;

	@Override
	public Executor getAsyncExecutor() {
		log.info(MessageFormat.format("使用异步任务配置, {0}", taskAsyncSettings.toString()));

		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(taskAsyncSettings.getCorePoolSize());
		taskExecutor.setMaxPoolSize(taskAsyncSettings.getMaxPoolSize());
		taskExecutor.setQueueCapacity(taskAsyncSettings.getQueueCapacity());
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new TaskAsyncExceptionHandler();
	}
}
