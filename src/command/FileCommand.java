package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class FileCommand extends Command{
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().
				substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
@Override
public void execute() {
	super.execute();
	System.out.println("파일커맨드까지 왔을까");
	request.setAttribute("pagename", 
			request.getParameter("pagename"));
	/*request.setAttribute("user", MemberServiceImpl
			.getInstance()
			.retrieve(request.getParameter("userid")));*/
	/*System.out.println("move command page이름 : "+request.getParameter("page"));
	request.setAttribute("pagename", 
			request.getParameter("page"));*/
	
}
}
