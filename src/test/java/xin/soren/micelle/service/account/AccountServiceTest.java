package xin.soren.micelle.service.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.account.AccountMapper;
import xin.soren.micelle.domain.model.account.AccountEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class AccountServiceTest {
	@Autowired
	AccountMapper mapper;

	// @Test
	// public void testInsertAccount() {
	// log.info("test insert account");
	//
	// AccountEntity accountEntity = new AccountEntity();
	// accountEntity.setId(1L);
	// accountEntity.setAccountName("accountName");
	// accountEntity.setPassword("password");
	// accountEntity.setSalt("salt");
	// accountEntity.setCreateTime(new Date());
	// accountEntity.setModifyTime(new Date());
	// Long count = mapper.insert(accountEntity);
	// Assert.assertEquals(count, (Long) 1L);
	// }

	@Test
	public void testGetAccountById() {
		log.info("test select account by id");

		AccountEntity accountEntity = mapper.getById(1L);
	}
}
