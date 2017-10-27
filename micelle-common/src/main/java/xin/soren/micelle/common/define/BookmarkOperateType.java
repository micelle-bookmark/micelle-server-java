package xin.soren.micelle.common.define;

public enum BookmarkOperateType {
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
