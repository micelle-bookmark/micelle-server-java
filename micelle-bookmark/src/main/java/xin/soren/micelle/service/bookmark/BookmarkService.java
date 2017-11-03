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

	/**
	 * 
	 * @Description: 获取书签目录下的子书签
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @Date 2017年10月20日 下午9:54:13
	 */
	List<BookmarkEntity> listChildren(Long userId, Long bookmarkId);

	/**
	 * 
	 * @Description: 获取用户顶层的书签列表
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:12:06
	 */
	List<BookmarkEntity> listChildren(Long userId);

	/**
	 * 
	 * @Description: 删除书签
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:20:39
	 */
	Long deleteById(Long bookmarkId);

	/**
	 * 
	 * @Description: 通过 ID 获取书签信息
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:20:51
	 */
	BookmarkEntity getById(Long bookmarkId);
}
