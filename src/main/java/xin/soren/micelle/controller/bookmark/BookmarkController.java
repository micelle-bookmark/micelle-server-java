package xin.soren.micelle.controller.bookmark;

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

	@RequestMapping(method = RequestMethod.GET)
	@Api
	public Object getUserBookmarkList() {
		AuthSubject subject = AuthTokenHelper.getAuthSubject();
		log.info("修改当前用户[{}]书签列表", subject.userId);

		return null;
	}

}
