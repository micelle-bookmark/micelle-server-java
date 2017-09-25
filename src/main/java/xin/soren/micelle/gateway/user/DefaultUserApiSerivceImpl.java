package xin.soren.micelle.gateway.user;

import org.springframework.beans.factory.annotation.Autowired;

import xin.soren.micelle.service.id.IdService;

/**
 * 
 * @Description: 用户 API 实现类
 * @author soren
 * @date 2017年9月25日 下午9:23:14
 *
 */
public class DefaultUserApiSerivceImpl implements UserApiSerivce {

	@Autowired
	IdService idService;

	@Override
	public Long createUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
