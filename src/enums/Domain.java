package enums;

public enum Domain {
	MEMBER,EXAM,PROJECTTEAM,RECORD,SUBJECT, CONTEXT, WEBPATH, MAIN;
	
	@Override
	public String toString() {
		String domain = "";
		switch (this) {
		case CONTEXT : domain = "ctx" ;
			break;
		default:
			break;
		}
		return domain;
	}
}


