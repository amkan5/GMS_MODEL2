package enums;


public enum Domain {
	MEMBER,EXAM,PROJECTTEAM,RECORD,SUBJECT, CONTEXT, WEBPATH, MAIN;

@Override
public String toString() {
	String result = "";
	switch (this) {
	case MEMBER :
		 result="MEMBER";
		break;
	}
	return result;
}
}



