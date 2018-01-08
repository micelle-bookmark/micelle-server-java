package xin.soren.micelle.gateway.logs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.BookmarkOperateType;
import xin.soren.micelle.controller.logs.param.LogEntryReportParam;
import xin.soren.micelle.domain.model.logs.LogEntryEntity;
import xin.soren.micelle.exception.ExceptionCodeConst;
import xin.soren.micelle.exception.ServiceException;
import xin.soren.micelle.service.id.IdService;
import xin.soren.micelle.service.logs.LogEntryService;

/**
 * 
 * @Description: 操作日志 API 实现类
 * @author soren
 * @date 2018年1月8日 下午3:47:50
 */
@Service
@Slf4j
public class DefaultLogsApiServiceImpl implements LogsApiService {

	@Autowired
	private LogEntryService logEntryService;

	@Autowired
	@Qualifier("DbId")
	private IdService idService;

	@SuppressWarnings("serial")
	@Override
	public List<LogEntryBO> listLogEntryById(Long userId, Long lastLogsId) {
		return new ArrayList<LogEntryBO>() {
			{
				for (LogEntryEntity entity : logEntryService.listLogEntryById(userId, lastLogsId)) {
					add(LogEntryBO.builder().id(entity.getId()).userId(entity.getUserId()).op(entity.getOp())
							.bookmarkId(entity.getBookmarkId()).name(entity.getName()).url(entity.getUrl())
							.parentId(entity.getParentId()).category(entity.getCategory())
							.createTime(entity.getCreateTime()).build());
				}
			}
		};
	}

	@Override
	public boolean saveLogEntrys(Long userId, LogEntryReportParam param) {
		Optional<List<Long>> optionalIds = idService.nextLogsId(param.getEntry().size());
		if (optionalIds == null || !optionalIds.isPresent()) {
			log.error("用户[{}]推送日志时批量生成日志ID失败", userId);
			throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR, "生成日志ID失败");
		}

		List<Long> ids = optionalIds.get();
		@SuppressWarnings("serial")
		List<LogEntryEntity> entitys = new ArrayList<LogEntryEntity>() {
			{
				int count = param.getEntry().size();
				for (int index = 0; index < count; ++index) {
					LogEntryReportParam.LogEntryReportItem item = param.getEntry().get(index);
					LogEntryEntity entity = new LogEntryEntity();

					entity.setId(ids.get(index));
					entity.setUserId(userId);
					entity.setOp(item.getOp());

					if (item.getOp().equals(BookmarkOperateType.ADD)) {
						Optional<Long> optionalBookmarkId = idService.nextBookmarkId();
						if (optionalBookmarkId == null || !optionalBookmarkId.isPresent()) {
							log.error("用户[{}]推送日志时生成书签ID失败", userId);
							throw new ServiceException(ExceptionCodeConst.S_INTERAL_ERROR, "生成书签ID失败");
						}
						entity.setBookmarkId(optionalBookmarkId.get());

						log.info("为日志记录[{}]生成书签ID[{}]", entity.getId(), entity.getBookmarkId());
					} else {
						entity.setBookmarkId(item.getBookmarkId());
					}

					entity.setName(item.getName());
					entity.setUrl(item.getUrl());
					entity.setParentId(item.getParentId());
					entity.setCategory(item.getCategory());

					if (item.getCreateTime() != null) {
						entity.setCreateTime(item.getCreateTime());
					} else {
						entity.setCreateTime(new Date());
					}

					add(entity);
				}
			}
		};

		Long insertCount = logEntryService.saveLogEntrys(userId, entitys);
		if (insertCount.longValue() == 0) {
			return false;
		}

		return true;
	}

}
