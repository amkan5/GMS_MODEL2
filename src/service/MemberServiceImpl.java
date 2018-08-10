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
	public void add(MemberBean member) {
		 MemberDAOImpl.getInstance().insert(member);
		
	}
	@Override
	public MemberBean retrieve(String id) {
		return  MemberDAOImpl.getInstance().selectOne(id);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		System.out.println("5. serveice enter");
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public int countMember() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDAOImpl.getInstance().update(param);
		
	}
	@Override
	public void remove(MemberBean bean) {
		MemberDAOImpl.getInstance().delete(bean);
		
	}
	@Override
	public boolean login(MemberBean bean) {
		return (MemberDAOImpl.getInstance().login(bean)!=null);
	}
	
}
