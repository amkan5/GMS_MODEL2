package service;
import domain.*;
import java.util.List;
import java.util.Map;

import com.sun.swing.internal.plaf.metal.resources.metal;

import domain.*;
public interface MemberService {
	public void add(MemberBean member);
	//public List<MemberBean> selectSome(String word);
	public MemberBean retrieve(String id);
	public List<MemberBean> search(Map<?,?> param); 
	public int countMember(Map<?, ?> param);
	public void modify(Map<?,?> param);
	public void remove(MemberBean bean); //기본 6개 
	public boolean login(MemberBean bean);    
	
}
