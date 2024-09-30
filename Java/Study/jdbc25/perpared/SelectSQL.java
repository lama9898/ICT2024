package jdbc25.perpared;

import jdbc25.service.JDBCConnectImpl;

public class SelectSQL extends JDBCConnectImpl {
	
	//(2)
	public SelectSQL() {
		connect(ORACLE_BASE_URL+"/XEPDB1","SCOTT","scott");
	}
	
	//(3)
	@Override
	public void execute() throws Exception {
		// 1. 미리 쿼리문 준비
		// 1-1) 특정 문자로 시작하는 레코드 검색   - like의 %S%에서 %?%라고 쓰면 안됨 % || ? || % 로
//		String sql ="SELECT ename, TO_CHAR(sal,'L99,999') sal, job,TO_CHAR(hiredate,'YYYY.MM.DD')"
//				+ " FROM emp WHERE UPPER(ename) LIKE ?||'%' ORDER BY hiredate DESC";
		// ?% : ?로 시작하는 이름
		
		// 1-2) 특정 문자로 끝나는 레코드 검색
//		String sql ="SELECT ename, TO_CHAR(sal,'L99,999') sal, job,TO_CHAR(hiredate,'YYYY.MM.DD')"
//				+ " FROM emp WHERE UPPER(ename) LIKE '%'||? ORDER BY hiredate DESC";
		
		// 1-3) 특정 문자가 포함된 레코드 검색
		String sql ="SELECT ename, TO_CHAR(sal,'L99,999') sal, job,TO_CHAR(hiredate,'YYYY.MM.DD')"
				+ " FROM emp WHERE UPPER(ename) LIKE '%'||?||'%' ORDER BY hiredate DESC";
		
		// 2. PreparedStatement 객체 생성
		psmt = conn.prepareStatement(sql);
		// 3. 인파라미터 설정
		psmt.setString(1,getValue("찾을 문자열").toUpperCase());
		try {
			// 4. 쿼리실행
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%-8s%-8s%-10s%s",
						rs.getString(1), rs.getString(2).trim(), rs.getString(3), rs.getString(4)));
			}
			
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) throws Exception {
		//(1)
		new SelectSQL().execute();

	}// main

}// class
