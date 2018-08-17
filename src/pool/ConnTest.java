package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"KAN","1253");
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"INSERT INTO IMAGE(IMGSEQ,IMGNAME,EXT,MEMID) VALUES"
						+ "(IMGSEQ.NEXTVAL, 'Penguins', 'jpg', 'joon')"); 
			List<String> list = new ArrayList<>();
			int i= 0;
			while(rs.next()) { //회전수만큼 돌아라 
				System.out.println("RS내부 ::" + rs.getString("MEMID"));
				list.add(rs.getString("MEMID"));
			}
			System.out.println("테이블 :" + list);
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			System.out.println("에러 발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
