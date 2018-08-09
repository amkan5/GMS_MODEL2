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
			 System.out.println("리트리버도 와따아?");
			 request.setAttribute("member",
					 MemberServiceImpl.getInstance().retrieve(
								request.getParameter("userid")		
					 ));
			 /*System.out.println(
						MemberServiceImpl.getInstance().selectOne(
						request.getParameter("userid")
						).toString()
						);*/
					
		 super.execute();
	}
}
