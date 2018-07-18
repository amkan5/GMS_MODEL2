package command;

public class listCommand extends Command{
	 public listCommand(String domain, String action, String page) {
		 setDomain(domain);
		 setAction(action);
		 setPage(page);
		 execute();
	 }

}
