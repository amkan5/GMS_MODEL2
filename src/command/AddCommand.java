	package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().
				substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER :
				System.out.println("회원가입에 들어옴!!");
				MemberBean mem = new MemberBean();
				mem.setName(request.getParameter("name"));
				mem.setPassword(request.getParameter("password"));
				mem.setMemId(request.getParameter("userid"));
				mem.setSsn(request.getParameter("ssn"));
				mem.setAge(request.getParameter("age"));
				mem.setGender(request.getParameter("gender"));
				mem.setSubject(request.getParameter("subject"));
				mem.setRoll(request.getParameter("roll"));
				mem.setTeamId(request.getParameter("teamid"));
				System.out.println("회원가입 정보 : " +mem.toString());
				MemberServiceImpl.getInstance().add(mem);
				break;
		default:
			break;
		}
		
		super.execute();
	}
}
