package xin.soren.micelle.exception;

/**
 * 
 * @Description: 密码错误
 * @author soren
 * @date 2017年10月11日 下午3:41:01
 *
 */
@SuppressWarnings("serial")
public class WrongPasswordException extends ServiceException {
	public WrongPasswordException() {
		super(ExceptionCodeConst.S_WRONG_PASSWORD, "密码错误");
	}
}
