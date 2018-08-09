package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		 setDomain(request.getServletPath().
					substring(1,request.getServletPath().indexOf(".")));
		 setAction(request.getParameter("action"));
		 setPage(request.getParameter("page"));
		 execute();
	}
	@Override
	public void execute() {
		 //이제부턴 search
		System.out.println("써치커맨드진입");
		Map<String, Object> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNum");
		PageProxy pxy = new PageProxy();
		pxy.carryout((pageNumber==null)
				? 1:
					Integer.parseInt(request.getParameter("pageNum")));
		//2번 syso 페이지넘버 확인 
		Pagination page=  pxy.getPagination();
		request.setAttribute("rowCount", //rowCount 
			page.getRowCount());		
		paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
		paramMap.put("endRow", String.valueOf(page.getEndRow())); 
		//3번 syso row들 잘들어갔는지 
		request.setAttribute("page", page);
		//4. paramMap잘들가는지 syso 
		System.out.println("4. beginRow :" + paramMap.get("beginRow"));
		request.setAttribute(
				"list",
				MemberServiceImpl.getInstance().search(paramMap));
		super.execute();
	}
	

}
