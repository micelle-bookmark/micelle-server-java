package xin.soren.micelle.common.task;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Description: 异步任务配置类
 * @author yangsonglin
 * @date 2017年8月31日 上午10:59:53
 * @version V2.0
 */
@Component
@Scope("singleton")
@Primary
@ConfigurationProperties(prefix = "task.async")
@Data
public class TaskAsyncSettings {
	// @Value("${task.async.corePoolSize}")
	private int corePoolSize;

	// @Value("${task.async.maxPoolSize}")
	private int maxPoolSize;

	// @Value("${task.async.queueCapacity}")
	private int queueCapacity;
}
