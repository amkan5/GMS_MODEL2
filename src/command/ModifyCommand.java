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
			mem.setPassword(
					request.getParameter("oldPass")
					);
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("teamid"));
			MemberServiceImpl.getInstance().modify(paramMap);
			System.out.println("업데이트 진입완료");
				break;
		default:
			break;
		}
		
		super.execute();
	} 
}
