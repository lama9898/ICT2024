package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.JDBCConnectImpl;

public class SelectSQL extends JDBCConnectImpl {

	public SelectSQL() {
		super();
	} // 기본 생성자 -> 부모 기본생성자는 connect 호출 안해서 


	@Override
	public void execute() throws Exception {
		// 1. 데이터베이스 연결
		connect(ORACLE_BASE_URL+"/XEPDB1", "SCOTT", "scott");
		
		// 2. statement 객체 생성
		stmt = conn.createStatement();
		
		try {
			// 3. 쿼리문 작성
			// 3-1) 여러개 레코드를 반환하는 select문
			//String sql = "SELECT * FROM emp ORDER BY hiredate DESC";
			// 3-2) 한개의 레코드를 반환하거나 0개의 레코드를 반환하는 경우 (주로 PK로 검색)
			//String sql = "SELECT * FROM emp WHERE empno = "+getValue("사원번호");
			
			// 3-3) 무조건 레코드 하나 반환하는 경우 : 그룹함수 사용
			//String sql = "SELECT avg(sal) FROM emp";
			// 3-3)a. /*3-2)a 주석처리*/
			
			// 3-4)LIKE 연산자를 포함한  SELECT문
			//String sql = "SELECT * FROM emp WHERE UPPER(ename) LIKE '%S%'";
			//String sql = "SELECT * FROM emp WHERE UPPER(ename) LIKE '%' || 'S' || '%'";
			//String sql = "SELECT * FROM emp WHERE UPPER(ename) LIKE '%"+getValue("찾을 문자열").toUpperCase()+"%'";
			String sql = "SELECT * FROM emp WHERE UPPER(ename) LIKE '%' || '"+getValue("찾을 문자열").toUpperCase()+"' || '%'";
			
			
			// 4. 쿼리 실행
			rs = stmt.executeQuery(sql);
			// 커서는 첫번째 레코드 위에 가있음...
			// 커서 내릴때 next쓰기
			// 3-1)a 여러개 레코드를 반환하는 select문
			// 3-2)a. /*while*/ 주석처리하고,밑으로
			/*
			while(rs.next()) {	//next() : 다음 읽을게 없을 때 false
				int empno = rs.getInt(1);
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				
				// 3-1)b getInt로 받아오면 null도 0으로 
				//int comm = rs.getInt(7);
				String comm = rs.getString(7)==null?"":rs.getString(7);
				
				// 3-1)c date를 string으로 받기
				//java.sql.Date hiredate = rs.getDate(5);	//1982-01-23
				String hiredate = rs.getString(5).substring(0,10);	//1982-01-23 00:00:00
				System.out.println(String.format("%-5s%-10s%-10s%-7s%s",empno,ename,job,comm,hiredate));
			} // while
			*/
			// 3-2)a. 한개의 레코드를 반환하거나 0개의 레코드를 반환하는 경우
			/*
			if(rs.next()) {
				System.out.println(String.format("%-5s%-10s%-10s%-7s%s", rs.getInt(1),rs.getString("ENAME")
						,rs.getString("JOB"), rs.getString(7)==null?"":rs.getString(7), rs.getDate(5)));
			}
			*/
			// 3-3)a.
//			rs.next();
//			System.out.println("평균 연봉:"+rs.getDouble(1));
			
			// 3-4)LIKE 연산자를 포함한  SELECT문
			/*
			  자바코드에서 like연산자 사용법
			  ※[PreparedStatement객체 사용시] - 오라클
			  
			   LIKE '%A%' :A로 시작하거나 A로끝나거나 A가 중간에 포함되거나
			   LIKE '%A' :A로 끝나는 경우
			   LIKE 'A%' :A로 시작
			  
			  -자바
			   LIKE  '%' || 'A' || '%'
			   LIKE '%' || 'A'
			   LIKE 'A' || '%'
			 
			 */
			// 3-4)b. 여러개 레코드를 반환하는 select문(==3-1)a) 또는 LIKE에 이용
			while(rs.next()) {	//next() : 다음 읽을게 없을 때 false
				int empno = rs.getInt(1);
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				
				// 3-1)b getInt로 받아오면 null도 0으로 
				//int comm = rs.getInt(7);
				String comm = rs.getString(7)==null?"":rs.getString(7);
				
				// 3-1)c date를 string으로 받기
				//java.sql.Date hiredate = rs.getDate(5);	//1982-01-23
				String hiredate = rs.getString(5).substring(0,10);	//1982-01-23 00:00:00
				System.out.println(String.format("%-5s%-10s%-10s%-7s%s",empno,ename,job,comm,hiredate));
			} // while
			
		} catch(SQLException e) {
			System.out.println("SELECT쿼리시 오류 : "+e.getMessage());
		} finally { close(); }
		
		
		
		/*
			SELECT문 실행시 실행결과는 ResultSet타입의 객체에
			저장됨. 최초 커서는 첫번째 레코드 바로 위에 가 있다.
			ResultSet객체의 next()메소드로 커서를 아래로 이동시키면서
			더 이상 꺼내올 레코드가 없을때까지 반복하면서 추출			
			
			ResultSet객체의 getXXX()계열 메소드로
			해당 레코드의 각 컬럼에 저장된 값을 읽어 온다.
			예를들면
			
		  	----------------------+------------------------------
		     ORACLE자료형           |       ResultSet
		     ---------------------+----------------------------
		     NUMBER               |     getInt(인덱스 혹은 컬럼명)   *인덱스가 빠름,1부터시작
		     ---------------------+-------------------------------
		     CHAR/NCHAR           |
		     VARCHAR2/NVARCHAR2   |     getString(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		     DATE                 |     getDate(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		 	 인덱스는 SQL에서는 1부터 시작
		     ※단,ORACLE의 자료형에 상관없이 getString(인덱스 혹은 컬러명)
		      으로 읽어와도 무방하다.			    
			
			
			 오라클에 저장된 데이타가 없는 경우 즉 null 인 경우			 *
			 rs.getInt(인덱스번호 혹은 컬럼명) 는 0 반환
			 rs.getString(인덱스번호 혹은 컬럼명)는 null 반환   <- 이거 이용하는게 안전
		*/
		
		
		
		
		
	} // void execute()
	
	
	public static void main(String[] args) throws Exception {
		new SelectSQL().execute();

	} // main

} // class SelectSQL
