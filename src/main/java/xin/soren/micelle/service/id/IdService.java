package xin.soren.micelle.service.id;

import java.util.List;
import java.util.Optional;

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
	public Optional<Long> nextUserId();

	/**
	 * 
	 * @Description: 获取下一个可用的账户ID
	 * @return
	 * @Throws
	 * @date 2018年1月2日 上午10:33:46
	 */
	public Optional<Long> nextAccountId();

	/**
	 * 
	 * @Description: 获取下一个可用的 Logs ID
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:12:30
	 */
	public Optional<Long> nextLogsId();

	/**
	 * 
	 * @Description: 获取 count 个可用的 Logs ID
	 * @param count:
	 *            数量
	 * @return
	 * @Throws
	 * @date 2017年12月16日 下午8:39:05
	 */
	public Optional<List<Long>> nextLogsId(int count);

	/**
	 * 
	 * @Description: 获取下一个可用的书签 ID
	 * @return
	 * @Throws
	 * @date 2018年1月8日 下午4:15:17
	 */
	public Optional<Long> nextBookmarkId();
}
