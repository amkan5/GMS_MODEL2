package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command{
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().
				substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("my_page");
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER : 
			Map<String, Object> paramMap = new HashMap<>();
			MemberBean mem = (MemberBean) request.getSession().getAttribute("user");
			/*mem.setPassword(
					request.getParameter("oldPass")
					);
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("teamid"))*/;
			String[] arr1 = {"oldpassword","password","roll","teamId","memId"};
			String[] arr2 = {
					request.getParameter("oldPass").split("/")[0],
					request.getParameter("oldPass").split("/")[1],
					request.getParameter("roll"),
					request.getParameter("teamid"),
					mem.getMemId()
							};
			for(int i=0;i<arr1.length;i++){
				paramMap.put(arr1[i], arr2[i]);
				paramMap.put("column"+String.valueOf(i), arr1[i]);
			}
			System.out.println("새로운password : "+ request.getParameter("oldPass").split("/")[1]);
			MemberServiceImpl.getInstance().modify(paramMap);
			System.out.println("업데이트 진입완료");
				break;
		default:
			break;
		}
		
		super.execute();
	} 
}
