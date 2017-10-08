package xin.soren.micelle.common.script;

import java.lang.reflect.Method;

/**
 * 
 * @Description: 表达式解析器抽象类
 * @author soren
 * @date 2017年10月9日 下午5:17:39
 *
 */
public abstract class IScriptParser {
	/**
	 * 
	 * @Description: 解析表达式的值
	 * @param exp
	 * @param args
	 * @param retVal
	 * @param hasRetVal
	 * @param valueType
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:06:30
	 */
	public abstract <T> T getValue(String exp, Object[] args, Object retVal, boolean hasRetVal, Class<T> valueType);

	/**
	 * 
	 * @Description: 增加表达式函数
	 * @param name
	 * @param method
	 * @Throws
	 * @Date 2017年10月9日 下午6:06:43
	 */
	public abstract void addFunction(String name, Method method);

	/**
	 * 
	 * @Description: 根据参数获取表达式的值
	 * @param exp
	 * @param args
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:06:59
	 */
	public String getValue(String exp, Object[] args) {
		return getValue(exp, args, null, false, String.class);
	}

	/**
	 * 
	 * @Description: 根据参数和返回值获取表达式的值
	 * @param exp
	 * @param args
	 * @param retVal
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:07:18
	 */
	public String getValue(String exp, Object[] args, Object retVal) {
		return getValue(exp, args, retVal, true, String.class);
	}
}
