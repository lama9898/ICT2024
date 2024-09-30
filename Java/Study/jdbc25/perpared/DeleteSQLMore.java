package jdbc25.perpared;

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class DeleteSQLMore extends JDBCConnectImpl{

	@Override
	public void execute() throws Exception {
		// 1. PreparedStatement 객체 생성
		psmt = conn.prepareStatement("DELETE FROM member WHRE username =?)");
		
		while(true) {
			try {
				// 2. 인파라미터 설정
				psmt.setString(1,getValue("삭제할 아이디"));
				// 3. 쿼리설정
				System.out.println(psmt.executeUpdate() + "행이 삭제되었어요");
			}
			catch(SQLException e) {
				System.out.println("삭제시 오류 :"+e.getMessage());
			}
			}
		} 
	public static void main(String[] args) throws Exception {
		DeleteSQLMore deleteSQL = new DeleteSQLMore();

		deleteSQL.connect(ORACLE_BASE_URL+"/XEPDB1","JAVA", "JAVA");
		deleteSQL.execute();
		
	}

}
