package xin.soren.micelle.exception;

/**
 * 
 * @Description: 用户不存在错误
 * @author soren
 * @date 2017年10月11日 下午2:55:18
 *
 */
@SuppressWarnings("serial")
public class UserNotExsitException extends ServiceException {
	public UserNotExsitException() {
		this("用户不存在");
	}

	public UserNotExsitException(String msg) {
		super(ExceptionCodeConst.S_USER_DOESNOT_EXSIT, msg);
	}
}
