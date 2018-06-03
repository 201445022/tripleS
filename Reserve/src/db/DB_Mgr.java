package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	// 테이블 생성
	public void createTable() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			// Account 테이블이 존재하는지 유무 확인
			rs = stmt.executeQuery("SELECT count(*) AS COUNT FROM tabs WHERE TABLE_NAME = 'ACCOUNT'");
			rs.next();
			if (rs.getInt("COUNT") == 0) { // Account 테이블이 존재하지 않으면 테이블 생성
				String query = "CREATE TABLE ACCOUNT (company VARCHAR2(10), manager VARCHAR2(10),"
						+ "tel VARCHAR2(13), fax VARCHAR2(13), email VARCHAR2(30))";
				stmt.execute(query);
			}
			// OrderList 테이블이 존재하는지 유무 확인
			rs = stmt.executeQuery("SELECT count(*) AS COUNT FROM tabs WHERE TABLE_NAME = 'ORDERLIST'");
			rs.next();
			if (rs.getInt("COUNT") == 0) { // OrderList 테이블이 존재하지 않으면 테이블 생성
				String query = "CREATE TABLE Orderlist (order_Date DATE, Name VARCHAR2(10),"
						+ "Inum VARCHAR2(6), Quantity NUMBER, Delivery VERCHAR2(20))";
				stmt.execute(query);
			}
			// Item 테이블이 존재하는지 유무 확인
			rs = stmt.executeQuery("SELECT count(*) AS COUNT FROM tabs WHERE TABLE_NAME = 'ITEM'");
			rs.next();
			if (rs.getInt("COUNT") == 0) { // Item 테이블이 존재하지 않으면 테이블 생성
				String query = "CREATE TABLE Item (Num VARCHAR2(6), Name VARCHAR2(10),"
						+ "item_Size VARCHAR2(10), UnitPrice NUMBER)";
				stmt.execute(query);
			}
		} catch (Exception e) {
			System.out.println("테이블 생성 오류");
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// 거래처 검색
	public ArrayList<Bean> selectAccount() {
		ArrayList<Bean> list = new ArrayList<Bean>();
		Bean bean;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Account";
		try {
			con = conn.getConnection();
			stmt = con.createStatement(); // 이부분이문제
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				bean = new Bean();
				bean.setStrCompany(rs.getString("company"));
				bean.setStrManager(rs.getString("manager"));
				bean.setStrTel(rs.getString("tel"));
				bean.setStrFax(rs.getString("fax"));
				bean.setStrEmail(rs.getString("email"));
				list.add(bean);
			}
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("데이터못받아옴");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 거래처 등록
	public void insertAccount(String company, String manager, String tel, String fax, String email) {
		Connection con = null;
		Statement stmt = null;
		String sql = "INSERT INTO Account(company, manager, tel, fax, email) VALUES('" + company + "', '" + manager
				+ "', '" + tel + "', '" + fax + "', '" + email + "')";
		try {
			con = conn.getConnection();
			stmt = con.createStatement();

			stmt.executeUpdate(sql);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e + " : 오류발생");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 상호명과 이메일 중복 확인
	public int countCheck(String column, String name) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 1; // cnt가 1이면 중복 0 이면 중복x
		String sql = "SELECT COUNT(*) AS COUNT FROM ACCOUNT WHERE " + column + "='" + name + "'";
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("COUNT");
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
