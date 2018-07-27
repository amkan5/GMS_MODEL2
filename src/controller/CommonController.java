package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import enums.Domain;
import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CTX,CSS,JS,IMG;
	}
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		int i = 0;
		for(Resources r: Resources.values()) {
				request.getSession()
				.setAttribute(r.toString().toLowerCase(), 
						(i==0)?
						request.getContextPath():
						request.getContextPath()+"/resources/"+r.toString().toLowerCase()
						);			
			i++;
			System.out.println(request.getContextPath()+"/resources/"+r.toString().toLowerCase());
			}
	/*	HttpSession session = request.getSession(); *///갖고와서 객체를 만드는 관계. 필드에 Session객체가 있오. 그거 하나 준거라 얘는 죽지않음. 
		/*session.setAttribute(Domain.CONTEXT.toString(), 
				request.getContextPath()); *///ctx
		request.getRequestDispatcher(
				Term.WEBPATH.toString()+Term.MAIN.toString())
				.forward(request,response);
		System.out.println("커먼에 들어옴");
		/*request.getRequestDispatcher("/WEB-INF/view/main.jsp")
		.forward(request, response);*/
	}
	}


