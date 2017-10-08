package xin.soren.micelle.service.id;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;

/**
 * 
 * @Description: ID 生成服务实现类, 该实现类可能会产生重复的 ID
 * @author soren
 * @date 2017年9月24日 下午7:51:01
 *
 */
@Service
@Slf4j
public class DefaultIdServiceImpl implements IdService {

	private static final Long TIMESTAMP_MASK = 0x000001FFFFFFFFFFL;
	private static final Long TIMESTAMP_SHIFT_NUM = 22L;

	private static final Long UUID_MASK = 0x00000000003FFFFFL;

	@Override
	@WriteLog(value = "'生成用户ID: '+#retVal")
	public Long nextUserId() {
		Long id = generateId();
		// log.info("生成用户ID, {}", id);
		return id;
	}

	@Override
	public Long nextBookmarkId() {
		Long id = generateId();
		log.info("生成书签ID, {}", id);
		return id;
	}

	private Long generateId() {
		Integer uuid = UUID.randomUUID().hashCode();
		return generateId(System.currentTimeMillis(), uuid.longValue());
	}

	private Long generateId(Long timestamp, Long sequence) {
		Long id = ((System.currentTimeMillis()
				& DefaultIdServiceImpl.TIMESTAMP_MASK) << DefaultIdServiceImpl.TIMESTAMP_SHIFT_NUM)
				| (sequence & DefaultIdServiceImpl.UUID_MASK);
		return id;
	}

}
