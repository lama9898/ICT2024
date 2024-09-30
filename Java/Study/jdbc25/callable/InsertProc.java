package jdbc25.callable;
import java.sql.Types;

import jdbc25.statement.InsertSQL;
import jdbc25.service.JDBCConnectImpl;

/*
    user java 의 sample insert number 테이블 붙여넣기
    변수받아서 member 추가
*/

public class InsertProc extends JDBCConnectImpl{
	public InsertProc(String url, String user, String password) {
		connect(url,user,password);
	}
	
	@Override
	public void execute() throws Exception {
		// 1. 프로시저 실행하기 위한 Callable Statement 객체 얻기
        /*
            Connection객체의 prepareCall("{call 프로시저명(?, ?, ...)}") 메소드를 호출
              - 인 파라미터 설정시 setXXXX(파라미터_인덱스,값)으로 설정
              - 아웃 파라미터 설정시 registerOutParameter(파라미터_인덱스, java.sql.Types 클래스의 int형 상수)
        */
		csmt = conn.prepareCall("{call sp_ins_member(?,?,?,?)}");
		
		// 2. 파라미터 설정
        // 2-1) 인파라미터(?) 설정
        //      : 오라클의 in파라미터에 해당하는 ? 설정 <- setxxxx(파라미터_인덱스,값)으로
		csmt.setString(1, getValue("아이디")); //username
		csmt.setString(2, getValue("비밀번호")); //password
		csmt.setString(3, getValue("이름")); //name
		
        // 2-2) 오라클의 OUT 파라미터에 해당하는 ? 설정 <- registerOutParameter()
		csmt.registerOutParameter(4,Types.NVARCHAR); //rtval (결과)
		
        // 3. 프로시저 실행 : execute()
		System.out.println(csmt.execute());
		
		// 4. out파라미터에 저장된 값 읽어오기 : CallableStatement객체의 getXXX() 계열 메소드 이용
		System.out.println("프로시저의 아웃 파라미터 값 :"+csmt.getString(4));
		
		// 자원반납
		close();
	}
	
	public static void main(String[] args) throws Exception {
		new InsertProc(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA").execute();
	}
}