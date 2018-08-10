package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery extends QueryTamplate{
	@Override
	void initialize() {
		System.out.println("8. searchQuery에서 column: " + map.get("column"));
		System.out.println("8.5 searchQuery에서 column?? " + map.containsKey("column")); //널값 널값이면?
		map.put("sql",
				(map.containsKey("column"))? 
				  //값이 있으면
					String.format(
							MemberQuery.SEARCH.toString(),
							map.get("column")
							)
				: 
					//값이 없으면
					MemberQuery.LIST.toString()
					
				);
		System.out.println("9. sql은 뭘까? " + map.get("sql"));	
	}

	@Override
	void startPlay() {
		j=0;
			try {
				if(map.containsKey("column")){
					j++;
					pstmt.setString(j, 
						"%"+map.get("value").toString()+"%");
					System.out.println("%"+map.get("value").toString()+"%");
					}
				j++;
				pstmt.setString(j, 
						map.get("beginRow").toString());
				System.out.println("10. 비긴로우는 잘갔을까?"+map.get("beginRow").toString());
				j++;
				pstmt.setString(j, 
						map.get("endRow").toString()
						);
				System.out.println("9.5 pstmt : " );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
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
