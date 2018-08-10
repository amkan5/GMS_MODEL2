package tamplate;

import java.sql.SQLException;

import enums.MemberQuery;

public class UpdateQuery extends QueryTamplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.UPDATE.toString(), 
				map.get("column1").toString().toUpperCase(),
				map.get("column2").toString().toUpperCase(),
				map.get("column3").toString().toUpperCase()
				));
	}

	@Override
	void startPlay() {
		j=0;
		try {
				j++;
				pstmt.setString(j, 
					"%"+map.get("password").toString()+"%");
				System.out.println("%"+map.get("password").toString()+"%");
			j++;
			pstmt.setString(j, 
					map.get("roll").toString());
			j++;
			pstmt.setString(j, 
					map.get("teamId").toString()
					);
			j++;
			pstmt.setString(j, 
					map.get("memId").toString()
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		
		
	}

}
