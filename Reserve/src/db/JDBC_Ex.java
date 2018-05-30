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
			System.out.println("�ε� ����");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "temp_a","1234");
			
			Statement stmt = conn.createStatement();
			
			// ������ �Է�
//			String insert = "insert into TB values('444', '�ƹ���', '�а�')";
			String delete = "delete from TB where id = '444'";
			stmt.executeUpdate(delete);			
			// ��� Ȯ��
//			String nm = JOptionPane.showInputDialog("�˻��� �̸��� �Է��ϼ���.");
			String sql = "select * from TB";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String id = rs.getString(1);
				String name = rs.getString("name");
				System.out.println(id + "\t" + name);
			}
					
			System.out.println("DB���� ����");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ε� ����");
		} catch(SQLException e)
		{
			System.out.println("DB ���� ����");
		}
	}

}
