package xin.soren.micelle.exception;

/**
 * 
 * @Description: 参数错误
 * @author soren
 * @date 2017年10月11日 下午4:41:02
 *
 */
@SuppressWarnings("serial")
public class InvalidArgsException extends ServiceException {
	public InvalidArgsException(String msg) {
		super(ExceptionCodeConst.C_API_ARGS_ERROR, msg);
	}

	public InvalidArgsException() {
		this("参数错误");
	}
}
