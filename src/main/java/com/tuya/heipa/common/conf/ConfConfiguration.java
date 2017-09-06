package com.tuya.heipa.common.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class ConfConfiguration {
	@Configuration
	@Profile("default")
	@PropertySource("classpath:config/search.properties")
	static class Defaults {
	}

	@Configuration
	@Profile("prod")
	@PropertySource({ "classpath:config/search.properties",
			"classpath:config/search-${spring.profiles.active}.properties" })
	static class ProdConfig {
	}

	@Configuration
	@Profile("dev")
	@PropertySource({ "classpath:config/search.properties",
			"classpath:config/search-${spring.profiles.active}.properties" })
	static class DevConfig {
	}

	@Configuration
	@Profile({ "test", "autotest" })
	@PropertySource({ "classpath:config/search.properties",
			"classpath:config/search-${spring.profiles.active}.properties" })
	static class TestConfig {
	}
}
