package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	List<MemberBean> mem;
public SearchCommand(HttpServletRequest request) {
	setRequest(request);
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().
					indexOf(".")));
	setAction(request.getParameter("action"));
	setPage(request.getParameter("page"));
	execute();
}
@Override
	public void execute() {
		//System.out.println("searchOp: " + request.getParameter("searchOption"));
		//System.out.println("searchWr: " + request.getParameter("searchWord"));		
	/*강사님버전
	 select *
	 from admin 
	 where searchOption like 'SearchWord'
	 * */

	//내버전
	request.setAttribute("list",
				 MemberServiceImpl.getInstance().selectSome(
						 	request.getParameter("searchOption")
							+'/'+request.getParameter("searchWord")	
				 ));
	/*초기버전	List lst = new ArrayList<>();
		 lst = MemberServiceImpl.getInstance().selectSome(
				request.getParameter("searchWord")
				);*/
		System.out.println("써치성공인가");

		super.execute();
	}

public List<MemberBean> getMem() {
	return mem;
}
}
