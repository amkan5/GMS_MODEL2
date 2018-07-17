package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/member.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기로 들어온다!!");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		switch(action) {
		case "move" : 
			request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp")
			.forward(request, response);
			break;
		/*case "/member/joinResult.do" : 
			request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);
			break;
		case "/member/userLoginForm.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/userLoginForm.jsp").forward(request, response);
			break;
		case "member/userLoginResult.do" :
			request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);
			break;*/
		/*case "../../index.do" :
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;*/
		default: break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
