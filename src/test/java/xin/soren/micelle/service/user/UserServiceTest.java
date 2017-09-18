package xin.soren.micelle.service.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.user.UserMapper;
import xin.soren.micelle.domain.model.user.UserEntity;

@RunWith(SpringRunner.class)
// @SpringBootTest(classes = { DataSourceAutoConfiguration.class,
// UserService.class, UserMapper.class })
// @MapperScan("xin.soren.micelle.domain.mapper.user")
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
		UserEntity userEntity = mapper.getByUserId(1L);
		log.info(userEntity.toString());
		Assert.assertNotNull(userEntity);
	}

	@Test
	public void updateUser() {
		// Long count = mapper.update(new UserEntity(1L, "testUserNameUpdate"));
		// Assert.assertEquals(count, (Long) 1L);
	}
}
