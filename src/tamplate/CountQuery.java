package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTamplate {
	@Override
	void initialize() {
		map.put("sql", MemberQuery.COUNT.toString());	
	}
	
	@Override
	void startPlay() {
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			super.number = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
