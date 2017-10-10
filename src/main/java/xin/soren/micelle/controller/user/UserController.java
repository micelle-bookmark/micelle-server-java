package xin.soren.micelle.controller.user;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.user.param.TestParam;

/**
 * 
 * @Description: 用户 API 接口
 * @author soren
 * @date 2017年9月24日 上午10:10:49
 *
 */
@RestController
@Slf4j
public class UserController {

	@PostConstruct
	public void init() {
	}

	/**
	 * 
	 * @Description: 获取当前登录用户的个人信息
	 * @param param
	 * @param errors
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:20:35
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	@Api
	public Object getUserInfo(@Valid @RequestBody TestParam param, Errors errors) {
		log.info("登录请求, 参数: {}", param);

		return null;
	}

	/**
	 * 
	 * @Description: 修改当前登录用户的个人信息
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:20:54
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.PATCH)
	@Api
	public Object modifyUserInfo() {
		return null;
	}
}
