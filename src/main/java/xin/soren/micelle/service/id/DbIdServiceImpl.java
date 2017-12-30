package xin.soren.micelle.service.id;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.Define;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.id.BizIdMapper;
import xin.soren.micelle.domain.model.id.BizIdEntity;

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

		}

		log.info("生成下一个 UserId, 当前 [{}]", bizIdEntity);
		return mapper.nextId(Define.BIZ_TAG_USER_ID, bizIdEntity.getMaxId());
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
