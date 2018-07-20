package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	 public RetrieveCommand(HttpServletRequest request) {
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
			 request.setAttribute("member",
					 MemberServiceImpl.getInstance().selectOne(
								request.getParameter("userid")		
					 ));
			 /*System.out.println(
						MemberServiceImpl.getInstance().selectOne(
						request.getParameter("userid")
						).toString()
						);*/
			 System.out.println("아이디검색");
						break;
		default:
			return;
		 }
		 super.execute();
	}
}
