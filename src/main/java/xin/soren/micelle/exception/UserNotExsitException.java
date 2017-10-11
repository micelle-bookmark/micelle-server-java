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
		super(ExceptionCodeConst.S_USER_DOESNOT_EXSIT, "用户不存在");
	}
}
