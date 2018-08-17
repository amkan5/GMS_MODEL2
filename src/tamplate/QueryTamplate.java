package tamplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTamplate {
	HashMap<String,Object>map;
	Object o;
	int number;
	List<Object> list;
	PreparedStatement pstmt;
	int j;
	public final void play(HashMap<String,Object> param){
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.number =0;
		this.o = null;
		this.pstmt = null;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("dbpassword", DBConstant.PASSWORD);	
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
			this.list = new ArrayList<>();
			this.map = new HashMap<>();
			this.number =0;
			this.o = null;
			this.pstmt = null;
			this.map.put("vendor", Vendor.ORACLE);
			this.map.put("username", DBConstant.USERNAME);
			this.map.put("dbpassword", DBConstant.PASSWORD);	
		      initialize();
		      pStmtInit();
		      startPlay();
		      endPlay();
	 }
	 private void pStmtInit() {
		 System.out.println("템플릿 오라클 연동 진입 ");
		 try {
				 this.pstmt = 
						 DatabaseFactory
							.createDatabase2(map)
							.getConnection().prepareStatement(
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
