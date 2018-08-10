package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
 //기본 ㅋㅋ_ㅋ 
public class PstmtQuery extends QueryTamplate{
	@Override
	void initialize() {
		System.out.println("8. pstmquery에서 table: " + map.get("domain"));
		//스위치문 들가야함 ㅎ
		map.put("sql",
				(map.get("column")==null)? 
				String.format(
						MemberQuery.LIST.toString(),
						map.get("beginRow"),
						map.get("endRow"))
				: 
				String.format(
						MemberQuery.SEARCH.toString(),
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
			pstmt.setString(1, 
					(map.get("column")==null)?
					(String) map.get("beginRow")
					:
					"%"+map.get("value").toString()+"%");
			pstmt.setString(2, 
					(map.get("column")==null)?
					(String) map.get("endRow")
					:
					(String) map.get("beginRow"));
			pstmt.setString(3, 
					(map.get("column")==null)?
					""
					:
					(String) map.get("endRow")
					);
			System.out.println("9.starPlay까지 끝남: ");
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
