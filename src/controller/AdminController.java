package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet({"/admin.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AdminController() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Sentry.init(request);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE : 
			System.out.println("어드민므브");
			Carrier.foward(request, response);
			break;
		case LIST :
			request.getAttribute("list");
			request.getAttribute("count");
			Carrier.foward(request, response);
			break;
		case RETRIEVE :
			Carrier.foward(request, response);
			break;
		case SEARCH :
			System.out.println("어드민의 써치");
			request.getAttribute("list");
			Carrier.foward(request, response);
			break;
		case COUNT :
			Carrier.foward(request, response);
			break;
		default:
			break;
		}
	}	
}