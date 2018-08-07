package service;
import domain.*;
import java.util.List;
import java.util.Map;

import com.sun.swing.internal.plaf.metal.resources.metal;

import domain.*;
public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> list();
	public List<MemberBean> selectSome(String word);
	public MemberBean selectOne(String word);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean loginB(MemberBean bean); 
	public MemberBean login(MemberBean bean);
	public List<MemberBean> getList(Map<?,?> param); //와일드카드,아스타 
}
