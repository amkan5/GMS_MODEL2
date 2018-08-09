package enums;

public enum Term {
	WEBPATH,MAIN,COMMON;
	
	@Override
	public String toString() {
		 String term = "";
		switch (this) {
		case WEBPATH: term = "/WEB-INF/view/";
			break;
		case MAIN : term= "/main.jsp"; 
			break;
		case COMMON : term = "/common/";
			break;
		default:
			break;
		}
		return term;
	}
}
