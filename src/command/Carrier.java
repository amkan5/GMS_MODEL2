package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void send(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("뷰 :"+Sentry.cmd.getView()); //syso도 패턴걸려있는거ㅎ 
		request
		.getRequestDispatcher(Sentry.cmd.getView())
		.forward(request,response);
	}
	//얘는 보내는일밖에 안함 센트리한테 ? 근데 왜 이렇게하는걸까? 
	//결정은 센트리가. 케리어한테는 뷰만 주고있음. 
	
}
