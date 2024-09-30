package jdbc25.perpared;

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class UpdateSQLMore extends JDBCConnectImpl {
	
	@Override
	public void execute() throws Exception {
		// 0 데이터 베이스 연결
		connect(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA");
		
		// 1. PreparedStatment 객체 생성
		psmt = conn.prepareStatement("UPDATE member SET name=?,password=? WHERE username=?");
		// 쿼리문이 바뀌지 않는 한 한번만 생성하면 됨.
		while(true) {
			// 2. 인파라미터 설정
			// 존재하는 아이디 있을 때 이름/비밀번호 받는 UI가 더 사용자 경험을 높임 -> 직접해보기
			psmt.setString(3,getValue("수정할 아이디"));
			psmt.setString(1,getValue("수정할 이름"));
			psmt.setString(2,getValue("수정할 비밀번호"));
			try {
			// 3. 쿼리 실행
			System.out.println(psmt.executeUpdate()+"행이 수정됨");
			} catch(SQLException e) { System.out.println("수정시 오류: "+e.getMessage());	}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new UpdateSQLMore().execute();
	}	//main
}	//class
