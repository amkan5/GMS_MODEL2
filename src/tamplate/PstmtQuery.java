package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTamplate{
	@Override
	void initialize() {
		map.put("sql", String.format(
				"SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+" FROM %s "
				+" WHERE %s "
				+" LIKE ? ",
				map.get("table"),
				map.get("column")));
	}

	@Override
	void startPlay() {
		System.out.println();
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement(
							(String)map.get("sql"));
			System.out.println("sql이 잘먹혔을까? " + (String)map.get("sql"));
			pstmt.setString(1, //0부터안감. 1부터 가는 애임. 
					"%"+map.get("value").toString()+"%s");
			System.out.println("sql이 잘먹혔을까? " + (String)map.get("sql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setAge(rs.getString("AGE"));
				mem.setMemId(rs.getString("MEMID"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
				list.add(mem); //앞에 super생략됨 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
