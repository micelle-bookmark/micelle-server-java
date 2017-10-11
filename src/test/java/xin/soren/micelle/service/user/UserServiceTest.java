package xin.soren.micelle.service.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.controller.user.param.ModifyUserInfoParam;
import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;

@RunWith(SpringRunner.class)
// @SpringBootTest(classes = { DataSourceAutoConfiguration.class,
// UserService.class, UserMapper.class })
// @MapperScan("xin.soren.micelle.domain.mapper.user")
@SpringBootTest
@Slf4j
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Autowired
	UserMapper mapper;

	// @Autowired
	// RedisList<Long> redisList;

	// @Test
	// public void testInsertUser() {
	// log.info("-------------------- testInsertUser");
	// userService.insertUser(1L, "testUserName");
	// log.info("-------------------- testInsertUser end");
	// }

	// @Test
	// public void selectUser() {
	//
	// }

	@Test
	public void updateUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setAccountId(1L);
		userEntity.setAvatar("avatar1");
		userEntity.setEmail("email1");
		userEntity.setUserName("userName1");
		mapper.insert(userEntity);

		UserEntity user = mapper.getByUserId(1L);
		Assert.assertNotNull(user);

		ModifyUserInfoParam param = new ModifyUserInfoParam();
		param.userName = "userName2";
		param.avatar = "avatar2";
		param.email = "email2";
		Long count = userService.modifyUserInfo(1L, param);
		Assert.assertEquals(count, (Long) 1L);

		user = mapper.getByUserId(1L);
		Assert.assertEquals(param.userName, user.getUserName());
		Assert.assertEquals(param.avatar, user.getAvatar());
		Assert.assertEquals(param.email, user.getEmail());
	}
}
