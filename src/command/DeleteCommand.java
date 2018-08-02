package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command{
public DeleteCommand(HttpServletRequest request) {
	setRequest(request);
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	setPage("userLoginForm");
	execute();
}
@Override
	public void execute() {
	 	switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())){
	 	case MEMBER : 
	 			System.out.println("삭제에 들어옴 끄읕");
	 			MemberServiceImpl.getInstance().deleteMember(
	 					(MemberBean) request.getSession().getAttribute("user"));
	 			//비밀번호 재확인한거 split해줘야ㅐㅎ 
	 			request.getSession().invalidate();
	 	default:
			break;
	 	}
		super.execute();
	}

}
