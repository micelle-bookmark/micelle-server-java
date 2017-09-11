package xin.soren.micelle.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.user.UserMapper;

/**
 * @Description: 用户实现类
 * @author yangsonglin
 * @date 2017年9月6日 上午10:54:09
 * @version V2.0
 */
@Component
@Slf4j
public class DefaultUserService implements UserService {
	@Autowired
	public UserMapper mapper;

	@Override
	public Long insertUser(Long id, String userName) {
		// UserEntity userEntity = new UserEntity(id, userName);
		// return mapper.insert(userEntity);
		return 1L;
	}

}
