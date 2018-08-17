package tamplate;

import java.sql.SQLException;

import enums.ImageQuery;
import enums.MemberQuery;

public class AddQuery extends QueryTamplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "IMAGE" :
			System.out.println("템플릿 ADDQuery 이미지 진입: " + ImageQuery.INSERT.toString());
			map.put("sql", ImageQuery.INSERT.toString());
			break;
		default:
			break;
		}
	}

	@Override
	void startPlay() {
		try {
			System.out.println("템플릿 ADDQuery 파일이름 "+ map.get("value1").toString());
			System.out.println("템플릿 ADDQuery 확장자 "+ map.get("value2").toString());
			System.out.println("템플릿 ADDQuery 멤버이름 "+ map.get("value3").toString());
			j=0;
			j++;
			pstmt.setString(j, map.get("value1").toString());
			j++;
			pstmt.setString(j, map.get("value2").toString());
			j++;
			pstmt.setString(j, map.get("value3").toString());
			if(map.get("table").toString().equals("MEMBER")) {
				System.out.println("멤버일때만 들어오는곳");
				j++;
				pstmt.setString(j, map.get("value4").toString());
				j++;
				pstmt.setString(j, map.get("value5").toString());
				j++;
				pstmt.setString(j, map.get("value6").toString());
				j++;
				pstmt.setString(j, map.get("value7").toString());
				j++;
				pstmt.setString(j, map.get("value8").toString());
				j++;
				pstmt.setString(j, map.get("value9").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
