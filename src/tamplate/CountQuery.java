package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTamplate {
	@Override
	void initialize() {
		System.out.println("e. 카운트쿼리 column"+map.get("column").toString());
		/*map.put("sql", MemberQuery.COUNT.toString());	*/
		map.put("sql", String.format(MemberQuery.COUNT.toString(), 
				map.get("column").toString()));	
	}
	
	@Override
	void startPlay() {
		try {
			System.out.println("e2. 스타트플레이 값 "+map.get("value").toString());
			pstmt.setString(1, map.get("value").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
