package jdbc25.etc;

import java.sql.ResultSet;

import jdbc25.service.JDBCConnectImpl;

public class ResultSetType extends JDBCConnectImpl{

	public ResultSetType(String url, String user, String password) {
		connect(url,user,password);
		
	} //
	
	@Override
	public void execute() throws Exception {
		// 1.쿼리문 준비
		String sql = "SELECT * FROM emp ORDER BY sal DESC";
		
		// 2.쿼리 실행용 객체 생성
		// 2-1) 커서를 전진(forward)만 가능 (next()만 호출가능) 
		//psmt = conn.prepareStatement(sql);
		
		// 2-2) 커서를 전/후진이 가능하도록 설정
		psmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		try {
		// 3. 쿼리실행
		rs = psmt.executeQuery();
		System.out.println("커서를 마지막 레코드로 이동: "+rs.last());
		System.out.println("총 레코드수: "+rs.getRow());
		System.out.println("<< 연봉 높은 순 >>");
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(String.format("%-6s%-8s%-11s%-6s%s",rs.getString(1),rs.getString(2),rs.getString(3)
					, rs.getString(6), rs.getDate(5)));
		}
		System.out.println("<< 연봉 낮은 순 >>");
		while(rs.previous()) {
			System.out.println(String.format("%-6s%-8s%-11s%-6s%s",rs.getString(1),rs.getString(2),rs.getString(3)
					, rs.getString(6), rs.getDate(5)));
		}
		
		}
		finally { // 4. 자원반납
			close();
		}
	}

	public static void main(String[] args) throws Exception {
		new ResultSetType(ORACLE_BASE_URL+"/XEPDB1","SCOTT","scott").execute();

	}	// main

} //class
