package xin.soren.micelle.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;

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

	@Override
	public void initialize(Url paramA) {
	}

	@Override
	public boolean isValid(String paramT, ConstraintValidatorContext paramConstraintValidatorContext) {
		if (paramT == null || paramT.isEmpty()) {
			return false;
		}

		if (!CommonUtils.isValidUrl(paramT)) {
			log.info("Validation Fail Email Address: {}", paramT);
			return false;
		}

		return true;
	}

}
