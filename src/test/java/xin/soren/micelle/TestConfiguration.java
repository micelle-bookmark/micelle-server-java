package xin.soren.micelle;

import javax.annotation.PostConstruct;

import org.h2.engine.Mode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@Profile("test")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TestConfiguration {

	@PostConstruct
	public void tweakH2CompatibilityMode() {
		log.info("Tweaking MYSQL compatibility mode for H2 database:");
		Mode mode = Mode.getInstance("MYSQL");

		log.info("Setting convertInsertNullToZero to false");
		// mode.convertInsertNullToZero = false;
	}
}
