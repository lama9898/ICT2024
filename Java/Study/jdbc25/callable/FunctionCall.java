package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.JDBCConnectImpl;

// DB에서 첫글자 제외 모두 '*'로 바꿔주는 함수 가져와서 주석 달아놓기 (강사님이랑 이름다름) 
/*
	create or replace function changeVarchar(cString varchar2)
	    return varchar2
	is
	    rString varchar2(20);
	begin
	    rString := rpad(substr(cString,1,1),length(cString),'*');
	    return rString;
	end;
 */

public class FunctionCall extends JDBCConnectImpl {

	public FunctionCall() {
		connect(ORACLE_BASE_URL+"/XEPDB1","scott", "scott");
	}
	
	@Override
	public void execute() throws Exception {
		/*
	  	1]오라클에 정의된 함수를 실행하기 위한 CallableStatement객체 생성
	 
	    -Connection객체의 prepareCall()메소드로  생성
	    -형식
	     prepareCall("{? = call 함수명(?,?...)}");
	    
	    -첫번째 물음표는 반환값을 의미
	          반환값은 파라미터 설정시 java.sql.Types클래스의 int형 상수로 설정한다.
	          설정시 registerOutParameter()메소드 사용		    
	          매개변수 설정시는 기존 PreparedStatement객체와 동일
		  */
		csmt = conn.prepareCall("{? = call changeVarchar(?)}");
		
		// 2. 인파라미터 설정
		// 매개변수(인파라미터)는 setxxx() 계열 메소드로 설정
		csmt.setString(2, getValue("문자열"));
		// 2번째 ?에 getValue로 값받아서 대입
		
		// 3. 1번 물음표
		// 반환값에 해당하는 '?='의 ?는 아웃파라미터 방식으로 설정(registerOutParameter), 무조건 인덱스 1로
		csmt.registerOutParameter(1,Types.VARCHAR);
		
		// 4. 함수 실행 : 무조건 execute()메소드로 실행
		System.out.println(csmt.execute());
		
		// 5. 반환값은 getxxx()계열로, 인덱스는 무조건 1
		System.out.println("함수의 반환값은 "+csmt.getString(1));
		
		// 6. 자원반납
		close();
	}
	
	public static void main(String[] args) throws Exception {
		new FunctionCall().execute();
		

	}

}
