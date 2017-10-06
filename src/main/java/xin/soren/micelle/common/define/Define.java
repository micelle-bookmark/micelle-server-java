package xin.soren.micelle.common.define;

/**
 * 
 * @Description: 内部数据类型定义
 * @author soren
 * @date 2017年9月14日 下午6:03:32
 *
 */
public class Define {
	/**
	 * 错误信息中的分段字符
	 */
	static public final String VALIDATION_MESSAGE_SPLIT_STRING = "##";

	static public enum BookmarkOperateType {
		// 新增书签
		ADD(1),
		// 删除书签
		DELETE(2),
		// 修改书签
		MODIFY(3);

		private int value;

		private BookmarkOperateType(int index) {
			this.value = index;
		}

		public int getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return String.valueOf(this.value);
		}
	}

	static public enum DeleteStatus {
		// 未删除
		NOT_DELETED(0),
		// 已删除
		IS_DELETED(1);

		private int value;

		private DeleteStatus(int index) {
			this.value = index;
		}

		public int getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return String.valueOf(this.value);
		}
	}

	static public enum BookmarkCategory {
		// 书签目录
		DIR("dir"),
		// 书签项
		BOOKMAKR("bookmark");

		private String value;

		private BookmarkCategory(String v) {
			this.value = v;
		}

		public String getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}
}
