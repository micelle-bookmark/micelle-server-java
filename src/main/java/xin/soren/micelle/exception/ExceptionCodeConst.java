package xin.soren.micelle.exception;

/**
 * 
 * @Description: 错误码定义
 * @author soren
 * @date 2017年9月13日 下午8:36:48
 *
 */
public class ExceptionCodeConst {
	/**
	 * 未知错误
	 */
	public static final Long UNKNOWN_ERROR = 999999L;

	/**
	 * 参数错误, 以 10 开头的6位数数字
	 */
	// 缺少参数
	public static final Long C_ARGS_REQUIRED = 100001L;
	// 参数错误
	public static final Long C_API_ARGS_ERROR = 100002L;

	// 缺少 token
	public static final Long C_AUTH_LESS_TOKEN = 100100L;
	// token 过期
	public static final Long C_AUTH_TIMEOUT = 100101L;
	// 无效的 token 值, 包括格式错误, 签名错误等
	public static final Long C_AUTH_INVALID = 100102L;
	// 内部认证错误
	public static final Long C_AUTH_INTERVAL_ERROR = 100103L;

	// 服务器内部错误
	public static final Long S_INTERAL_ERROR = 200000L;

	// 加解密错误
	public static final Long S_ENCRYPT_ERROR = 200100L;

	// 用户不存在
	public static final Long S_USER_DOESNOT_EXSIT = 201001L;
	// 密码错误
	public static final Long S_WRONG_PASSWORD = 201002L;
	// 数据库错误
	public static final Long S_DATABASE_ERROR = 200003L;
}
