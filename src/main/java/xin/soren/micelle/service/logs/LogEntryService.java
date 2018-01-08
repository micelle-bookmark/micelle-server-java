package xin.soren.micelle.service.logs;

import java.util.List;

import xin.soren.micelle.domain.model.logs.LogEntryEntity;

/**
 * 
 * @Description: 书签操作记录服务接口类
 * @author soren
 * @date 2017年9月29日 下午2:39:50
 *
 */
public interface LogEntryService {
	/**
	 * 
	 * @Description: 获取日志列表
	 * @param userId
	 * @param lastLogsId,
	 *            最后的日志编号
	 * @return
	 * @Throws
	 * @date 2018年1月8日 上午11:03:50
	 */
	public List<LogEntryEntity> listLogEntryById(Long userId, Long lastLogsId);

	/**
	 * 
	 * @Description: 保存日志信息
	 * @param userId
	 * @param entrys
	 * @return
	 * @Throws
	 * @date 2018年1月8日 上午11:04:19
	 */
	public boolean saveLogEntrys(Long userId, List<LogEntryEntity> entrys);
}
