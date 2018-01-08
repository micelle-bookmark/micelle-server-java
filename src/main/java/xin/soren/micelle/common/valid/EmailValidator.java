package xin.soren.micelle.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;

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

	@Override
	public void initialize(Email arg0) {
	}

	/**
	 * validation 的过程中会捕获抛出的异常, 然后抛出 javax.validation.ValidationException
	 */
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext constraintValidatorContext) {
		if (arg0 == null || arg0.isEmpty()) {
			// 覆盖默认的 message
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate("").addConstraintViolation();
			return false;
		}

		if (!CommonUtils.isValidEmail(arg0)) {
			log.info("Validation Fail Email Address: {}", arg0);
			return false;
		}

		return true;
	}
}
