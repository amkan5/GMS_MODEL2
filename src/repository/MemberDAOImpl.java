package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import domain.ExamBean;
import domain.MemberBean;
import domain.ProjectTeamBean;
import factory.*;
import pool.DBConstant;
import tamplate.PstmtQuery;
import tamplate.QueryTamplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}
	private Statement stmt;
	private MemberDAOImpl() {
		try {
			/*ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery("")
					;*/
			//이걸풀면 ResultSet rs= stmt.executeQuery(sql); 
			// stmt<에들어가야할게 conn.createStatement니까. 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertMember(MemberBean bean) {
		try {//void일때는 int로 받기. select나 이런건 
			 int rs = DatabaseFactory.createDatabase(Vendor.ORACLE, //애플.아이폰 이런느낌
						DBConstant.USERNAME, 
						DBConstant.PASSWORD)
						.getConnection()
						.createStatement()
						.executeUpdate(String.format(
								MemberQuery.INSERT_MEMBER.toString(),
								bean.getMemId(),bean.getPassword(),
								bean.getName(),bean.getSsn(),
								bean.getAge(), bean.getGender(),
								bean.getSubject(), bean.getRoll(),
								bean.getTeamId()
								));
			 System.out.println(bean.toString());
			 System.out.println("가입결과: "+ rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void updateMember(MemberBean bean) {
		try {
			System.out.println("updateD1 : " + bean.toString());
			System.out.println(MemberQuery.UPDATE_MEMBER.toString());
			System.out.println(bean.getPassword().split("/")[1]);
			 DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.UPDATE_MEMBER.toString(),
							bean.getPassword().split("/")[1],
							bean.getRoll(),
							bean.getTeamId(),
							bean.getMemId(),
							bean.getPassword().split("/")[0]));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropMember(MemberBean bean) {
		try {
			System.out.println("delteD1 : " + bean.toString());
			DatabaseFactory.createDatabase(Vendor.ORACLE, 
					DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.DELETE_MEMBER.toString(),
							bean.getMemId(),
							bean.getPassword()
							));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> lst = new ArrayList<>();
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, 
					DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							MemberQuery.SELECT_ALL_MEMBER.toString() 
							);
	
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
				lst.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(countMember()==lst.size()) {
			System.out.println("전체 리스트 인원 호출 성공");
		}
		for(int i=0;i<lst.size();i++) {
			System.out.println(lst.get(i).getName());
		}
		return lst;
	}

	@Override
	public MemberBean selectOne(String word) {
		MemberBean mem = new MemberBean();		
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, 
						DBConstant.USERNAME, DBConstant.PASSWORD)
						.getConnection()
						.createStatement()
						.executeQuery(
								String.format(
										MemberQuery.SELECT_ONE_MEMBER.toString()
										,word));
		while(rs.next()) {
			mem.setAge(rs.getString("AGE"));
			mem.setMemId(rs.getString("MEMID"));
			mem.setName(rs.getString("NAME"));
			mem.setPassword(rs.getString("PASSWORD"));
			mem.setRoll(rs.getString("ROLL"));
			mem.setSsn(rs.getString("SSN"));
			mem.setTeamId(rs.getString("TEAMID"));
			mem.setGender(rs.getString("GENDER"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}

	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(
							MemberQuery.COUNT_MEMBER.toString()
							));
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<MemberBean> selectSome(String word) {
		QueryTamplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String,Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value",word.split("/")[1]);
		map.put("table",Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
			}
		
		/* 옛날버전 List<MemberBean> lst = new ArrayList<>();
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, 
					DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.SELECT_SOME_MEMBER.toString(), 
									word.split("/")[0], '%'+word.split("/")[1]+'%')
							)
					;
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
				lst.add(mem);
			}
			for(int i=0;i<lst.size();i++) {
				System.out.println("써치 DAO 끝 " + lst.get(i).getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return list;
	}
	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean member = null;
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  try {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
				            ,"KAN","1253");
				Statement stmt = conn.createStatement();*/
		System.out.println("DAO1 " + bean.getMemId());
		try {	ResultSet rs = DatabaseFactory.createDatabase(
						Vendor.ORACLE, 
						DBConstant.USERNAME, 
						DBConstant.PASSWORD)
						.getConnection()
						.createStatement()
						.executeQuery(String.format(
								MemberQuery.LOGIN.toString(),
								bean.getMemId(),
								bean.getPassword()));
				if(rs.next()){
		                do{  member = new MemberBean();
		                	 member.setMemId(rs.getString("MEMID"));
		                	 member.setPassword(rs.getString("PASSWORD"));
		                	 member.setTeamId(rs.getString("TEAMID"));
		                	 member.setName(rs.getString("NAME"));
		                	 member.setAge(rs.getString("AGE"));
		                	 member.setRoll(rs.getString("ROLL"));
		                	 member.setRoll(rs.getString("GENDER"));
			                }while(rs.next());
		                }
				System.out.println("DAO2 " + member.getMemId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return member;
	}
}
