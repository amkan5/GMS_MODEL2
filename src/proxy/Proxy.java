package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class Proxy implements Capable {
	private Pagination pagination; //Proxy로 안받아두됨 
	HttpServletRequest request;

	@Override
	public void carryout(Object o) {
		this.pagination = new Pagination();
		pagination.carryout(o);
		//페이지네이션이면 페이지네이션으로 가고
		//체크박스 쓸꺼면 체크박스로 가고 ㅎㅎ 
	}


	
//	@Override 이건왜한거야?
/*	public public void carryout(Object o) {
		Map<String,Object> map = new HashMap<>();
		request = (HttpServletRequest) param.get("request");
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage); 
		param.put("beginRow", String.valueOf(beginRow));
		param.put("endRow", String.valueOf(endRow)); //담아서 던짐. 
		request.setAttribute("page", page);
		map.put("request", request); //제네릭. 뭐든 담아버림 ㅋ 
		return map;
	}*/
}
