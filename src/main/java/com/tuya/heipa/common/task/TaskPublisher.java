package com.tuya.heipa.common.task;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.tuya.heipa.common.SpringContextUtil;

@Component
public class TaskPublisher {

	/**
	 * 发布app事件
	 * 
	 * @param msg
	 */
	public void publish(Object msg) {
		ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
		applicationContext.publishEvent(new TaskAppEvent(applicationContext, msg));
	}
}
