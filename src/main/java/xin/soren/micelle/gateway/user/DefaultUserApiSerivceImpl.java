package xin.soren.micelle.gateway.user;

import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.CommonUtils;
import xin.soren.micelle.controller.user.param.ModifyPasswordParam;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;
import xin.soren.micelle.domain.model.account.AccountEntity;
import xin.soren.micelle.domain.model.user.UserEntity;
import xin.soren.micelle.exception.UserNotExsitException;
import xin.soren.micelle.exception.WrongPasswordException;
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
		UserEntity userEntity = getUserInfoThrow(userId);

		return User.builder().userId(userEntity.getId()).userName(userEntity.getUserName())
				.avatar(userEntity.getAvatar()).email(userEntity.getEmail()).build();
	}

	@Override
	public void modifyUserInfo(Long userId, ModifyUserInfoParam param) {
		UserEntity userEntity = getUserInfoThrow(userId);
	}

	@Override
	public void modifyUserPassword(Long userId, ModifyPasswordParam param) {
		UserEntity userEntity = getUserInfoThrow(userId);

		Long accountId = userEntity.getAccountId();
		AccountEntity accountEntity = accountService.getAccountById(accountId);
		assert accountEntity != null;

		String pwd = CommonUtils.encrypt(param.oldPassword, accountEntity.getSalt());
		if (!Objects.equals(pwd, accountEntity.getPassword())) {
			throw new WrongPasswordException();
		}

		// TODO: 隐藏到 AccountService 中?
		Pair<String, String> newPwd = CommonUtils.encrypt(param.newPassword);

		accountService.updateAccountPassword(accountId, newPwd.getLeft(), newPwd.getRight());
	}

	private UserEntity getUserInfoThrow(Long userId) {
		UserEntity userEntity = userService.getUserById(userId);
		if (userEntity == null) {
			throw new UserNotExsitException(String.format("用户[id=%d]不存在", userId));
		}

		return userEntity;
	}
}
