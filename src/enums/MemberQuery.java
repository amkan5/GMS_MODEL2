package enums;

import tamplate.ColumnFinder;

public enum MemberQuery { 
	INSERT, 
	LIST,SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,
	LOGIN;
	@Override //컨트롤+스페이스 toSpring
			 // 얘가 상수처리하는것보다 조금 더 느리긴한데 뺵뺵한거임. 
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN :
			query = "SELECT "
					+ColumnFinder.find(Domain.MEMBER)
					+" FROM MEMBER "
					+" WHERE MEMID LIKE ? "
					+" AND PASSWORD LIKE ? ";
			break;
		case INSERT:
			query = "INSERT INTO MEMBER( "
					+ ColumnFinder.find(Domain.MEMBER) //섭젝트 쿼리쳐야해
					+ " ) "
					+" VALUES "
					+"( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			break;
		case COUNT : 
			query = "SELECT COUNT(*) AS COUNT FROM MEMBER";
			break;
		case UPDATE : 
			query = "UPDATE MEMBER SET "
					+ "%s = ?, "
					+ "%s = ?, "
					+ "%s = ? "
					+ "WHERE MEMID LIKE ? ";
			break;
		case DELETE : 
			query = "DELETE FROM MEMBER "
					+ "WHERE MEMID LIKE '%s' "
					+ "AND PASSWORD LIKE '%s'";
			break;
		case LIST :
			query = "SELECT B.* "
					+ "FROM (SELECT "
					+ "ROWNUM RNUM, "
					+ "A.* "
					+ "FROM MEMBER A " //"FROM MEMBER A "
					+ "ORDER BY RNUM ) B "
					+ "WHERE B.RNUM BETWEEN ? AND ?";
					//+ "WHERE B.RNUM BETWEEN %s AND %s"
			break;
		case SEARCH :
			query = "SELECT B.* " // COUNT(*) AS COUNT
					+ "FROM (SELECT "
					+ "ROWNUM RNUM, "
					+ "A.* "
					+ "FROM MEMBER A "
					+ "WHERE %s LIKE ? "
					+ "ORDER BY RNUM ) B "
					+ "WHERE B.RNUM BETWEEN ? AND ?";
			break;
		case RETRIEVE :
			query = "SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM MEMBER "
					+ " WHERE USERID "
					+ " LIKE ? ";
			break;
			
	/*	case SEARCH :
			query = "SELECT "
					+ "TEAMID,"
					+ "TEAM_NAME "
					+ "FROM PROJECT_TEAM "
					+ "WHERE TEAM_NAME LIKE '%s'";
					break;*/
		
		}
		// TODO Auto-generated method stub
		return query;
		
		
	}
	
}
