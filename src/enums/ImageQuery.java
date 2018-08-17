package enums;

import tamplate.ColumnFinder;

public enum ImageQuery {
	INSERT,
	RETRIEVE;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT : 
			query = "INSERT INTO IMAGE(IMGSEQ,IMGNAME,EXT,MEMID) VALUES"
					+ "(IMGSEQ.NEXTVAL, ? , ? , ? )";
			
			/*"INSERT INTO IMAGE("
					+ "IMGSEQ,"
					+ "IMGNAME,"
					+ "EXT,"
					+ "MEMID) VALUES"
					+ "(IMGSEQ.NEXTVAL, ?, ?, ?)"*/; //value1,2,3
			break;
		case RETRIEVE :
			query = "SELECT IMGSEQ,IMGNAME, EXT, MEMID FROM IMAGE "
					+ "WHERE MEMID "
					+ "LIKE ?";
			break;
		default :
			break;
		}
		return query;
	}

}

