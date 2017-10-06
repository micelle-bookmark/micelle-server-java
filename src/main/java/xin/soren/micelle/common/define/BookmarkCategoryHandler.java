package xin.soren.micelle.common.define;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @Description: For mybatis typeHandler, 经测试不需使用
 * @author soren
 * @date 2017年10月6日 下午4:55:17
 *
 */
public class BookmarkCategoryHandler extends BaseTypeHandler<BookmarkCategory> {

	private Class<BookmarkCategory> type;
	private final BookmarkCategory[] enums;

	public BookmarkCategoryHandler(Class<BookmarkCategory> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}

		this.type = type;
		this.enums = type.getEnumConstants();

		if (this.enums == null) {
			throw new IllegalArgumentException(type.getSimpleName() + "does not represent an enum type.");
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement paramPreparedStatement, int paramInt, BookmarkCategory paramT,
			JdbcType paramJdbcType) throws SQLException {

		paramPreparedStatement.setString(paramInt, paramT.getValue());
	}

	@Override
	public BookmarkCategory getNullableResult(ResultSet paramResultSet, String paramString) throws SQLException {
		String i = paramResultSet.getString(paramString);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateEnums(i);
		}
	}

	@Override
	public BookmarkCategory getNullableResult(ResultSet paramResultSet, int paramInt) throws SQLException {
		String i = paramResultSet.getString(paramInt);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateEnums(i);
		}
	}

	@Override
	public BookmarkCategory getNullableResult(CallableStatement paramCallableStatement, int paramInt)
			throws SQLException {
		String i = paramCallableStatement.getString(paramInt);
		if (paramCallableStatement.wasNull()) {
			return null;
		} else {
			return locateEnums(i);
		}
	}

	private BookmarkCategory locateEnums(String code) {
		for (BookmarkCategory status : enums) {
			if (status.getValue().equals(code)) {
				return status;
			}
		}

		throw new IllegalArgumentException("未知的枚举值: " + code + "   枚举类型: " + type.getSimpleName());
	}

}
