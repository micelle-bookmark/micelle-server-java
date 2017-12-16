package xin.soren.micelle.service.id;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;

/**
 * 
 * @Description: 数据库ID生成服务类
 * @author soren
 * @date 2017年12月16日 下午8:42:42
 */
@Service("DbId")
@Slf4j
public class DbIdServiceImpl implements IdService {

	@Override
	@WriteLog(value = "'生成UserId: '+#retVal")
	public Long nextUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public Long nextLogsId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WriteLog(value = "'生成 LogsId: '+#retVal")
	public List<Long> nextLogsId(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
