package xin.soren.micelle.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.controller.account.param.AccountParam;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;
import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;
import xin.soren.micelle.service.account.AccountService;
import xin.soren.micelle.service.id.IdService;

/**
 * 
 * @Description: 用户服务实现类
 * @author soren
 * @date 2017年9月12日 上午11:37:58
 *
 */
@Service
@Slf4j
public class DefaultUserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IdService idService;

	@Autowired
	private AccountService accountService;

	@Override
	@Transactional
	public Long createUser(AccountParam param) {
		Long id = idService.nextUserId();

		log.info("创建用户[{}], {}", id, param);
		accountService.createAccount(id, param.password);

		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userEntity.setAccountId(id);
		userEntity.setUserName(param.userName);
		userEntity.setAvatar(param.avatar);
		userEntity.setEmail(param.email);
		userMapper.insert(userEntity);

		return id;
	}

	@Override
	public UserEntity getUserById(Long id) {
		return userMapper.getByUserId(id);
	}

	@Override
	public UserEntity getUserByName(String userName) {
		return userMapper.getByUserName(userName);
	}

	@Override
	@Transactional
	@WriteLog("'修改用户['+#args[0]+']信息: '+#args[1]")
	public Long modifyUserInfo(Long userId, ModifyUserInfoParam param) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);

		if (param.userName != null) {
			userEntity.setUserName(param.userName);
		}
		if (param.email != null) {
			userEntity.setEmail(param.email);
		}
		if (param.avatar != null) {
			userEntity.setAvatar(param.avatar);
		}

		return userMapper.updateSelective(userEntity);
	}
}
