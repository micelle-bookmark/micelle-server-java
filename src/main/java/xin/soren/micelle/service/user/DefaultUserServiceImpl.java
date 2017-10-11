package xin.soren.micelle.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;

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
	UserMapper userMapper;

	@Override
	@Transactional
	public Long createUser(Long id, String userName) {
		log.info("创建用户, id={}, userName={}", id, userName);

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
}
