package service;
import domain.*;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import repository.MemberDAOImpl;
public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);
		System.out.println("updateS : " + member.toString());
	}

	@Override
	public void deleteMember(MemberBean member) {	
		MemberDAOImpl.getInstance().dropMember(member);	
		System.out.println("deleteS : " + member.toString());
		
	}


	@Override
	public List<MemberBean> list() {
		return MemberDAOImpl.getInstance().selectAll();
	}
	@Override
	public List<MemberBean> selectSome(String word) {
		System.out.println("service word : " + word);
		return MemberDAOImpl.getInstance().selectSome(word);
	}
	@Override
	public MemberBean selectOne(String word) {
		return MemberDAOImpl.getInstance().selectOne(word);
	}
	@Override
	public int countMember() {
		return MemberDAOImpl.getInstance().countMember();
	}
	@Override
	public boolean loginB(MemberBean bean) {
		System.out.println("service : " + bean.getMemId());
		return (MemberDAOImpl.getInstance().login(bean)!=null);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		return MemberDAOImpl.getInstance().login(bean);
	}
	@Override
	public List<MemberBean> getList(Map<?, ?> param) {
		String beginRow = (String) param.get("beginRow");
		String endRow = (String) param.get("endRow");
		System.out.println("memberservice 시작행: "+ beginRow );
		System.out.println("memberservice 끝행: "+ endRow );
		return MemberDAOImpl.getInstance().selectList(param); 
	}

}
