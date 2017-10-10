package xin.soren.micelle.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public UrlLoggingInterceptor urlLoggingInterceptor() {
		return new UrlLoggingInterceptor();
	}

	@Bean
	public AuthTokenInterceptor authTokenInterceptor() {
		return new AuthTokenInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(urlLoggingInterceptor());

		registry.addInterceptor(authTokenInterceptor()).excludePathPatterns("/api/login")
				.excludePathPatterns("/api/register");
	}
}
