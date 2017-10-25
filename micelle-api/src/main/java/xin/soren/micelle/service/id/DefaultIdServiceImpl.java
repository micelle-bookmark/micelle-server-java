package xin.soren.micelle.service.id;

import java.util.Calendar;
import java.util.UUID;

import javax.annotation.PostConstruct;

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

	private Calendar calendarDatum = Calendar.getInstance();
	private Long timeDatum;

	@PostConstruct
	public void init() {
		calendarDatum.set(2017, 1, 26, 0, 0, 0);
		timeDatum = calendarDatum.getTimeInMillis();

		log.info("使用基准时间: {}, {}", calendarDatum, timeDatum);
	}

	@Override
	@WriteLog(value = "'生成用户ID: '+#retVal")

	public Long nextUserId() {
		return generateId();
	}

	@Override
	@WriteLog(value = "'生成书签ID: '+#retVal")
	public Long nextBookmarkId() {
		return generateId();
	}

	@Override
	@WriteLog(value = "'生成 RecordID: '+#retVal")
	public Long nextRecordId() {
		return generateId();
	}

	private Long generateId() {
		Integer uuid = UUID.randomUUID().hashCode();
		return generateId(System.currentTimeMillis(), uuid.longValue());
	}

	private Long generateId(Long timestamp, Long sequence) {
		Long id = (((System.currentTimeMillis() - timeDatum)
				& DefaultIdServiceImpl.TIMESTAMP_MASK) << DefaultIdServiceImpl.TIMESTAMP_SHIFT_NUM)
				| (sequence & DefaultIdServiceImpl.UUID_MASK);
		return id;
	}

}
