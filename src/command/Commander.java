package command;

import enums.Action;

public class Commander {
	public static Command order(
		String domain, String action, String page){
		Command cmd = null;
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE : 	
		System.out.println("commender진입");
			cmd = new MoveCommand(domain,action,page);
			break;
		case JOIN : 
			cmd = new CreateCommand(domain,action,page);
			break;
		case LIST :
			cmd = new listCommand(domain,action,page);
			break;
		case SEARCH :
			cmd = new searchCommand(domain,action,page);
			break;
		case RETRIEVE : 
			cmd = new RetrieveCommand(domain,action,page);
			break;
		case COUNT :
			break;
		case UPDATE :
			break;
		case DELETE :
			break;
		}
		return cmd;
	}
}
