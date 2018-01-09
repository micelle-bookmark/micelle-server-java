package xin.soren.micelle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
@SpringBootApplication
// @ComponentScan
@EnableAutoConfiguration
public class MicelleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicelleServerApplication.class, args);
	}
}
