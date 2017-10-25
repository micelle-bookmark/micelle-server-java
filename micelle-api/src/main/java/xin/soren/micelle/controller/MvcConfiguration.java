package xin.soren.micelle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	private MessageSource messageSource;

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
				.excludePathPatterns("/api/register").excludePathPatterns("/");
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}
}
