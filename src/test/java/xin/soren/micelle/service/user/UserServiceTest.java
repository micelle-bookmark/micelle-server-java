package xin.soren.micelle.service.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Autowired
	UserMapper mapper;

	// @Test
	// public void testInsertUser() {
	// log.info("-------------------- testInsertUser");
	// userService.insertUser(1L, "testUserName");
	// log.info("-------------------- testInsertUser end");
	// }

	@Test
	public void selectUser() {
		UserEntity userEntity = mapper.selectById(1L);
		log.info(userEntity.toString());
		Assert.assertNotNull(userEntity);
	}

	@Test
	public void updateUser() {
		Long count = mapper.update(new UserEntity(1L, "testUserNameUpdate"));
		Assert.assertEquals(count, (Long) 1L);
	}
}
