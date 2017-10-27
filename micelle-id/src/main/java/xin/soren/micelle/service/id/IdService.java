package xin.soren.micelle.service.id;

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
	 * @Description: 获取下一个可用的书签ID
	 * @return
	 * @Throws
	 * @Date 2017年9月24日 下午7:52:18
	 */
	public Long nextBookmarkId();

	/**
	 * 
	 * @Description: 获取下一个可用的 Record ID
	 * @return
	 * @Throws
	 * @Date 2017年10月9日 下午6:12:30
	 */
	public Long nextRecordId();
}
