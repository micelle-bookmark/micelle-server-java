package xin.soren.micelle.common.script;

/**
 * 
 * @Description: 表达式解析器抽象类
 * @author soren
 * @date 2017年10月9日 下午5:17:39
 *
 */
public abstract class IScriptParser {
	public abstract <T> T getValue(String exp, Object[] args, Object retVal, boolean hasRetVal, Class<T> valueType);

	public String getValue(String exp, Object[] args) {
		return getValue(exp, args, null, false, String.class);
	}

	public String getValue(String exp, Object[] args, Object retVal) {
		return getValue(exp, args, retVal, true, String.class);
	}
}
