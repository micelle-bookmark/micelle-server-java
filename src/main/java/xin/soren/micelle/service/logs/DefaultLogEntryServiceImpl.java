package xin.soren.micelle.service.logs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.domain.mapper.logs.LogEntryMapper;
import xin.soren.micelle.domain.model.logs.LogEntryEntity;

/**
 * 
 * @Description: 书签操作记录服务默认实现类
 * @author soren
 * @date 2017年9月29日 下午2:40:32
 *
 */
@Service
@Slf4j
public class DefaultLogEntryServiceImpl implements LogEntryService {

	@Autowired
	private LogEntryMapper mapper;

	@Override
	public List<LogEntryEntity> listLogEntryById(Long userId, Long lastLogsId) {
		List<LogEntryEntity> entrys = mapper.listLogEntryById(userId, lastLogsId);

		Long maxLogsId = null;
		int count = entrys.size();
		if (count > 0) {
			maxLogsId = entrys.get(count - 1).getId();
		}
		log.info("用户[{}] 获取到[{}]条书签操作日志, 上次最大编号[{}], 本次返回最大编号[{}]", userId, count, lastLogsId, maxLogsId);

		return entrys;
	}

	@Override
	public boolean saveLogEntrys(Long userId, List<LogEntryEntity> entrys) {
		// TODO Auto-generated method stub
		return false;
	}

}
