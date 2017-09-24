package xin.soren.micelle.controller.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.account.param.LoginParam;
import xin.soren.micelle.service.id.IdService;

/**
 * 
 * @Description: 帐号 API 接口
 * @author soren
 * @date 2017年9月24日 上午10:10:38
 *
 */
@RestController
@Slf4j
public class AccountController {

	@Autowired
	IdService idService;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	@Api
	public Object login(@Valid @RequestBody LoginParam param, Errors errors) {
		log.info("登录请求, 参数: {}", param);

		return null;
	}

	@RequestMapping(value = "/api/logout", method = RequestMethod.POST)
	@Api
	public Object logout() {
		return null;
	}

	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	@Api
	public Object register() {
		return null;
	}
}
