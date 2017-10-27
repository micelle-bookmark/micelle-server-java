package xin.soren.micelle.common.log;

import ch.qos.logback.classic.PatternLayout;

public class LoggingPatternLayout extends PatternLayout {
	static {
		defaultConverterMap.put("ip", IpConverter.class.getName());
		defaultConverterMap.put("port", PortConverter.class.getName());
	}
}
