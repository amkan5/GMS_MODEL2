package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTamplate {

	@Override
	void initialize() {
		map.put("sql", MemberQuery.LOGIN.toString());	
		System.out.println("로그인 1 init : "+MemberQuery.LOGIN.toString());
	}

	@Override
	void startPlay() {
		j=0;
		try {
			j++;
			pstmt.setString(j, 
					map.get("memId").toString());
			j++;
			pstmt.setString(j, 
					map.get("password").toString());
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
			}
			o = mem;
			//System.out.println("login object : " + o.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
