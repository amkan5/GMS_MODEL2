package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import domain.ExamBean;
import domain.MemberBean;
import domain.ProjectTeamBean;
import factory.*;
import pool.DBConstant;
import tamplate.*;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}
	private Statement stmt;
	QueryTamplate q;
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
	public void insert(MemberBean bean) {
		MemberBean mem = new MemberBean();	
		q = new AddQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("memId", bean.getMemId());
		param.put("name", bean.getName());
		param.put("age", bean.getAge());
		param.put("subject", bean.getSubject());
		param.put("teamId", bean.getTeamId());
		param.put("password", bean.getPassword());
		param.put("ssn", bean.getSsn());
		param.put("gender", bean.getGender());
		param.put("roll", bean.getRoll());
		q.play((HashMap<String, Object>)param);
		/*try {//void일때는 int로 받기. select나 이런건 
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
	*/
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Map<?, ?> param) {
		q = new UpdateQuery();
		q.play((HashMap<String, Object>)param);
	}

	@Override
	public void delete(MemberBean bean) {
		q = new RemoveQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("memId", bean.getMemId());
		param.put("password", bean.getPassword());
		q.play((HashMap<String, Object>)param);
	}
	
	@Override
	public MemberBean selectOne(String word) {
		q = new RetrieveQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("memId", word);
		q.play((HashMap<String, Object>)param);
		return (MemberBean) q.getO();
	}

	@Override
	public int count() {
		int count = 0;
		q = new CountQuery();
		q.play();
		count = q.getNumber();
		return count;
	}

	@SuppressWarnings("unchecked") //해쉬맵도 결국 object라 가능함 
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		q = new SearchQuery();
		List<MemberBean> list = new ArrayList<>();
		//6번 syso
		System.out.println("6.멤버 dao beginRow : " + param.get("beginRow"));
		System.out.println("7.멤버 dao column : " + param.get("column"));
		q.play((HashMap<String, Object>) param);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
			}
		System.out.println("10. dao 끝 : " + list.toString());
		return list;
	}
	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean member = null;
		q = new LoginQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("memId", bean.getMemId());
		param.put("password", bean.getPassword());
		q.play((HashMap<String, Object>) param);
		member = (MemberBean) q.getO();
		System.out.println("로그인 member : " + member.toString());
		return member;
	}

}
