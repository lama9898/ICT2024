package jdbc25.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCConnectImpl implements JDBCConnect{
	// 1. 필드부터 선언
	public Connection conn;
	public ResultSet rs;
	public Statement stmt;
	public PreparedStatement psmt;
	public CallableStatement csmt;
	private Scanner sc = new Scanner(System.in);
	
	// 2. static 블락
	static {
		try {
			// 1) 드라이버 로딩
			Class.forName(ORACLE_DRIVER);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	// 2) 생성자
	public JDBCConnectImpl() {
	}
	
	public JDBCConnectImpl(String url, String user, String password) {
		connect(url,user,password);
	}
	
	// 3) 데이터베이스 연결하는 메소드
	@Override
	public void connect(String url, String user, String password) {
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패: "+e.getMessage());
		}
		
	}

	// ) 쿼리 실행 메소드
	@Override
	public void execute() throws Exception {
		
		
	}

	// 4) 데이터베이스 연결 끊는 메소드
	@Override
	public void close() {
		try {
			if(csmt!=null) csmt.close();
			if(psmt!=null) psmt.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			if(conn!=null) conn.close();
		} catch(Exception e) { }
		
	}

	// 5) 사용자 입력용 메소드
	@Override
	public String getValue(String msg) {
		System.out.print(msg+"을(를) 입력하세요 >>> ");
		String value = sc.nextLine().trim();
		if("EXIT".equalsIgnoreCase(value)) {
			close(); //"자원반납" 데이터베이스 연결 바로 끊기
			System.out.println("데이터베이스와의 연결이 끊어졌습니다.");
			System.exit(0);
		}
		return value;
	}

	
	@Override
	public String getQueryString() {
		System.out.print("SQL>");
		return sc.nextLine().trim();
	}

}
