package jdbc25.etc;

import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.List;
import java.util.Vector;

import jdbc25.service.JDBCConnectImpl;

public class ResultSetMetaDataSQL extends JDBCConnectImpl {
	
	public ResultSetMetaDataSQL() {
		connect(ORACLE_BASE_URL+"/XEPDB1","SCOTT","scott");
	}
	
	@Override
	public void execute() throws Exception {
		try {
			// jdbc.service 의 getQueryString 이용
			// 1. 쿼리문 준비
			String sql = getQueryString();
			//System.out.println(sql);
			
			// 2. PreparedStatement 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 3. 쿼리 실행
			rs = psmt.executeQuery();	// 끝에 ;(세미콜론) 입력후 실행시 에러 생김
			
			
			// ■ a. ResultSet 객체의 getMetaData()로 ResultSetMetaData얻기
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// ■ b. 총 컬럼수 얻기 : int getColumnCount()
			int columnCount = rsmd.getColumnCount();
			System.out.println("총 컬럼수 : "+columnCount);
			
			// ■ c. 컬럼명 얻기 : String getColumnName(int column)
			for(int i=1;i<=columnCount;i++) {
				String columnName = rsmd.getColumnName(i);
				int length = columnName.length()+2;
				System.out.print(String.format("%-"+length+"s", columnName));
			}
			// ■ d. 컬럼타입 얻기 : int getColumnType(int column)
			//	타입과 관련된 상수는 java.sql.Types 클래스에 정의됨
			System.out.println("\r\n 자바(Type 클래스)의 컬럼타입으로 얻기");
			for(int i=1;i<=columnCount;i++) {
				int columnType = rsmd.getColumnType(i);
				switch(columnType) {
				case Types.VARCHAR:
					System.out.println("오라클의 VARCHAR2");break;
				case Types.NVARCHAR:
					System.out.println("오라클의 NVARCHAR2");break;
				case Types.CHAR:
					System.out.println("오라클의 CHAR");break;
				case Types.NCHAR:
					System.out.println("오라클의 NCHAR");break;
				case Types.NUMERIC:
					System.out.println("오라클의 NUMBER");break;
				case Types.TIMESTAMP:
					System.out.println("오라클의 DATE");break;
				default:
					System.out.println("오라클의 기타자료형");break;
				}
			
			} // for
			
			System.out.println("오라클의 실제 컬럼타입으로 얻기");
			// ■ e. String getColumnTypeName(int column)
			for(int i=1;i<=columnCount;i++) {
				String columnTypeName = rsmd.getColumnTypeName(i);
				System.out.println(columnTypeName);
			}	//for
			
			// ■ f. 컬럼의 null 허용여부 : int isNullable(int column)
			// 	null 허용 : 1, not null :0
			System.out.println("<< 컬럼의 null 허용 여부 >>");
			for(int i=1;i<=columnCount;i++) {
				int isNull = rsmd.isNullable(i);
				System.out.println(isNull==1?"nullable":"not null");
				
			}	// for
			
			// ■ g. 컬럼의 크기 얻기 : getPrecision(int column)
			//	괄호가 없는 자료형은 0 반환(지정크기)
			System.out.println("<< 컬럼의 크기 얻기 >>");
			for(int i=1;i<=columnCount;i++) {
				int columnSize = rsmd.getPrecision(i);
				System.out.print (columnSize);
			}	
			
			System.out.println("===============================================");
			
			// 각 컬럼의 자리수 설정하기
			/* ◆◆◆◆◆◆◆◆
			 * Oracle처럼
			 * 		Number 타입(자리수 지정안한 Number포함)은 10자리
			 * 		Date 타입은 10자리(원래 오라클은 8자리)
			 * 		Char 계열(Varchar2포함)은 해당 자리수로 설정
			 * 		단 nchar 계열은 자리수의 2배로 설정
			 * 		오라클처럼 컬럼명 밑에 -----------을 표시하기 위한 작업
			 */
			// ◆ 1.컬렉션 생성
			List<Integer> dashCount = new Vector<Integer>();
			for(int i=1;i<=columnCount;i++) {
				int columnSize = rsmd.getPrecision(i);
				int columnType = rsmd.getColumnType(i);
				switch(columnType) {
					case Types.NCHAR:
					case Types.NVARCHAR:dashCount.add(columnSize*2);break;
					case Types.NUMERIC:
					case Types.TIMESTAMP:dashCount.add(10);break;
					default : dashCount.add(columnSize);					
				}
				// ◆ 2.컬럼명 출력
				// : 컬럼명의 길이가 대쉬의 숫자(자료형 크기)보다 크다면
				/*
				 * akfjakdfjadfjlkdfjal 
				 */
				
				String columnName = rsmd.getColumnName(i).length()>dashCount.get(i-1) 
						? rsmd.getColumnName(i).substring(0,dashCount.get(i-1)) : rsmd.getColumnName(i);
				System.out.print(String.format("%-"+(dashCount.get(i-1)+1)+"s", columnName));
				
			} //for
			System.err.println();// ◆ 3. 줄바꿈 후 --------출력
			for(Integer count:dashCount) {
				for(int i=0;i<count;i++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
			System.out.println();
			
			// ◆ 4. 데이터 출력
			while(rs.next()) {
				// 각 컬럼값 뽑아오기
				for(int i=1;i<=columnCount;i++) {
					int columnType = rsmd.getColumnType(i);
					String columnValue;
					if(columnType==Types.TIMESTAMP) columnValue = rs.getDate(i).toString();
					else columnValue = rs.getString(i);
					System.out.print(String.format("%-"+(dashCount.get(i-1)+1)+"s", columnValue==null?"":columnValue));
				}
				System.out.println();
			}
			
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ResultSetMetaDataSQL().execute();
	}	//main
}	//class
