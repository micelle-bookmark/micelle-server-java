package com.tuya.heipa.common;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 初始化类
 * @author yangsonglin
 * @date 2017年8月25日 下午2:07:09
 * @version V2.0
 */
@Component
@Slf4j
public class InitDataListener implements InitializingBean, ServletContextAware {

	/**
	 * 在 bean init 之前调用
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet");
	}

	/**
	 * 获取 ServletContext
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
	}

}
