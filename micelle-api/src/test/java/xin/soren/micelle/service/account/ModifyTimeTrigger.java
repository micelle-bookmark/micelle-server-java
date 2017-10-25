package xin.soren.micelle.service.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.h2.tools.TriggerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModifyTimeTrigger extends TriggerAdapter {

	private final String ColumnName = "modify_time";

	@Override
	public void fire(Connection arg0, ResultSet arg1, ResultSet arg2) throws SQLException {
		// TODO Auto-generated method stub

		log.info("fire");

		ResultSetMetaData metaData = arg2.getMetaData();
		if (metaData == null) {
			log.info("metaData is null");
			return;
		}

		int columnCount = metaData.getColumnCount();
		for (int index = 1; index <= columnCount; ++index) {
			log.info("column index={}, name={}", index, metaData.getColumnName(index));
		}

		// arg2.isFirst();
		// arg2.first();

		log.info("row count {}", arg2.getRow());

		int count = 0;
		// while (arg1.next()) {
		// // for (int index = 1; index <= columnCount; ++index) {
		// // log.info("column name={}, value={}",
		// // metaData.getColumnName(index), arg2.getString(index));
		// // }
		// ++count;
		//
		// if ((count % 100) == 0) {
		// log.info("count {}", count);
		// }
		// }

		log.info("count {}", count);
	}

}
