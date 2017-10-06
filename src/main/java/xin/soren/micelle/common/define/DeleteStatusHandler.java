package xin.soren.micelle.common.define;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @Description: For mybatis typeHandler
 * @author soren
 * @date 2017年10月6日 下午3:46:13
 *
 */
public class DeleteStatusHandler extends BaseTypeHandler<DeleteStatus> {

	private Class<DeleteStatus> type;
	private final DeleteStatus[] enums;

	public DeleteStatusHandler(Class<DeleteStatus> type) {
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
	public DeleteStatus getNullableResult(ResultSet paramResultSet, String paramString) throws SQLException {
		int i = paramResultSet.getInt(paramString);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateDeleteStatus(i);
		}
	}

	@Override
	public DeleteStatus getNullableResult(ResultSet paramResultSet, int paramInt) throws SQLException {
		int i = paramResultSet.getInt(paramInt);
		if (paramResultSet.wasNull()) {
			return null;
		} else {
			return locateDeleteStatus(i);
		}
	}

	@Override
	public DeleteStatus getNullableResult(CallableStatement paramCallableStatement, int paramInt) throws SQLException {
		int i = paramCallableStatement.getInt(paramInt);
		if (paramCallableStatement.wasNull()) {
			return null;
		} else {
			return locateDeleteStatus(i);
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement paramPreparedStatement, int paramInt, DeleteStatus paramT,
			JdbcType paramJdbcType) throws SQLException {
		paramPreparedStatement.setInt(paramInt, paramT.getValue());
	}

	private DeleteStatus locateDeleteStatus(int code) {
		for (DeleteStatus status : enums) {
			if (status.getValue() == code) {
				return status;
			}
		}

		throw new IllegalArgumentException("未知的枚举值: " + code + "   枚举类型: " + type.getSimpleName());
	}
}
