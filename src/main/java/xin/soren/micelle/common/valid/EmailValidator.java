package xin.soren.micelle.common.valid;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: Email 格式参数校验实现类
 * @author soren
 * @date 2017年9月13日 下午8:25:12
 *
 */
@Component
@Slf4j
public class EmailValidator implements ConstraintValidator<Email, String> {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@Override
	public void initialize(Email arg0) {
	}

	/**
	 * validation 的过程中会捕获抛出的异常, 然后抛出 javax.validation.ValidationException
	 */
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (arg0 == null || arg0.isEmpty()) {
			return false;
		}

		if (!VALID_EMAIL_ADDRESS_REGEX.matcher(arg0).find()) {
			log.info("Validation Fail Email Address: {}", arg0);
			return false;
		}

		return true;
	}
}
