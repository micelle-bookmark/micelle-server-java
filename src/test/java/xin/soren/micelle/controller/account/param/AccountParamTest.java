package xin.soren.micelle.controller.account.param;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class AccountParamTest {

	@Test
	public void testOkOnLoginClass() {
		AccountParam param = new AccountParam();
		param.userName = "123";
		param.password = "123";

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<AccountParam>> violations = vf.getValidator().validate(param, AccountParam.Login.class);

		// 没有使用 spring boot, 所以 message 是不正确的
		// for (ConstraintViolation<AccountParam> p : violations) {
		// System.out.println(p.getMessage());
		// }

		assertEquals(violations.size(), 0);
	}

	@Test
	public void testOkOnRegisterClass() {
		AccountParam param = new AccountParam();
		param.userName = "123";
		param.password = "123";
		param.avatar = "http://123.com";
		param.email = "123@qq.com";

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<AccountParam>> violations = vf.getValidator().validate(param,
				AccountParam.Register.class);

		assertEquals(violations.size(), 0);
	}
}
