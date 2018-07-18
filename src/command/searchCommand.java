package command;

public class searchCommand extends Command{
	 public searchCommand(String domain, String action, String page) {
		 setDomain(domain);
		 setAction(action);
		 setPage(page);
		 execute();
	 }
}
