package tamplate;

import java.sql.SQLException;

import enums.MemberQuery;

public class RemoveQuery extends QueryTamplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());	
	}

	@Override
	void startPlay() {
		j=0;
		try {
			System.out.println("query delete : " +map.get("memId").toString());
			System.out.println("query delete : " + map.get("password").toString());
			j++;
			pstmt.setString(j, map.get("memId").toString());
			j++;
			pstmt.setString(j, map.get("password").toString());
			j++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
