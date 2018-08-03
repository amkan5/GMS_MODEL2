package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		 setDomain(request.getServletPath().
					substring(1,request.getServletPath().indexOf(".")));
		 setAction(request.getParameter("action"));
		 setPage(request.getParameter("page"));
		 execute();
	}
	@Override
	public void execute() {
		System.out.println("리스트진입한다아");
		request.setAttribute(
				"list",MemberServiceImpl.getInstance().list());
		request.setAttribute("count", 
				MemberServiceImpl.getInstance().countMember());
		/*request.setAttribute("count", 
				MemberServiceImpl.getInstance().list().size());*/
		//또는 sTRING처리를 안해도 되는듯? MemberServiceImpl.getInstance().list().size 변수처리해서 넣음되긴하는데 귀찮
		super.execute();
	}

}
