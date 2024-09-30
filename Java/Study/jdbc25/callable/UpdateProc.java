package jdbc25.callable;

import java.sql.Types;


import jdbc25.perpared.InsertSQL;
import jdbc25.service.JDBCConnectImpl;

/*
	create or replace procedure sample_update_member(
	    username_ in member.username%type
	    , password_ member.password%type
	    , name_ member.name%type
	    , rtval out nchar)
	is
	begin
	    update member set password = password_, name = name_
	    where username = username_;
	    
	    if sql%found then  
	        rtval := 'update success';
	        commit;
	    else --존재하지 않는 아이디pk로 수정시
	        rtval := 'fail:no existing username';
	    end if;
	    exception 
	    when others then
	            rollback;
	            rtval := 'Fail:too much value';
	end;
	/  

*/

public class UpdateProc extends JDBCConnectImpl {

	public UpdateProc(String url, String user, String password) {
		connect(url,user,password);
	}
	
	@Override
	public void execute() throws Exception {
		// 1. 프로시저를 실행하기 위한 CallableStatement 객체
		csmt = conn.prepareCall("{call sample_update_member(?,?,?,?)}");	// db함수이름과 같아야함
		
		// 2. 파라미터 설정
		String username = getValue("아이디");
		csmt.setString(1, username);
		csmt.setString(2, getValue("비밀번호"));
		csmt.setString(3, getValue("이름"));
		csmt.registerOutParameter(4, Types.NCHAR);    //rtval
		
		// 3.프로시저 실행
		csmt.execute();

        // 4. out파라미터에 저장된 값 읽어오기
		System.out.println(csmt.getString(4)); //insert의 getString(4)과 같음

        // 5. 자원반납
        close();

	}
	
	public static void main(String[] args) throws Exception {
		new UpdateProc(ORACLE_BASE_URL+"/XEPDB1", "JAVA","JAVA").execute();

	}

}