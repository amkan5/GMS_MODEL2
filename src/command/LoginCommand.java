package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
public LoginCommand(HttpServletRequest request) {
	setRequest(request); //얘는 엄밀하게 말하면 super임 ㅎ 커맨드에 있는거. 엄마꺼 
	setDomain(request.getServletPath().
			substring(1,request.getServletPath().indexOf(".")));
	setAction(request.getParameter("action"));
	this.execute(); //view 
}
@Override
	public void execute() {
		super.execute(); //view를 만들어줌. 
		System.out.println("로그인커맨드 진입");
		if(request.getParameter("userid")==null) {
			request.getSession().invalidate();
			request.setAttribute("match", "FALSE");
		}else {
			MemberBean mem = new MemberBean();
			mem.setMemId(
					request.getParameter("userid") //커맨드에 있는 리퀘스트.							 
					); 
			mem.setPassword(
					request.getParameter("password")
					);
			if(MemberServiceImpl.getInstance().login(mem)){
				request.setAttribute("match", "TRUE");
				request.getSession().setAttribute("user", 
						MemberServiceImpl.getInstance()
						.retrieve(
									request.getParameter("userid")));
				System.out.println("login : 성공");
				ImageBean img = ImageServiceImpl.getInstance()
						.retrieve(request.getParameter("userid"));
				if(img!=null) {
					System.out.println("이미지값 있음에 진입"+img.getImgname());
				request.setAttribute(
					"profile", 
					"upload/"+img.getImgname()
					+"."
					+img.getExtension());
				}else {
					System.out.println("이미지값 없음");
				}
			}else {
				request.setAttribute("match", "FALSE");
				System.out.println("login : id나 비번이 틀립니다");
			
			} 
		}
	}
}
