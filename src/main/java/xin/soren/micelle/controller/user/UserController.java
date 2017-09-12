package xin.soren.micelle.controller.user;

import java.text.MessageFormat;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.controller.user.param.LoginParam;

@RestController
@Slf4j
public class UserController {

	@RequestMapping(value = "/api/test", method = RequestMethod.POST)
	public Object test(@Valid @RequestBody LoginParam param, Errors errors) {
		if (errors.hasErrors()) {
			log.error(MessageFormat.format("错误: {0}", errors.getFieldError().getDefaultMessage()));
		}

		log.info(MessageFormat.format("参数: {0}", param.toString()));
		return null;
	}

}
