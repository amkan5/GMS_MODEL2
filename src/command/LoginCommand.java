package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
public LoginCommand(HttpServletRequest request) {
	setRequest(request); //얘는 엄밀하게 말하면 super임 ㅎ 커맨드에 있는거. 엄마꺼 
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	setPage("my_page");
	this.execute(); //view 
}
@Override
	public void execute() {
		super.execute(); //view를 만들어줌. 
		System.out.println("로그인커맨드 진입");
			MemberBean mem = new MemberBean();
			mem.setMemId(
					request.getParameter("userid") //커맨드에 있는 리퀘스트.
												 
					); 
			mem.setPassword(
					request.getParameter("password")
					);
			if(MemberServiceImpl.getInstance().loginB(mem)){
				request.setAttribute("match", "TRUE");
				request.setAttribute("user", 
						MemberServiceImpl.getInstance()
						.selectOne(
								request.getParameter("userid")));
				System.out.println("login : 성공");
			}else {
				request.setAttribute("match", "FALSE");
				System.out.println("login : id나 비번이 틀립니다");
			
			} 
	}
}
