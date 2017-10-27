package xin.soren.micelle.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;
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
	private xin.soren.micelle.service.account.AccountService accountService;

	@Override
	@Transactional
	public Long createUser(String userName, String password, String email, String avatar) {
		Long id = idService.nextUserId();

		log.info("创建用户[{}], userName={}, password={}, email={}, avatar={}", id, userName, password, email, avatar);
		accountService.createAccount(id, password);

		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userEntity.setAccountId(id);
		userEntity.setUserName(userName);
		userEntity.setAvatar(avatar);
		userEntity.setEmail(email);
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
	public Long modifyUserInfo(Long userId, String userName, String email, String avatar) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);

		if (userName != null) {
			userEntity.setUserName(userName);
		}
		if (email != null) {
			userEntity.setEmail(email);
		}
		if (avatar != null) {
			userEntity.setAvatar(avatar);
		}

		return userMapper.updateSelective(userEntity);
	}
}
