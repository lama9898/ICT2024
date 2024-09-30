package jdbc25.etc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Vector;

import jdbc25.service.JDBCConnectImpl;

public class ExecuteSQL extends JDBCConnectImpl {

	public ExecuteSQL() {
		connect(ORACLE_BASE_URL+"/XEPDB1","JAVA","JAVA");
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			// 1. 쿼리문 준비
			String sql = getQueryString().trim();
			if(sql.equalsIgnoreCase("EXIT")) {
				System.out.println("종료되었습니다.");
				close();
				System.exit(0);
			}
			
			// 2. Statement 객체 생성 : 쿼리 실행용
			psmt = conn.prepareStatement(sql);
			
			// 3. 쿼리 실행 : boolean execute() : 쿼리문이 미정이기 때문
			/*
			 * execute()
			 * adfasdgagasdga
			 */
			
			try {
				boolean flag = psmt.execute();
				if(flag) {	// SELECT
					rs = psmt.getResultSet();
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					List<Integer> dashCount = new Vector<>();
					for(int i=1;i<=columnCount;i++) {
						int columnSize = rsmd.getPrecision(i);
						int columnType = rsmd.getColumnType(i);
						switch(columnType) {
							case Types.NCHAR:
							case Types.NVARCHAR:dashCount.add(20);break;
							case Types.NUMERIC:
							case Types.TIMESTAMP:dashCount.add(10);break;
							default : dashCount.add(20);					
						}
						// ◆ 2.컬럼명 출력
						
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
				else {	// INSERT / DELETE / UPDATE / CREATE / ALTER 등
					int affected = psmt.getUpdateCount();
					if(sql.toUpperCase().startsWith("UPDATE")) System.out.println(affected+"행이 수정되었습니다.");
					else if(sql.toUpperCase().startsWith("DELETE")) System.out.println(affected+"행이 삭제되었습니다.");
					else if(sql.toUpperCase().startsWith("INSERT")) System.out.println(affected+"행이 입력되었습니다.");
				}
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // void execute
	
	public static void main(String[] args) throws Exception {
		new ExecuteSQL().execute();

	}

}
