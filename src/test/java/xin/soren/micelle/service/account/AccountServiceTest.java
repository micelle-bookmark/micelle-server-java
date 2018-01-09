package xin.soren.micelle.service.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.account.AccountMapper;
import xin.soren.micelle.domain.model.account.AccountEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountServiceTest {
	@Autowired
	AccountMapper mapper;

	@Test
	public void testUpdate() {
		log.info("test update account");

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(1L);
		accountEntity.setAccountName("accountName");
		accountEntity.setPassword("password");
		accountEntity.setSalt("salt");
		// accountEntity.setCreateTime(new Date());
		// accountEntity.setModifyTime(new Date());

		mapper.insertSelective(accountEntity);
		// mapper.insertSelective(accountEntity);
		// Long count = mapper.updatePassword(accountEntity);
		// log.info("update {}", count);

		AccountEntity entity = mapper.getById(1L);
		log.info("account entity: {}", entity);
	}

	@Test
	public void testGetAccountById() {
		log.info("test select account by id");

		AccountEntity accountEntity = mapper.getById(1L);
	}
}
