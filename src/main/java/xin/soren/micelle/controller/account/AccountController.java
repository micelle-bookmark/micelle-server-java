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
import xin.soren.micelle.gateway.user.UserApiSerivce;

/**
 * 
 * @Description: 帐号 API 接口
 * @author soren
 * @date 2017年9月24日 上午10:10:38
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class AccountController {

	@Autowired
	UserApiSerivce userApiService;

	/**
	 * 
	 * @Description: 登录接口
	 * @param param
	 * @param errors
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:17:14
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Api
	public Object login(@Valid @RequestBody LoginParam param, Errors errors) {
		log.info("登录请求, 参数: {}", param);

		return null;
	}

	/**
	 * 
	 * @Description: 退出登录接口
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:17:22
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@Api
	public Object logout() {
		return null;
	}

	/**
	 * 
	 * @Description: 注册接口
	 * @param param
	 * @param errors
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:17:31
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Api
	public Object register(@Valid @RequestBody LoginParam param, Errors errors) {
		log.info("注册请求, 参数: {}", param);

		return null;
	}
}
