package jdbc25.perpared;


import java.sql.SQLException;
import java.util.Date;

import jdbc25.service.JDBCConnectImpl;

public class InsertSQL extends JDBCConnectImpl {
	

	public InsertSQL(String url, String user, String password) {
		connect(url,user,password);
	}
	
	public void execute() throws Exception{
		
		// 속도, 성능에서 statement보다 prepared statement가 유리함
		// prepared statement는 '""'에서 ''를 신경쓸 필요가 없다
		
		// 1. 쿼리문 미리 준비
		// 1-1) 인파라미터가 없는 쿼리문
		//String sql ="INSERT INTO member VALUES('KIM','KIM1234','김길동',SYSDATE)";
		// 1-2) 인파라미터가 있는 쿼리문 - 데이터에 해당하는 부분만 ? 처리 가능
		String sql ="INSERT INTO member VALUES(?,?,?,?)";	// ? : in parameter? 인파라미터?
		
		// 2. 쿼리실행을 위한 statement 계열 객체 생성
		/*
		 *  PreparedStatement 객체는 객체 생성시 미리 쿼리문을 준비해서
		 *  Connection객체의 prepareStatement(쿼리문)메소드의 인자로 전달해야함
		 *  
		 *  PreparedStatement 객체 생성시 전달된 쿼리문을 먼저 parsing 하기 때문에 실행시에는 바로 실행
		 *  실행시에는 쿼리문을 전달할 필요가 없음.
		 */
		
		// 3. 쿼리 실행 : 실행시 쿼리문 전달 불필요
		/*
		 *  - 인파라미터가 없는 쿼리문
		 *  
		 *  - 자료형에 상관없이 setString() 설정가능
		 *  즉 Result 
		 *  
		 */
		psmt = conn.prepareStatement(sql);	//statement 준비 시 쿼리 검사, 쿼리문 미리 전달 (실행시 전달x)
		try {
			psmt.setString(1, getValue("아이디"));
			psmt.setString(2, getValue("비밀번호"));
			psmt.setString(3, getValue("이름"));
			psmt.setDate(4,new java.sql.Date(new Date().getTime()));
			psmt.setString(4, getValue("가입일"));
			System.out.println(psmt.executeUpdate()+"행이 입력되었습니다.");
		} catch(SQLException e) {System.out.println("입력시 오류: "+e.getMessage());	}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		try {
			new InsertSQL(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA").execute();
		} catch(Exception e) { System.out.println("오류발생! "+e.getMessage());}

	}	//main

}	//class
