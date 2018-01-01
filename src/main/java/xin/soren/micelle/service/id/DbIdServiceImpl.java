package xin.soren.micelle.service.id;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.Define;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.id.BizIdMapper;
import xin.soren.micelle.domain.model.id.BizIdEntity;
import xin.soren.micelle.exception.ExceptionCodeConst;
import xin.soren.micelle.exception.ServiceException;

/**
 * 
 * @Description: 数据库ID生成服务类
 * @author soren
 * @date 2017年12月16日 下午8:42:42
 */
@Service("DbId")
@Slf4j
public class DbIdServiceImpl implements IdService {

	@Autowired
	private BizIdMapper mapper;

	@Override
	@WriteLog(value = "'生成UserId: '+#retVal")
	public Long nextUserId() {
		BizIdEntity bizIdEntity = mapper.getByBizTag(Define.BIZ_TAG_USER_ID);
		if (null == bizIdEntity) {
			throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR,
					MessageFormat.format("生成用户ID时 {0} 记录不存在 ", Define.BIZ_TAG_USER_ID));
		}

		log.info("生成下一个 UserId, 当前 [{}]", bizIdEntity);
		Long updateCount = mapper.nextId(Define.BIZ_TAG_USER_ID, bizIdEntity.getMaxId());
		if (updateCount == null || updateCount.equals(0L)) {
			return null;
		}

		return bizIdEntity.getMaxId();
	}

	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public Long nextLogsId() {
		BizIdEntity bizIdEntity = mapper.getByBizTag(Define.BIZ_TAG_LOG_ID);
		if (null == bizIdEntity) {
			throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR,
					MessageFormat.format("生成LOGS ID时 {0} 记录不存在 ", Define.BIZ_TAG_LOG_ID));
		}

		log.info("生成下一个 LogsId, 当前 [{}]", bizIdEntity);
		Long updateCount = mapper.nextId(Define.BIZ_TAG_LOG_ID, bizIdEntity.getMaxId());
		if (updateCount == null || updateCount.equals(0L)) {
			return null;
		}

		return bizIdEntity.getMaxId();
	}

	@SuppressWarnings("serial")
	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public Optional<List<Long>> nextLogsId(int count) {
		BizIdEntity bizIdEntity = mapper.getByBizTag(Define.BIZ_TAG_LOG_ID);
		if (null == bizIdEntity) {
			throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR,
					MessageFormat.format("生成 LOGS ID时 {0} 记录不存在 ", Define.BIZ_TAG_LOG_ID));
		}

		log.info("生成下一批 LogsId, 当前 [{}], 数量 [{}]", bizIdEntity, count);
		Long updateCount = mapper.nextIdWithStep(Define.BIZ_TAG_LOG_ID, bizIdEntity.getMaxId(), new Long(count));
		if (updateCount == null || updateCount.equals(0L)) {
			return Optional.empty();
		}

		return Optional.of(new ArrayList<Long>() {
			{
				for (int step = 0; step < count; ++step) {
					add(bizIdEntity.getMaxId() + step);
				}
			}
		});
	}

}
