package xin.soren.micelle.gateway.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.service.account.AccountService;
import xin.soren.micelle.service.id.IdService;
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
	IdService idService;

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@Override
	public Long createUser(String userName, String password) {
		log.info("创建用户帐号与信息, userName={}, password={}", userName, password);

		Long userId = idService.nextUserId();
		return doCreateUser(userId, userName, password);
	}

	@Transactional
	public Long doCreateUser(Long id, String userName, String password) {
		accountService.createAccount(id, userName, password, "");
		userService.createUser(id, userName);

		return id;
	}

}
