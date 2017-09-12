package xin.soren.micelle.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.user.UserMapper;

/**
 * 
 * @ClassName: DefaultUserServiceImpl
 * @Description: 用户服务实现类
 * @author soren
 * @date 2017年9月12日 上午11:37:58
 *
 */
@Component
@Slf4j
public class DefaultUserServiceImpl implements UserService {
	@Autowired
	public UserMapper mapper;

	@Override
	public Long insertUser(Long id, String userName) {
		// UserEntity userEntity = new UserEntity(id, userName);
		// return mapper.insert(userEntity);
		return 1L;
	}

}
