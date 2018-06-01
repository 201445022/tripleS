package db;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBC_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결 중...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "temp","1234");
			
			Statement stmt = conn.createStatement();
			String sql = "select * from TB";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString("name");
				System.out.println(id + "\t" + name);
			}
					
			System.out.println("DB연동 성공");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 연결 실패");
		} catch(SQLException e)
		{
			System.out.println("DB 연동 실패");
		}
	}

}
