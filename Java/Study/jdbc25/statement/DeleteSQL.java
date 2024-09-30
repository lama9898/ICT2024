package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {

	private Connection conn;
	private Statement stmt;
	
	
	
	public DeleteSQL() {
		// 1. JDBC용 오라클 드라이버를 메모리에 로딩 (MS-SQL의 경우 MS-SQL 드라이버)
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 오라클에 연결시도 : DriverManager의 getConnection()메소드로 연결
			// 연결되면 connection 객체가 반환됨
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1","JAVA","JAVA");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 발견 불가-드라이버 로딩 실패...");	
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패...");	
		} 
		
	} // 기본 생성자

	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e) { }
	} // close()

	private void execute() {
		// 오라클로 쿼리 전송
		// 3. 쿼리를 실행하기 위한 Statement 객체 생성, 연결된 Connection 객체로
		try {
			stmt = conn.createStatement();
			// stmt 객체 생성 잘 된 경우 쿼리 생성
			// 4. Statement 계열 객체로 쿼리실행
			// DELETE / UPDATE / INSERT 경우 : int executeUpdate() // 영향 받은 행의 수 : int
			// SELECT 경우 : ResultSet executeQuery()
			try {
				int affected = stmt.executeUpdate("DELETE FROM member WHERE UPPER(username)='KIM'");
				System.out.println(affected+"행이 삭제되었음");
			} catch(SQLException e) {
				System.out.println("삭제시 오류:"+e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Statement 객체 생성 실패...");	
		} finally {
			// 5. 데이터베이스 연결 해제 (되든 안되든, "자원반납")
			close();
		}
	} //execute()

	public static void main(String[] args) {
		// <1> sql developer 계정만들기
		
		// 6.
		new DeleteSQL().execute();
		
		
	}	//main

}	//class InsertSQL
