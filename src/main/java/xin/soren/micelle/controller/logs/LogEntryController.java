package xin.soren.micelle.controller.logs;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.AuthSubject;
import xin.soren.micelle.controller.AuthTokenHelper;
import xin.soren.micelle.controller.logs.param.LogEntryReportParam;

/**
 * 
 * @Description: 书签日志接口
 * @author soren
 * @date 2017年12月16日 下午5:19:59
 */
@RestController
@RequestMapping("/api/logs")
@Slf4j
public class LogEntryController {
	/**
	 * 
	 * @Description: 获取日志接口
	 * @param lastLogsId
	 * @return
	 * @Throws
	 * @date 2017年12月16日 下午5:25:02
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Api
	public Object getLogsEntry(@RequestParam(value = "lastid", required = false, defaultValue = "0") Long lastLogsId) {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("用户[{}] 的获取日志信息, 最后日志编号: [{}]", subject.userId, lastLogsId);

		return null;
	}

	/**
	 * 
	 * @Description: 推送日志接口
	 * @return
	 * @Throws
	 * @date 2017年12月16日 下午5:31:27
	 */
	@RequestMapping(method = RequestMethod.POST)
	@Api
	public Object postLogsEntry(@Valid @RequestBody LogEntryReportParam param) {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("用户[{}] 的追加日志信息, 参数: [{}]", subject.userId, param);

		return null;
	}
}
