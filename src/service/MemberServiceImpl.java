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
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		System.out.println("5. serveice enter");
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
