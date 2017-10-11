package xin.soren.micelle.exception;

/**
 * 
 * @Description: 加解密等错误
 * @author soren
 * @date 2017年10月11日 下午2:37:38
 *
 */
@SuppressWarnings("serial")
public class EncryptException extends ServiceException {
	public EncryptException(String msg) {
		super(ExceptionCodeConst.S_ENCRYPT_ERROR, msg);
	}
}
