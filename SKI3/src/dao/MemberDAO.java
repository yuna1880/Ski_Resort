package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;



public class MemberDAO {
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "SKI";
	final String PASSWORD = "skipw";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int memberInsert(MemberVO member) {
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = ""
						+ "INSERT INTO MEMBER"
						+ "   (ID, PW, NAME, PHONE, EMAIL)"
						+ " VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}
	public int memberUpdate(MemberVO member) {
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE MEMBER ");
			sb.append("    SET PW = ?");
			sb.append("    , NAME = ?");
			sb.append("    , PHONE = ?");
			sb.append("    , EMAIL = ?");
			sb.append(" WHERE ID = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		
		return result;
	}
	public void memberDelete(String id) {
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
	}
	public MemberVO memberSelect(String id) {
		MemberVO member = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = ""
						+ "SELECT ID, PW, NAME, PHONE, EMAIL"
						+ "  FROM MEMBER"
						+ " WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				member = new MemberVO();
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
		return member;
	}
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null)pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	private void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		try {
			if (rs != null)pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (pstmt != null)pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}





