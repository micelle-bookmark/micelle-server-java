package xin.soren.micelle.service.bookmark;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.common.define.DeleteStatus;
import xin.soren.micelle.domain.mapper.bookmark.BookmarkMapper;
import xin.soren.micelle.domain.model.bookmark.BookmarkEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class BookmarkServiceTest {
	@Autowired
	BookmarkMapper mapper;

	@Test
	public void testInsertBookmark() {
		@SuppressWarnings("rawtypes")
		List<BookmarkEntity> bookmarkEntities = new ArrayList<BookmarkEntity>() {
			{
				for (long i = 0; i < 3; i++) {
					BookmarkEntity entity = new BookmarkEntity();
					entity.category = "bookmark";
					entity.isDelete = DeleteStatus.NOT_DELETED;
					entity.name = "name";
					entity.parentId = 1L;
					entity.url = "url";
					entity.userId = 1L;

					add(entity);
				}
			}
		};

		// try {
		Long count = mapper.insert(bookmarkEntities);
		Assert.assertEquals(count, (Long) 3L);
		// } catch (Exception e) {
		// System.out.println(ExceptionUtils.getStackTrace(e));
		// }

		// bookmarkEntities = mapper.listAll();
		// Assert.assertNotNull(bookmarkEntities);
		// System.out.println(bookmarkEntities);

		// BookmarkEntity entity = mapper.getById(1L);
		// Assert.assertNotNull(entity);
		// System.out.println(entity);
	}
}
