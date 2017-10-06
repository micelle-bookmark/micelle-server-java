package xin.soren.micelle.common.define;

public enum DeleteStatus implements IEnumInt {
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

	@Override
	public int value() {
		return this.value;
	}
}
