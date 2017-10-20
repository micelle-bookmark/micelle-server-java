package xin.soren.micelle.service.bookmark;

import java.util.List;

import xin.soren.micelle.domain.model.bookmark.BookmarkEntity;

/**
 * 
 * @Description: 书签服务接口类
 * @author soren
 * @date 2017年9月12日 上午11:37:19
 *
 */
public interface BookmarkService {
	/**
	 * 
	 * @Description: 获取用户书签列表
	 * @param userId
	 * @return
	 * @Throws
	 * @Date 2017年10月20日 下午9:44:07
	 */
	List<BookmarkEntity> listUserBookmarks(Long userId);
}
