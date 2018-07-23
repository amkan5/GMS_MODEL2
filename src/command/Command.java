package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import lombok.Data;

@Data
public class Command implements Order { //일반빈하고 다름. implements를 사용. 
	protected HttpServletRequest request;
	protected String action,domain,page,view;
	public HttpServletRequest getRequest() {
		return request;
	}
	
	@Override
	public void execute() {
		this.view = "/WEB-INF/view/" +domain+"/"+page+".jsp";

	}

}
