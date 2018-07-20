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
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER : 
			MemberBean mem = new MemberBean();
			mem.setMemId(
					request.getParameter("userId")
					);
			mem.setPassword(
					request.getParameter("oldPass")
					+"/"
					+request.getParameter("newPass")
					);
			System.out.println("업데이트성공");
			//MemberServiceImpl.getInstance().updateMember(mem);
				break;
		default:
			break;
		}
		
		super.execute();
	} 
}