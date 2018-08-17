package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	 public RetrieveCommand(HttpServletRequest request) {
		 setRequest(request);
		 setDomain(request.getServletPath().
					substring(1,request.getServletPath().indexOf(".")));
		 setAction(request.getParameter("action"));
		 setPage(request.getParameter("page"));
		 execute();
	 }
	 
	 @Override
	public void execute() {
			 System.out.println("리트리버도 왔다. ");
			 //userid 값을 jp에서 가져왔으면 세션에 담어 ㅎ 
			 if(request.getParameter("userid")!=null) {
			 request.getSession().setAttribute("user",
					 MemberServiceImpl.getInstance().retrieve(
								request.getParameter("userid")		
					 ));
			 
			 }
			 //어드민에서 왔을경우 세션에 담아있을꺼니까..... 
			 System.out.println("리트리버 세션담기이전");
			 request.getSession().setAttribute("user",
					 MemberServiceImpl.getInstance().retrieve(
							 ((MemberBean) request.getSession().getAttribute("user")).getMemId()
					 ));
			 System.out.println("리트리버 프로필담기이전");
			 String memid = ((MemberBean) request.getSession().getAttribute("user")).getMemId();
			 
			 ImageBean img = ImageServiceImpl.getInstance()
						.retrieve(memid);
			 System.out.println("memid가 잘찍히는가? " + img);
			 if(img!=null) {
			 request.setAttribute(
					"profile", 
					"upload/"+img.getImgname()
					+"."
					+img.getExtension());
			}
		 super.execute();
	}
}
