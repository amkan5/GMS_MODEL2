package tamplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTamplate{
	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			map.put("sql", String.format(MemberQuery.RETRIEVE.toString(), 
					map.get("table")));	
			break;
		case "IMAGE":
			map.put("sql",ImageQuery.RETRIEVE.toString());
			break;
		default:
			break;
		}
	}

	@Override
	void startPlay() {
		try {
			System.out.println("startpaly진입 id : "+map.get("memId").toString());
			pstmt.setString(1, 
					map.get("memId").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	void endPlay() {
			switch (map.get("table").toString()) {
			case "MEMBER":
				MemberBean mem = null;
				try {
				ResultSet rs = pstmt.executeQuery();
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
				//System.out.println("retrieve object : " + o.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "IMAGE":
				System.out.println("image 템플릿 end부분 들어옴");
				ImageBean img = null;
				try {
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						img = new ImageBean();
						img.setImgseq(rs.getString("IMGSEQ"));
						img.setMemId(rs.getString("MEMID"));
						img.setImgname(rs.getString("IMGNAME"));
						img.setExtension(rs.getString("EXT"));
					}
					o = img;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			
	
		}

}
