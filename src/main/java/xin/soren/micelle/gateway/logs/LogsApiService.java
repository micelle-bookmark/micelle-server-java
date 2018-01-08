package xin.soren.micelle.gateway.logs;

import java.util.List;

import xin.soren.micelle.controller.logs.param.LogEntryReportParam;

/**
 * 
 * @Description: 操作日志 API 接口类
 * @author soren
 * @date 2018年1月8日 下午3:47:29
 */
public interface LogsApiService {
	public List<LogEntryBO> listLogEntryById(Long userId, Long lastLogsId);

	public boolean saveLogEntrys(Long userId, LogEntryReportParam param);
}
