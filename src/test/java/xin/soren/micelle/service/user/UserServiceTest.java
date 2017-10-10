package xin.soren.micelle.service.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.RedisList;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.component.redis.RedisOperator;
import xin.soren.micelle.domain.mapper.user.UserMapper;

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

	@Autowired
	RedisOperator redisOperator;

	@Autowired
	RedisTemplate redisTemplate;

	// @Autowired
	// RedisList<Long> redisList;

	// @Test
	// public void testInsertUser() {
	// log.info("-------------------- testInsertUser");
	// userService.insertUser(1L, "testUserName");
	// log.info("-------------------- testInsertUser end");
	// }

	@Test
	public void selectUser() {
		// UserEntity userEntity = mapper.getByUserId(1L);
		// log.info(userEntity.toString());
		// Assert.assertNotNull(userEntity);
		List<Long> list = new ArrayList<Long>() {
			{
				add(1L);
				add(2L);
			}
		};
		String key = "redis:list:key";
		// redisOperator.saveList(key, list);

		@SuppressWarnings("unchecked")
		RedisList<Long> l = new DefaultRedisList<Long>(redisTemplate.boundListOps(key));
		// l.addAll(list);
	}

	@Test
	public void updateUser() {
		// Long count = mapper.update(new UserEntity(1L, "testUserNameUpdate"));
		// Assert.assertEquals(count, (Long) 1L);
	}
}
