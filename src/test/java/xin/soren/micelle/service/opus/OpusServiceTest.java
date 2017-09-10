package xin.soren.micelle.service.opus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import xin.soren.micelle.domain.mapper.opus.OpusMapper;
import xin.soren.micelle.domain.model.opus.OpusEntity;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class OpusServiceTest {
	@Autowired
	OpusMapper mapper;

	// @Test
	// public void testInsertOpus() {
	//
	// Long count = mapper.insert(new OpusEntity(1L, "testOpus", 1L));
	// Assert.assertEquals(count, (Long) 1L);
	// }

	@Test
	public void testSelectOpus() {
		OpusEntity opusEntity = mapper.selectById(1L);
		log.info(opusEntity.toString());
		Assert.assertEquals(opusEntity.getId(), (Long) 1L);
	}

	@Test
	public void testUpdateOpus() {
		Long count = mapper.update(new OpusEntity(1L, "testOpus", 2L));
		Assert.assertEquals(count, (Long) 1L);
	}
}
