package xin.soren.micelle.common.log;

import org.springframework.stereotype.Component;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 
 * @Description: 获取容器的端口并设置到logback日志系统中
 * @author yemin
 * @date 2017年7月17日 下午11:19:49
 * @version V2.0
 */
@Component
public class LoggingPortConverter extends ClassicConverter {

	/**
	 * 容器端口
	 */
	private static String port;

	@Override
	public String convert(ILoggingEvent event) {
		/**
		 * 每打印一次日志都会调用本方法一次
		 */
		return port == null ? "    " : port;
	}

	// @Value("${server.port}")
	public void setPort(String port) {
		LoggingPortConverter.port = port;
	}

}
