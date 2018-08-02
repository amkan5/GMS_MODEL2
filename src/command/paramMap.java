package command;

import javax.servlet.http.HttpServletRequest;

public class paramMap {
	public static String getValues(HttpServletRequest request,String name) {
		String[] values = request.getParameterMap().get(name); //subject가 들어갈꺼햐 
		StringBuffer buff = new StringBuffer(); //모았다가 보내는거? 전송누르기전에 스트링 모아두기 
		for(String s : values) { 
			buff.append(s+",");	
		}
		return buff.toString().substring(0,buff.toString().length()-1);
	}

}
