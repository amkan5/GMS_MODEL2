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
		Map<String, Object> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNum");
		PageProxy pxy = new PageProxy();
		pxy.carryout((pageNumber==null)
				? 1:
					Integer.parseInt(request.getParameter("pageNum")));
		Pagination page=  pxy.getPagination();
		request.setAttribute("rowCount", //rowCount 
			page.getRowCount());		
		paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
		paramMap.put("endRow", String.valueOf(page.getEndRow())); //담아서 던짐. 
		request.setAttribute("page", page);
	/*	request.setAttribute("existPrev", page.get);
		request.setAttribute("existNext", page.getexistNext);
		Map<String,Object> param = new HashMap<>();
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage); */
		request.setAttribute(
				"list",MemberServiceImpl.getInstance().getList(paramMap));
		
		
		//페이지네이션
		
	/*	int rowCount = MemberServiceImpl.getInstance().countMember();
		int pageSize = 5;
		int blockSize = 5;	
		int beginPage = 0;
		int endPage = 0; 
		int pageNum = (request.getParameter("pageNum")==null)? 
				1 : Integer.parseInt(request.getParameter("pageNum")); 
		int beginRow = 0; //String.valueOf(4*(pageNum-1)+pageNum);
		int endRow= 0; //String.valueOf(pageNum*5);
		int pageCount =  (int) Math.ceil(rowCount/(double)pageSize);
		int blockCount = (int) Math.ceil(pageCount/(double)blockSize);
		beginPage = pageNum - ((pageNum-1)%blockSize);
		endPage = ((beginPage + pageSize -1) < pageCount)?
				beginPage+blockSize-1:pageCount;
		beginRow = pageNum*pageSize - (pageSize-1);
		endRow = pageNum*pageSize;
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
	boolean existPrev = false;
	if(prevBlock >=0) {
		existPrev = true;
	}
	boolean existNext = false;
	if(nextBlock <= pageCount) {
		existNext = true;
	}*/
		
		
		
		/*if(pageNum!=endPage) {
			endRow = String.valueOf(pageNum*pageSize);
			beginRow =  String.valueOf(0);
		}else {
			if() {
				endRow = rowCount;
				beginRow = endRow - (page)
			}
		}*/
		
		//★ endPage 정하기 
		//request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		 //가 만약 6이면? 
		//beginPage는 PageNum이 1~5사ㅋ이면 0. .. pageNum이 6~10이면 6 임 1. .... 
		// pageNum/5+ 
		//endPage는 beginPage+4야 (25보다 크면)
		/*String endPage = ((Integer)request.getAttribute("count")%5==0)?  
				String.valueOf(((Integer)request.getAttribute("count"))/5)
				: String.valueOf(round((Integer)request.getAttribute("count")/5+1));*/ //조건문 하나더  count/5<6else endPage = 5 
	
		
		//★ pageNumber row 값 만들기
		//int pageNum = 1;
		//row들어가면 페이지의 사작과 끝. 글목록이야 그니까. 밑에 1,2,3,4,5 아님
		
		//List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		/*옛날꺼
		 * request.setAttribute(
				"list",MemberServiceImpl.getInstance().list());*/
		/*request.setAttribute("count", 
				MemberServiceImpl.getInstance().list().size());*/
		//또는 sTRING처리를 안해도 되는듯? MemberServiceImpl.getInstance().list().size 변수처리해서 넣음되긴하는데 귀찮
		super.execute();
	}
	

}
