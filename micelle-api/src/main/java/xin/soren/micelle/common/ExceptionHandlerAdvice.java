package xin.soren.micelle.common;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.ApiResponseError;
import xin.soren.micelle.exception.ExceptionBase;
import xin.soren.micelle.exception.ExceptionCodeConst;

/**
 * 
 * @Description: 异常处理
 * @author soren
 * @date 2017年9月13日 下午8:43:21
 *
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Object handleUnknownException(Exception exception) {
		log.error("未知错误, {}", ExceptionUtils.getStackTrace(exception));

		return new ApiResponseError(ExceptionCodeConst.UNKNOWN_ERROR, "未知错误");
	}

	@ExceptionHandler(value = ExceptionBase.class)
	@ResponseBody
	public Object handleExceptionBase(ExceptionBase exceptionBase, HttpServletResponse rsp) {
		log.error("内部错误, {}", ExceptionUtils.getStackTrace(exceptionBase));

		rsp.setStatus(exceptionBase.getStatusCode().value());
		return new ApiResponseError(exceptionBase.getErrorCode(), exceptionBase.getErrorMsg());
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleMissingParameterException(MissingServletRequestParameterException exception) {
		log.error("缺少参数错误, {}", ExceptionUtils.getStackTrace(exception));

		return new ApiResponseError(ExceptionCodeConst.C_ARGS_REQUIRED, exception.getMessage());
	}

	@ExceptionHandler(value = DataAccessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleExcetptionBase(DataAccessException exception) {
		log.error("数据库错误, {}", ExceptionUtils.getStackTrace(exception));

		return new ApiResponseError(ExceptionCodeConst.S_DATABASE_ERROR, "数据库错误");
	}
}
