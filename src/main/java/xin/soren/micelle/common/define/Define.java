package xin.soren.micelle.common.define;

/**
 * 
 * @Description: 内部数据类型定义
 * @author soren
 * @date 2017年9月14日 下午6:03:32
 *
 */
public class Define {
	/**
	 * 错误信息中的分段字符
	 */
	static public final String VALIDATION_MESSAGE_SPLIT_STRING = "##";

	/**
	 * HTTP HEADER 中存储 token 字段的名称
	 */
	static public final String TOKEN_HEADER_NAME = "Authorization";
	/**
	 * token 字段的前缀
	 */
	static public final String TOKEN_HEADER_VALUE_PREFIX = "Bearer ";

	/**
	 * ID的业务名称
	 */
	static public final String BIZ_TAG_USER_ID = "user.id";
	static public final String BIZ_TAG_ACCOUND_ID = "account.id";
	static public final String BIZ_TAG_LOG_ID = "log.id";
}
