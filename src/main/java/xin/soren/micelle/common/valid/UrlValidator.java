package xin.soren.micelle.common.valid;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: URL 格式参数校验实现类
 * @author soren
 * @date 2017年10月11日 下午1:50:21
 *
 */
@Component
@Slf4j
public class UrlValidator implements ConstraintValidator<Url, String> {

	private static final Pattern VALID_URL_ADDRESS_REGEX = Pattern.compile(
			"^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$", Pattern.CASE_INSENSITIVE);

	@Override
	public void initialize(Url paramA) {
	}

	@Override
	public boolean isValid(String paramT, ConstraintValidatorContext paramConstraintValidatorContext) {
		if (!VALID_URL_ADDRESS_REGEX.matcher(paramT).find()) {
			log.info("Validation Fail Email Address: {}", paramT);
			return false;
		}

		return true;
	}

}
