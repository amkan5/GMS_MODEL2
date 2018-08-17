package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;

public class Commander {
	public static Command order(
		HttpServletRequest request){
		Command cmd = null;
		switch(Action.valueOf(
				request.getParameter("action")
				.toUpperCase())) {
		case MOVE : 	
		System.out.println("므브 commender진입");
			cmd = new MoveCommand(request);
			break;
		case JOIN : 
			cmd = new AddCommand(request);
			break;
		case LOGIN :
			cmd = new LoginCommand(request);
			break;
		case MODIFY :
			cmd = new ModifyCommand(request);
			break;
		case SEARCH :
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE : 
			cmd = new RetrieveCommand(request);
			break;
		case COUNT :
			cmd = new CountCommand(request);
			break;
		case REMOVE :
			cmd = new RemoveCommand(request);
			break;
		case FILEUPLOAD:
			System.out.println("파일업로드 커맨더까지왔나");
			cmd = new FileCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}
}
