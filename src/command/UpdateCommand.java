package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().
				substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("my_page");
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER : 
			MemberBean mem = new MemberBean();
			mem.setMemId(
					request.getParameter("memId")
					);
			mem.setPassword(
					request.getParameter("oldPass")
					+'/'
					+request.getParameter("newPass")
					);
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("teamid"));
			//MemberServiceImpl.getInstance().updateMember(mem);
			System.out.println(mem.toString());
				break;
		default:
			break;
		}
		
		super.execute();
	} 
}
