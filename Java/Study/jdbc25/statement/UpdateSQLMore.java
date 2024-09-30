package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class UpdateSQLMore extends JDBCConnectImpl{

	// 1. 생성자에서 연결
	public UpdateSQLMore(String url, String user, String password) {
		super(url,user,password);
	}
	
	// 3.
	@Override
	public void execute() throws Exception {
		// 3-1) 쿼리 전송용 Statement 객체 생성
		stmt = conn.createStatement();
		
		while(true) {
			// 3-2) 쿼리실행 -> stmt.executeUpdate가 SQLException 던지니까 try catch 해주기
			try {
				String username = getValue("수정할 아이디"); // 수정할 아이디 먼저 받기
				String sql = "UPDATE member SET name='"+getValue("이름")+"', password='"+getValue("비밀번호")
														+"' WHERE UPPER(username)='"+username+"'";
				System.out.println(stmt.executeUpdate(sql)+"행이 수정되었습니다.");
			} catch(SQLException e) { System.out.println("수정 시 오류 : "+e.getMessage()); }
		}
	}
	
	
	// 2.
	public static void main(String[] args) throws Exception {
		new UpdateSQLMore(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA").execute();

	}	//main

}	//class UdpateSQL
