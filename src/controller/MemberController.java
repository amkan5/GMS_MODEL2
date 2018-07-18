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
			try {
				System.out.println("move안으로진입한다아!!");
				Carrier.send(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case JOIN : 
			mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("password"));
			mem.setMemId(request.getParameter("userid"));
			mem.setSsn(request.getParameter("ssn"));
			//MemberServiceImpl.getInstance().countMember();
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=joinResult"
					); //도메인 response는 jsp에 사는애. 스크립트립. 멤버컨트롤러로 다시 진입시켜?
			System.out.println(mem);
			break;
		case LIST : 
			lst = new ArrayList<>();
			lst = MemberServiceImpl.getInstance().list();
			System.out.println(lst.size());
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=memberlist"
					);
			break;
		case SEARCH : 
			lst = new ArrayList<>();
			lst = MemberServiceImpl.getInstance().selectSome(
					request.getParameter("teamid")
					);
			System.out.println(lst.size());
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=searchTeamResult");
			break;
		case RETRIEVE : 
			System.out.println(
					MemberServiceImpl.getInstance().selectOne(
					request.getParameter("userid")
					).toString()
					);
			response.sendRedirect(request.getContextPath()
					+"/member.do?action=move&page=searchIdResult");
			break;
		case COUNT : 
			System.out.println(
					MemberServiceImpl.getInstance().countMember()
					);
			break;
		case UPDATE : 
			mem = new MemberBean();
			mem.setMemId(
					request.getParameter("userId")
					);
			mem.setPassword(
					request.getParameter("oldPass")
					+"/"
					+request.getParameter("newPass")
					);
			MemberServiceImpl.getInstance().updateMember(mem);
			break;
		case DELETE : 
			MemberServiceImpl.getInstance().deleteMember(mem);
			break;
		case LOGIN : 
			mem = new MemberBean();
			mem.setMemId(
					request.getParameter("userid")
					);
			mem.setPassword(
					request.getParameter("password")
					);
			if(MemberServiceImpl.getInstance().loginB(mem)){
				System.out.println("성공");
			}else {
				System.out.println("id나 비번이 틀립니다");
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
