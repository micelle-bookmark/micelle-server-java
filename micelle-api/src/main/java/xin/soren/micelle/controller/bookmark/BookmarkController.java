package xin.soren.micelle.controller.bookmark;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.api.Api;
import xin.soren.micelle.controller.AuthSubject;
import xin.soren.micelle.controller.AuthTokenHelper;

@RestController
@RequestMapping("/api/bk")
@Slf4j
public class BookmarkController {

	/**
	 * 
	 * @Description: 获取当前用户的所有书签
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:27:20
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Api
	public Object getUserBookmarkList() {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("获取当前用户[{}]书签列表", subject.userId);

		return null;
	}

	/**
	 * 
	 * @Description: 通过书签 ID 获取书签详细信息
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:27:33
	 */
	@RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
	@Api
	public Object getUserBookmarkById(@PathVariable("bookmarkId") Long bookmarkId) {
		return null;
	}

	/**
	 * 
	 * @Description: 通过书签 ID 获取子书签
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:30:32
	 */
	@RequestMapping(value = "/{bookmarkId}/children", method = RequestMethod.GET)
	@Api
	public Object getUserBookmarkByParentId(@PathVariable("bookmarkId") Long bookmarkId) {
		return null;
	}

	/**
	 * 
	 * @Description: 通过书签 ID 删除用户书签
	 * @param bookmarkId
	 * @return
	 * @Throws
	 * @date 2017年11月3日 下午9:28:18
	 */
	@RequestMapping(value = "/{bookmarkId}", method = RequestMethod.DELETE)
	@Api
	public Object deleteUserBookmark(@PathVariable("bookmarkId") Long bookmarkId) {
		return null;
	}

}
