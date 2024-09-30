package jdbc25.service;

public interface JDBCConnect {
	//상수 정의
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_BASE_URL = "jdbc:oracle:thin:@localhost:1521";
	
	//추상 메서드
	void connect(String url, String user, String password);
	void execute() throws Exception;
	void close();
	String getValue(String msg);
	String getQueryString();
	
}
