package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
import proxy.Proxy;
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
		System.out.println("1.써치커맨드진입");
		Map<String, Object> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNum");
		Proxy pxy = new Proxy();
		pxy.carryout((pageNumber==null)
				? 1:
					Integer.parseInt(request.getParameter("pageNum")));
		Pagination page=  pxy.getPagination();
		String[] arr1 = {"domain","beginRow","endRow","value"};
		String[] arr2 = {
				request.getServletPath()
				.split(".do")[0].split("/")[1],
				String.valueOf(page.getBeginRow()), 
				String.valueOf(page.getEndRow()),
				request.getParameter("searchWord")
			};
		for(int i=0;i<arr1.length;i++){
				paramMap.put(arr1[i], arr2[i]);
			}
		//이걸 어찌 바꿔야할까?
		if(request.getParameter("searchOption")!=null) {
			paramMap.put("column", request.getParameter("searchOption").toUpperCase());
		}
	System.out.println("2. column " + paramMap.get("column"));
	System.out.println("3.search word : " + request.getParameter("searchWord"));			
	System.out.println("4. beginRow :" + paramMap.get("beginRow"));
		request.setAttribute(
				"list",
				MemberServiceImpl.getInstance().search(paramMap));
		request.setAttribute("rowCount", page.getRowCount());
		request.setAttribute("page", page);
		super.execute();
	}
	

}
