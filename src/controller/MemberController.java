package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import command.ListCommand;
import domain.*;
import enums.Action;
import service.*;

@WebServlet({"/member.do"}) //ServeltPath 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("MemberController Enter!!");
		Sentry.init(request);
		System.out.println("액션: "+Sentry.cmd.getAction());
/*		String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		List<MemberBean> lst = null;
		MemberBean mem = null;
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
		/*	request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp")
			.forward(request, response);*/
			Carrier.foward(request, response);
			break;
		case JOIN: 
			Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			//도메인 response는 jsp에 사는애. 스크립트립. 멤버컨트롤러로 다시 진입시켜?
			System.out.println(mem);
			break;
		case UPDATE : 
			Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			break;
		case DELETE : 
			Carrier.redirect(request, response, "/member.do?action=move&page=userLoginForm");
			break;
		case SEARCH : 
			Carrier.redirect(request, response, "/member.do?action=move&page=searchTeamResult");
			break;
		case RETRIEVE : //하나만 가져오는s거 
			Carrier.redirect(request, response, "/member.do?action=move&page=searchIdResult");
			break;
		case LIST : 
			request.getAttribute("list");
			Carrier.redirect(request, response, "/member.do?action=move&page=memberlist");
			/*response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=memberlist"
					);*/
			
			break;
		case COUNT : 
			System.out.println(
					MemberServiceImpl.getInstance().countMember()
					);
			break;
		case LOGIN : 
			System.out.println("로그인진입");
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.foward(request,response);
			}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=userLoginForm");
			}
			break;
		default: break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
