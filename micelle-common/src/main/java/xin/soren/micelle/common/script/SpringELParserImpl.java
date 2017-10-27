package xin.soren.micelle.common.script;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: SpringEL 表达式解析器实现
 * @author soren
 * @date 2017年10月9日 下午5:19:04
 *
 */
@Component
@Slf4j
public class SpringELParserImpl extends IScriptParser {
	private static final String ARGS = "args";
	private static final String RET_VAL = "retVal";

	private final ConcurrentHashMap<String, Expression> expCache = new ConcurrentHashMap<String, Expression>();
	private final ConcurrentHashMap<String, Method> funcs = new ConcurrentHashMap<String, Method>(64);

	private final ExpressionParser parser = new SpelExpressionParser();

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(String exp, Object[] args, Object retVal, boolean hasRetVal, Class<T> valueType) {
		if (valueType.equals(String.class)) {
			if (exp.indexOf("#") == -1 && exp.indexOf("'") == -1) {
				return (T) exp;
			}
		}

		StandardEvaluationContext context = new StandardEvaluationContext();

		Iterator<Map.Entry<String, Method>> it = funcs.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Method> entry = it.next();
			context.registerFunction(entry.getKey(), entry.getValue());
		}

		context.setVariable(ARGS, args);
		if (hasRetVal) {
			context.setVariable(RET_VAL, retVal);
		}
		Expression expression = expCache.get(exp);
		if (null == expression) {
			expression = parser.parseExpression(exp);
			expCache.put(exp, expression);

			log.info("缓存 SpringEL 表达式: {}", exp);
		}
		return expression.getValue(context, valueType);
	}

	@Override
	public void addFunction(String name, Method method) {
		log.info("增加 SpringEL 函数: {}", name);
		funcs.put(name, method);
	}
}
