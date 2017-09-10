package xin.soren.micelle.common.log;

import ch.qos.logback.classic.PatternLayout;

public class LoggingPatternLayout extends PatternLayout {
	static {
		defaultConverterMap.put("ip", LoggingIpConverter.class.getName());
		defaultConverterMap.put("port", LoggingPortConverter.class.getName());
	}
}
