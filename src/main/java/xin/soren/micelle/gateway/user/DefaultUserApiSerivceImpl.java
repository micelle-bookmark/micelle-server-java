package xin.soren.micelle.gateway.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.model.user.UserEntity;
import xin.soren.micelle.exception.UserNotExsitException;
import xin.soren.micelle.service.account.AccountService;
import xin.soren.micelle.service.user.UserService;

/**
 * 
 * @Description: 用户 API 实现类
 * @author soren
 * @date 2017年9月25日 下午9:23:14
 *
 */
@Component
@Slf4j
public class DefaultUserApiSerivceImpl implements UserApiSerivce {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@Override
	public Long createUser(String userName, String password) {
		log.info("创建用户帐号与信息, userName={}, password={}", userName, password);

		return null;
	}

	@Override
	public User getUserInfo(Long userId) {
		UserEntity userEntity = userService.getUserById(userId);
		if (userEntity == null) {
			log.error("用户不存在, id={}", userId);
			throw new UserNotExsitException();
		}

		return User.builder().userId(userEntity.getId()).userName(userEntity.getUserName())
				.avatar(userEntity.getAvatar()).email(userEntity.getEmail()).build();
	}

}
