package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;

public class DeleteCommand extends Command{
public DeleteCommand(HttpServletRequest request) {
	setRequest(request);
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	setPage(request.getParameter("page"));
	execute();
}
@Override
	public void execute() {
	 	switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())){
	 	case MEMBER : 
	 			System.out.println("삭제에 들어옴 끄읕");
	 			//MemberServiceImpl.getInstance().deleteMember(mem);
		default:
			break;
	 	}
		super.execute();
	}

}
