package tamplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTamplate {
	//추상클래스이기 때문에 인터페이스하고 일반클래스의 가운곳에 있음. 두개의 습성둘다있음.
	HashMap<String,Object>map;
	Object o;
	int number;
	List<Object> list;
	PreparedStatement pstmt;
	int j;
	public final void play(HashMap<String,Object> param){
		this.pstmt =null;		//
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.number =0;
		this.o = null;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);	
		Iterator<?> keys = param.keySet().iterator();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, param.get(key)); 
		}
	      initialize();
	      pStmtInit();
	      startPlay();
	      endPlay();
	   }
	 public final void play() {
			this.pstmt =null;		//
			this.list = new ArrayList<>();
			this.map = new HashMap<>();
			this.number =0;
			this.o = null;
			this.map.put("vendor", Vendor.ORACLE);
			this.map.put("username", DBConstant.USERNAME);
			this.map.put("password", DBConstant.PASSWORD);	
		      initialize();
		      pStmtInit();
		      startPlay();
		      endPlay();
		      System.out.println("지우기2 : " );
	 }
	 public void pStmtInit() {
		 System.out.println("템플릿 오라클 연동 진입 ");
		 try {
			pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement(
								(String)map.get("sql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 abstract void initialize();
	 abstract void startPlay();
	 abstract void endPlay();
	   //template method
	 
}
