package xin.soren.micelle.controller.user;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.user.param.LoginParam;
import xin.soren.micelle.controller.user.param.TestParam;

@RestController
@Slf4j
public class UserController {

	@RequestMapping(value = "/api/test", method = RequestMethod.POST)
	public Object test(@Valid @RequestBody TestParam param, Errors errors) {
		log.info("参数: {0}", param.toString());
		return null;
	}

	@RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
	@Api
	public Object apiLogin(@Valid @RequestBody LoginParam param, Errors errors) {
		log.info("登录请求, 参数: {}", param);

		return null;
	}

}
