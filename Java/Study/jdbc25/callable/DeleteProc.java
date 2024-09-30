package jdbc25.callable;

import java.sql.Types;


import jdbc25.perpared.InsertSQL;
import jdbc25.service.JDBCConnectImpl;

/*
    create or replace procedure sample_delete_member(username_ in member.username%type
    , rtval out number)
    -- rtval 1+:삭제성공, 0:삭제할 대상의 ID존재X, -1:자식이 참조중, 삭제 불가
is
begin
    delete member
    where username = username_;

    if sql%found then  
        rtval := SQL%ROWCOUNT;
        dbms_output.put_line('성공');
    else --존재하지 않는 아이디(PK)로 삭제시
        rtval := 0;
        dbms_output.put_line('찾을 수 없음');
    end if;
    exception
        when others then
            dbms_output.put_line('자식이 참조중');
            rollback;
            rtval := -1;
end;
*/

public class DeleteProc extends JDBCConnectImpl {

	public DeleteProc(String url, String user, String password) {
		connect(url,user,password);
	}
	
	@Override
	public void execute() throws Exception {
		// 1. 프로시저를 실행하기 위한 CallableStatement 객체
		csmt = conn.prepareCall("{call sp_del_member(?,?)}");	// db함수이름과 같아야함
		
		// 2. 파라미터 설정
		String username = getValue("아이디");
		csmt.setString(1, username);
		csmt.registerOutParameter(2, Types.NUMERIC);    //rtval(결과값, 1/0/-1)
		
		// 3.프로시저 실행
		csmt.execute();

        // 4. out파라미터에 저장된 값 읽어오기
        // 1:삭제 성공, 0: 아이디 존재X, -1:자식이 참조
        int result = csmt.getInt(2); //insert의 getString(4)과 같음
        switch (result) {
			case -1:System.out.println("삭제 불가:자식이 참조");break;
			case 0:System.out.println("삭제 불가:아이디가 존재하지 않음");break;
			default:System.out.println(username+" 삭제 성공");
		}

        // 5. 자원반납
        close();

	}
	
	public static void main(String[] args) throws Exception {
		new DeleteProc(ORACLE_BASE_URL+"/XEPDB1", "JAVA","JAVA").execute();

	}

}