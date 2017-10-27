package xin.soren.micelle.common.define;

public enum BookmarkCategory {
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
