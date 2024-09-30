package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.JDBCConnectImpl;

public class IsMember extends JDBCConnectImpl {
/*
 * 	out 파라미터 값
 *  회원인 경우 1 
 *
 *  create or replace procedure sp_ismember(
    username_ in member.username%type,
    password_ member.password%type,
    rtval out number
    )
	is
    	flag number(1);
	begin
	    select count(*) into flag from member
	    where username = username_;
	
	    if flag=0 then
	    -- 일치X
	        dbms_output.put_line('fail: wrong username');
	        rtval :=-1;
	    else
	    -- 아이디 존재
	        select count(*) into flag from member
	        where username = username_ and password = password_;
	        if flag=0 then
	        -- 비번 일치X
	            rtval := 0;
	            dbms_output.put_line('fail: correct username but wrong password');
	        else
	            rtval := 1;
	             dbms_output.put_line('success! '|| username_ || ' enjoy');
	        end if;
	    end if;
	end;
 */
	
	public IsMember(String url, String user, String password) {
		super(url,user,password);
	}
	
	@Override
		public void execute() throws Exception {
			// 1. 프로시저 실행을 위한 CallableStatement 객체 얻기
			csmt = conn.prepareCall("{call sp_ismember(?,?,?)}");
			
			// 2. 파라미터 설정
			csmt.setString(1,getValue("아이디"));
			csmt.setString(2,getValue("비번"));
			// 2-2) 오라클의 out 파라미터에 해당하는 ? 설정, registerOutParameter로
			csmt.registerOutParameter(3,  Types.NUMERIC);
			
			// 3. 프로시저 실행 : execute()
			csmt.execute();
			
			// 4. out 파라미터에 저장된 값 읽어오기
			int result = csmt.getInt(3);
			switch(result) {
				case -1: System.out.println("아이디가 존재하지 않음");break;
				case 0: System.out.println("아이디는 일치하나 비번이 틀림");break;
				default : System.out.println("존재");
			}
			
			// 자원반납
			 close();
		}

	public static void main(String[] args) throws Exception {
		new IsMember(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA").execute();
	}
}
