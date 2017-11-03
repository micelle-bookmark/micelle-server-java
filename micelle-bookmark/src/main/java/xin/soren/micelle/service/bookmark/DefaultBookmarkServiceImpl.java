package xin.soren.micelle.service.bookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.log.WriteLog;
import xin.soren.micelle.domain.mapper.bookmark.BookmarkMapper;
import xin.soren.micelle.domain.model.bookmark.BookmarkEntity;

/**
 * 
 * @Description: 书签服务实现类
 * @author soren
 * @date 2017年9月12日 上午11:37:35
 *
 */
@Service
@Slf4j
public class DefaultBookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkMapper mapper;

	@WriteLog(value = "'获取用户['+#args[0]+']书签列表'")
	@Override
	public List<BookmarkEntity> listUserBookmarks(Long userId) {
		List<BookmarkEntity> bookmarkEntities = mapper.listAllByUser(userId);

		log.info("获取用户[{}]书签列表, size={}", userId, bookmarkEntities.size());
		return bookmarkEntities;
	}

	@WriteLog(value = "'获取用户['+#args[0]+']书签目录['+#args[1]+']的子书签列表, size='+#retVal.size()")
	@Override
	public List<BookmarkEntity> listChildren(Long userId, Long bookmarkId) {
		return mapper.listChildren(userId, bookmarkId);
	}

	@WriteLog(value = "'获取用户['+#args[0]+']顶层书签列表'")
	@Override
	public List<BookmarkEntity> listChildren(Long userId) {
		return listChildren(userId, 0L);
	}

	@WriteLog(value = "'删除书签['+#args[0]+']'")
	@Override
	public Long deleteById(Long bookmarkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookmarkEntity getById(Long bookmarkId) {
		return mapper.getById(bookmarkId);
	}

}
