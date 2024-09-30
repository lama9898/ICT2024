package jdbc25.etc;

// DB확인 잘하기!

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class TransationSQL extends JDBCConnectImpl {

	public TransationSQL() {
		connect(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA");
	}
	
	@Override
	public void execute() throws Exception {
		try {
			// 1. 자동 커밋이 일어나지 않도록하기
			conn.setAutoCommit(false);
			
			// 1-1) 첫번째 쿼리문 작성
			String sql = "DELETE member WHERE username=?";
			psmt = conn.prepareStatement(sql);
	        psmt.setString(1, getValue("삭제할 아이디"));
	        
	        System.out.println(psmt.executeUpdate()+"행이 삭제됨");
			// auto commit false 상태이기 때문에 반영 안됨
			// 1-2) 두번재 쿼리문 작성
			sql = "INSERT INTO member VALUES(?,?,?,SYSDATE)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, getValue("아이디"));
			psmt.setString(2, getValue("비밀번호"));
			psmt.setString(3, getValue("이름"));
			System.out.println(psmt.executeUpdate()+"행이 입력됨");
			
			// 1-3) try절에서 커밋하기
			conn.commit();
			System.out.println("커밋 완료");
			
		} catch(SQLException e) {
			//에러나면 모두 롤백
			conn.rollback();
			System.out.println("롤백 완료");
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		new TransationSQL().execute();

	}

}
