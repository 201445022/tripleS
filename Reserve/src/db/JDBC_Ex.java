package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Ex {
	private Connection conn = null;

	public JDBC_Ex() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결 중...");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "temp","1234");
			
			System.out.println("DB연동 성공");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 연결 실패");
		} catch(SQLException e)
		{
			System.out.println("DB 연동 실패");
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public Connection getConnection(){
		return conn;
	}
}
