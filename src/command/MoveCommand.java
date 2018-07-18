package command;

public class MoveCommand extends Command {
	public MoveCommand(String domain, String action, String page) {
		System.out.println("movecommender진입");
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}

}
