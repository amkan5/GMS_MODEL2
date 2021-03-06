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
			cmd = new CreateCommand(request);
			break;
		case LOGIN :
			cmd = new LoginCommand(request);
			break;
		case UPDATE :
			cmd = new UpdateCommand(request);
			break;
		case LIST :
			cmd = new ListCommand(request);
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
		case DELETE :
			cmd = new DeleteCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}
}
