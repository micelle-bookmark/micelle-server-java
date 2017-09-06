package com.tuya.heipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class SearchServerApplication {
	public static void main(String[] args) {
		log.info("start");
		SpringApplication.run(SearchServerApplication.class, args);
	}
}
