package jdbc25.perpared;

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class DeleteSQL extends JDBCConnectImpl{

	@Override
	public void execute() throws Exception {
		// 1. preapared Statement 객체 생성
		psmt = conn.prepareStatement("DELETE FROM member WHRE username =?)");
		// 2. 인파라미터 설정
		psmt.setString(1,getValue("삭제할 아이디"));
		
		try {
			System.out.println(psmt.executeUpdate() + "행이 삭제되었어요");
		}
		catch(SQLException e) {
			System.out.println("삭제시 오류 :"+e.getMessage());
		}
		finally { close(); }
		
		} 
	public static void main(String[] args) throws Exception {
		DeleteSQL deleteSQL = new DeleteSQL();

		deleteSQL.connect(ORACLE_BASE_URL+"/XEPDB1","JAVA", "JAVA");
		deleteSQL.execute();
		
	}

}
