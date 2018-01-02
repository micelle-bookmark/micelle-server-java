package xin.soren.micelle.service.id;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;

/**
 * 
 * @Description: UUID ID 生成服务实现类, 该实现类可能会产生重复的 ID
 * @author soren
 * @date 2017年9月24日 下午7:51:01
 *
 */
@Service("UUIDId")
@Slf4j
public class UUIDIdServiceImpl implements IdService {

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
	@WriteLog(value = "'生成UserId: '+#retVal")
	public Optional<Long> nextUserId() {
		return Optional.of(generateId());
	}

	@Override
	@WriteLog(value = "'生成 AccountId: '+#retVal")
	public Optional<Long> nextAccountId() {
		return Optional.of(generateId());
	}

	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public Optional<Long> nextLogsId() {
		return Optional.of(generateId());
	}

	@SuppressWarnings("serial")
	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public Optional<List<Long>> nextLogsId(int count) {
		return Optional.of(new ArrayList<Long>() {
			{
				for (int i = 0; i < count; ++i) {
					add(generateId());
				}
			}
		});
	}

	private Long generateId() {
		Integer uuid = UUID.randomUUID().hashCode();
		return generateId(System.currentTimeMillis(), uuid.longValue());
	}

	private Long generateId(Long timestamp, Long sequence) {
		Long id = (((System.currentTimeMillis() - timeDatum)
				& UUIDIdServiceImpl.TIMESTAMP_MASK) << UUIDIdServiceImpl.TIMESTAMP_SHIFT_NUM)
				| (sequence & UUIDIdServiceImpl.UUID_MASK);
		return id;
	}
}
