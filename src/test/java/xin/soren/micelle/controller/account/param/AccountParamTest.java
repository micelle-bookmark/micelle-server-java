package xin.soren.micelle.controller.account.param;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class AccountParamTest {
	@Test
	public void notNullUserNameTest() {
		AccountParam param = new AccountParam();
		param.userName = "123";

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<AccountParam>> violations = vf.getValidator().validate(param);

		assertEquals(violations.size(), 1);
	}
}
