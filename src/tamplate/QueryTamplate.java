package tamplate;

import java.sql.PreparedStatement;
import java.util.*;
import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTamplate {
	//추상클래스이기 때문에 인터페이스하고 일반클래스의 가운곳에 있음. 두개의 습성둘다있음.
	HashMap<String,Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	public final void play(HashMap<String,Object>map){
		this.pstmt =null;
		this.list = new ArrayList<>();
		this.map = map;
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.USERNAME);
		this.map.put("password", DBConstant.PASSWORD);	
	      initialize();
	      startPlay();
	      endPlay();
	   }
	 abstract void initialize();
	   abstract void startPlay();
	   abstract void endPlay();
	   //template method
	 
}
