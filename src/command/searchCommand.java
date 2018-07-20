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
	switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
	case MEMBER :
		/*List lst = new ArrayList<>();
		lst = MemberServiceImpl.getInstance().selectSome(
				request.getParameter("teamid")
				);*/
		System.out.println("써치성공");
		break;
	default:
		break;
	}
		super.execute();
	}

public List<MemberBean> getMem() {
	return mem;
}
}
