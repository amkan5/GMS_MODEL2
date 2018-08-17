package enums;

public enum Term {
	WEBPATH,MAIN,COMMON,
	UPLOAD_PATH;
	
	@Override
	public String toString() {
		 String term = "";
		switch (this) {
		case WEBPATH: term = "\\WEB-INF\\view\\";
			break;
		case MAIN : term= "\\main.jsp"; 
			break;
		case COMMON : term = "\\common\\";
			break;
		case UPLOAD_PATH :
			term = "C:\\Users\\1027\\JavaWorkspace\\GMS Model2\\WebContent\\resources\\img\\upload\\";
			break;
		default:
			break;
		}
		return term;
	}
}
