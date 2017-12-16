package xin.soren.micelle.service.id;

import java.util.List;

/**
 * 
 * @Description: ID 生成服务接口类
 * @author soren
 * @date 2017年9月24日 下午7:50:34
 *
 */
public interface IdService {
	/**
	 * 
	 * @Description: 获取下一个可用的用户ID
	 * @return
	 * @Throws
	 * @Date 2017年9月24日 下午7:51:56
	 */
	public Long nextUserId();

	/**
	 * 
	 * @Description: 获取下一个可用的 Logs ID
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:12:30
	 */
	public Long nextLogsId();

	/**
	 * 
	 * @Description: 获取 n 个可用的 Logs ID
	 * @param count:
	 *            数量
	 * @return
	 * @Throws
	 * @date 2017年12月16日 下午8:39:05
	 */
	public List<Long> nextLogsId(int count);
}
