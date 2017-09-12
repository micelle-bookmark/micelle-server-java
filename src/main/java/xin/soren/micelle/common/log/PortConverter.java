package xin.soren.micelle.common.log;

import java.text.MessageFormat;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: 获取容器的端口并设置到logback日志系统中
 * @author yemin
 * @date 2017年7月17日 下午11:19:49
 * @version V2.0
 */
@Component
@Slf4j
public class PortConverter extends ClassicConverter
		implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

	/**
	 * 容器端口
	 */
	private static String port = "     ";

	@Override
	public String convert(ILoggingEvent event) {
		/**
		 * 每打印一次日志都会调用本方法一次
		 */
		return port;
	}

	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		PortConverter.port = String.valueOf(event.getEmbeddedServletContainer().getPort());
		log.info(MessageFormat.format("获取到 server.port={0}", PortConverter.port));
	}

}
