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
import command.Receiver;
import command.SearchCommand;
import domain.*;
import enums.Action;
import service.*;

@WebServlet({"/member.do"}) //ServeltPath 
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MemberController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("MemberController Enter!!");
		Receiver.init(request);
		System.out.println("액션: "+Receiver.cmd.getAction());
/*		String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		List<MemberBean> lst = null;
		MemberBean mem = null;
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		
		case ADD: 
			Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			//도메인 response는 jsp에 사는애. 스크립트립. 멤버컨트롤러로 다시 진입시켜?
			System.out.println(mem);
			break;
		case MODIFY : 
			System.out.println("컨트롤러-업데이트 진입");
			Carrier.redirect(request, response,"/member.do?action=move&page=my_page");
			break;
		case REMOVE : 
			Carrier.redirect(request, response, "/member.do?action=move&page=userLoginForm");
			break;
		case SEARCH : 
			Carrier.redirect(request, response, "/member.do?action=move&page=searchTeamResult");
			break;
		case RETRIEVE : //하나만 가져오는s거 
			Carrier.redirect(request, response, "/member.do?action=move&page=searchIdResult");
			break;
		case MOVE : 
			/*	request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp")
				.forward(request, response);*/
				Carrier.foward(request, response);
				break;
		case COUNT : 
			System.out.println(
					MemberServiceImpl.getInstance().countMember()
					);
			break;
		case LOGIN : 
			System.out.println("로그인진입");
			if(request.getAttribute("match").equals("TRUE")) {
				/*request.getSession()
				.setAttribute("user", request.getAttribute("user"));*/ //반복제거
				Carrier.foward(request,response);
				//왜 로그인커맨드에서 안하고 여기서 하는걸까? 
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
