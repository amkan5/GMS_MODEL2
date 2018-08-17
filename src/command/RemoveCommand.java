package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command{
public RemoveCommand(HttpServletRequest request) {
	setRequest(request);
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	setPage("userLoginForm");
	execute();
}
@Override
	public void execute() {
	 	switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())){
	 	case MEMBER : 
	 			System.out.println("삭제에 들어옴 끄읕");
	 			MemberServiceImpl.getInstance().remove(
	 					(MemberBean) request.getSession().getAttribute("user"));
	 			request.getSession().invalidate();
	 	default:
			break;
	 	}
		super.execute();
	}

}
