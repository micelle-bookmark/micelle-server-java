package xin.soren.micelle.controller.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.AuthSubject;
import xin.soren.micelle.controller.AuthTokenHelper;
import xin.soren.micelle.controller.user.param.ModifyPasswordParam;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;
import xin.soren.micelle.exception.InvalidArgsException;
import xin.soren.micelle.gateway.user.UserApiSerivce;

/**
 * 
 * @Description: 用户 API 接口
 * @author soren
 * @date 2017年9月24日 上午10:10:49
 *
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

	@Autowired
	private UserApiSerivce userApiService;

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
	@RequestMapping(value = "", method = RequestMethod.GET)
	@Api
	public Object getUserInfo() {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("获取用户[{}] 的基本信息", subject.userId);

		return userApiService.getUserInfo(subject.userId);
	}

	/**
	 * 
	 * @Description: 修改当前登录用户的个人信息
	 * @return
	 * @Throws
	 * @Date 2017年9月25日 下午9:20:54
	 */
	@RequestMapping(value = "", method = RequestMethod.PATCH)
	@Api
	public Object modifyUserInfo(@Validated @RequestBody ModifyUserInfoParam param, Errors errors) {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("修改当前用户[{}]个人信息, {}", subject.userId, param);

		Long count = 0L;
		if (param.userName != null) {
			if (param.userName.trim().length() == 0) {
				throw new InvalidArgsException("参数 userName 长度错误");
			}

			count += 1;
		}

		if (param.email != null) {
			if (!CommonUtils.isValidEmail(param.email)) {
				throw new InvalidArgsException("参数 email 格式错误");
			}

			count += 1;
		}

		if (param.avatar != null) {
			if (!CommonUtils.isValidUrl(param.avatar)) {
				throw new InvalidArgsException("参数 avatar 格式错误");
			}

			count += 1;
		}

		if (count.longValue() == 0) {
			throw new InvalidArgsException("至少需要一个参数");
		}

		userApiService.modifyUserInfo(subject.userId, param);
		return null;
	}

	/**
	 * 
	 * @Description: 修改当前登录用户的密码
	 * @param param
	 * @param errors
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午1:40:52
	 */
	@RequestMapping(value = "/pwd", method = RequestMethod.PATCH)
	@Api
	public Object modifyUserPassword(@Validated @RequestBody ModifyPasswordParam param, Errors errors) {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("修改当前用户[{}]密码, {}", subject.userId, param);

		param.newPassword = CommonUtils.base64Decode(param.newPassword);
		param.oldPassword = CommonUtils.base64Decode(param.oldPassword);

		userApiService.modifyUserPassword(subject.userId, param);
		return null;
	}
}
