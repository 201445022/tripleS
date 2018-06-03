package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * sql 쿼리문 작성
 * */
public class DB_Mgr {
	JDBC_Ex conn;

	public DB_Mgr() {
		conn = new JDBC_Ex();
	}

	public ArrayList<Bean> selectAccount() { // 거래처 검색
		ArrayList<Bean> list = new ArrayList<Bean>();
		Bean bean;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select Name, Manager, Phone, Fax, Email FROM account";
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				bean = new Bean();
				bean.setStrCompany(rs.getString(1));
				bean.setStrManager(rs.getString(2));
				bean.setStrTel(rs.getString(3));
				bean.setStrFax(rs.getString(4));
				bean.setStrEmail(rs.getString(5));
				list.add(bean);
			}
		} catch (Exception e) {
		}
		return list;
	}

	// 거래처 등록
	public void InsertAccount(String name, String mang, String phone, String fax, String email) {
		Connection con = null;
		Statement stmt = null;
		String sql = "insert into account(company, manager, tel, fax, email) values('" + name + "', '" + mang + "', '"
				+ phone + "', '" + fax + "', '" + email + "');";
		try {
			con = conn.getConnection();
			stmt = con.createStatement();

			sql = "CREATE TABLE item ( " + "No NUMBER PRIMARY KEY," + "Num VARCHAR2(6)," + "Name VARCHAR2(10),"
					+ "item_Size VARCHAR2(10)," + "UnitPrice NUMBER)";

			stmt.executeUpdate(sql);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e + " : 오류발생");
		}
	}
}
