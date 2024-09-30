package jdbc25.perpared;


import java.sql.SQLException;
import java.util.Date;

import jdbc25.service.JDBCConnectImpl;

public class InsertSQLMore extends JDBCConnectImpl {
	

	public InsertSQLMore(String url, String user, String password) {
		connect(url,user,password);
	}
	
	public void execute() throws Exception{

		// 1. 쿼리문 미리 준비

		String sql ="INSERT INTO member VALUES(?,?,?,?)";	// ? : in parameter? 인파라미터?
		
		// 2. 쿼리실행을 위한 PrepareStatement 계열 객체 생성

		psmt = conn.prepareStatement(sql);
		while(true) {
			try {
				//쿼리 실행 : 인파라미터 설정
				psmt.setString(1, getValue("아이디"));
				psmt.setString(2, getValue("비밀번호"));
				psmt.setString(3, getValue("이름"));
				psmt.setDate(4,new java.sql.Date(new Date().getTime()));
				psmt.setString(4, getValue("가입일"));
				System.out.println(psmt.executeUpdate()+"행이 입력되었습니다.");
			}
			catch(SQLException e) {
				System.out.println("입력시 오류: "+e.getMessage());	
			}
		}
		// finally 대신 getValue("EXIT")이용
	
	}

	public static void main(String[] args) throws Exception {
		new InsertSQLMore(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA").execute();

	}	//main

}	//class
