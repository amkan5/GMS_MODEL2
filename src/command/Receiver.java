package command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command(); //static으로 준 이유. 하나만해. 
	public static void init(HttpServletRequest request) {
/*		String servletPath=request.getServletPath();
		System.out.println("센트리 : "
				+servletPath.substring(1,servletPath.indexOf(".")));*/
		cmd = Commander.order(request);
	}
}
