package xin.soren.micelle.controller;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;

@RestController
@Slf4j
@ConfigurationProperties(prefix = "app")
public class IndexController {

	@Setter
	private String name;

	@Setter
	private String version;

	@Data
	@AllArgsConstructor
	public static class App {
		private String name;
		private String version;
	}

	private App app;

	@PostConstruct
	public void init() {
		app = new App(name, version);
		log.info("App, {}", app);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Api
	public Object apiIndex() {
		return app;
	}

	@RequestMapping(value = "/api/version", method = RequestMethod.GET)
	@Api
	public Object apiVersion() {
		return app;
	}
}
