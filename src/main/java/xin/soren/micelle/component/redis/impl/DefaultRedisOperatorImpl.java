package xin.soren.micelle.component.redis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.component.redis.RedisOperator;

/**
 * 
 * @Description: Redis 操作封装实现类
 * @author soren
 * @date 2017年9月23日 上午9:59:30
 *
 */
@Component
@Slf4j
public class DefaultRedisOperatorImpl implements RedisOperator {
	@Autowired
	RedisTemplate redisTemplate;

	@Override
	public Long saveList(String key, List<Long> list) {
		// TODO Auto-generated method stub
		log.info("saveList, {}, {}", key, list);

		BoundListOperations<String, Long> boundListOperations = redisTemplate.boundListOps(key);
		// return boundListOperations.rightPushAll(list.toArray());
		Long[] arr = new Long[list.size()];
		list.toArray(arr);
		return boundListOperations.rightPushAll(arr);
	}
}
