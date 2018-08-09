package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void foward(HttpServletRequest request,
			HttpServletResponse response)  {
		//System.out.println("뷰 :"+Sentry.cmd.getView()); //syso도 패턴걸려있는거ㅎ 
		try {
			System.out.println("캐리어진입");
			request
			.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request,response);
			System.out.println(Receiver.cmd.getView());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request,
			HttpServletResponse response, String url) {
		try {
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("url 주소 : " + request.getContextPath()+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//얘는 보내는일밖에 안함 센트리한테 ? 근데 왜 이렇게하는걸까? 
	//결정은 센트리가. 케리어한테는 뷰만 주고있음. 
	
}
