package xin.soren.micelle.component.redis;

import java.util.List;

/**
 * 
 * @Description: Redis 操作封装接口类
 * @author soren
 * @date 2017年9月23日 上午9:58:32
 *
 */
public interface RedisOperator {
	public Long saveList(String key, List<Long> list);
}
