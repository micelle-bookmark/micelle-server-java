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

	// 数据库错误
	public static final Long S_DATABASE_ERROR = 200000L;
}
