package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;
public class CountCommand extends Command {
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		 setDomain(request.getServletPath().
					substring(1,request.getServletPath().indexOf(".")));
		 setAction(request.getParameter("action"));
		 setPage(request.getParameter("page"));
		 execute();
	}
	@Override
	public void execute() {
		System.out.println("카운트커맨드까지 데이터가 왔을까? "+request.getParameter("pagenumber"));
		
		/*request.setAttribute("count", 
				String.valueOf(MemberServiceImpl.getInstance().countMember()));*/
		
		super.execute();
	}
}
