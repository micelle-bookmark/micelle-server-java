package xin.soren.micelle.common.define;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @Description: For mybatis typeHandler, with IEnumInt Impl
 * @author soren
 * @date 2017年10月6日 下午5:18:28
 *
 */
public class EnumIntHandler<E extends Enum<?> & IEnumInt> extends BaseTypeHandler<IEnumInt> {

	private Class<E> clazz;

	public EnumIntHandler(Class<E> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}

		this.clazz = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement paramPreparedStatement, int paramInt, IEnumInt paramT,
			JdbcType paramJdbcType) throws SQLException {
		paramPreparedStatement.setInt(paramInt, paramT.value());
	}

	@Override
	public E getNullableResult(ResultSet paramResultSet, String paramString) throws SQLException {
		int i = paramResultSet.getInt(paramString);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateEnum(i);
		}
	}

	@Override
	public E getNullableResult(ResultSet paramResultSet, int paramInt) throws SQLException {
		int i = paramResultSet.getInt(paramInt);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateEnum(i);
		}
	}

	@Override
	public E getNullableResult(CallableStatement paramCallableStatement, int paramInt) throws SQLException {
		int i = paramCallableStatement.getInt(paramInt);
		if (paramCallableStatement.wasNull()) {
			return null;
		} else {
			return locateEnum(i);
		}
	}

	private E locateEnum(int code) {
		E[] enums = clazz.getEnumConstants();
		for (E e : enums) {
			if (e.value() == code) {
				return e;
			}
		}

		throw new IllegalArgumentException("未知的枚举值: " + code + "   枚举类型: " + clazz.getSimpleName());
	}

}
