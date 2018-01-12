package xin.soren.micelle.gateway.user;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.controller.AuthSubject;
import xin.soren.micelle.controller.user.param.ModifyPasswordParam;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;
import xin.soren.micelle.domain.model.account.AccountEntity;
import xin.soren.micelle.domain.model.user.UserEntity;
import xin.soren.micelle.exception.UserNotExsitException;
import xin.soren.micelle.exception.WrongPasswordException;
import xin.soren.micelle.service.account.AccountService;
import xin.soren.micelle.service.auth.AuthService;
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
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AuthService authService;

	// 2小时
	private final Long ttlMillis = 2 * 60 * 60 * 1000L;

	@Override
	public Long createUser(String userName, String password) {
		log.info("创建用户帐号与信息, userName={}, password={}", userName, password);

		return null;
	}

	@Override
	public UserBO getUserInfo(Long userId) {
		UserEntity userEntity = getUserInfoThrow(userId);

		return convert(userEntity);
	}

	@Override
	public void modifyUserInfo(Long userId, ModifyUserInfoParam param) {
		Long count = userService.modifyUserInfo(userId, param);
		if (Objects.equals(count, 1L)) {
			throw new UserNotExsitException(String.format("用户[id=%d]不存在", userId));
		}
	}

	@Override
	public void modifyUserPassword(Long userId, ModifyPasswordParam param) {
		UserEntity userEntity = getUserInfoThrow(userId);

		Long accountId = userEntity.getAccountId();
		accountService.updateAccountPassword(accountId, param.newPassword, param.oldPassword);
	}

	private UserEntity getUserInfoThrow(Long userId) {
		UserEntity userEntity = userService.getUserById(userId);
		if (userEntity == null) {
			throw new UserNotExsitException(String.format("用户[id=%d]不存在", userId));
		}

		return userEntity;
	}

	@Override
	public UserLoginBO login(String userName, String password) {
		UserEntity userEntity = userService.getUserByName(userName);
		if (userEntity == null) {
			throw new UserNotExsitException(String.format("用户[name=%s]不存在", userName));
		}

		AccountEntity accountEntity = accountService.getAccountById(userEntity.getAccountId());
		String oldEnPwd = CommonUtils.encrypt(password, accountEntity.getSalt());
		if (!Objects.equals(oldEnPwd, accountEntity.getPassword())) {
			throw new WrongPasswordException();
		}

		String subject = AuthSubject.Helper.to(AuthSubject.builder().userId(userEntity.getId()).build());
		String token = authService.create(subject, ttlMillis);

		return UserLoginBO.builder().user(convert(userEntity))
				.token(UserLoginBO.TokenBO.builder().token(token).expiresIn(ttlMillis / 1000).build()).build();
	}

	@Override
	public boolean logout(Long userId) {
		return true;
	}

	private UserBO convert(UserEntity userEntity) {
		return UserBO.builder().userId(userEntity.getId()).userName(userEntity.getUserName())
				.avatar(userEntity.getAvatar()).email(userEntity.getEmail()).build();
	}
}
