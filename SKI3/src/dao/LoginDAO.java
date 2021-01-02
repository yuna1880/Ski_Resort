package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;
import vo.ReservVO;

public class LoginDAO {
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "SKI";
	final String PASSWORD = "skipw";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public LoginDAO() {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO selectid(String id, String pw) {
		MemberVO membervo = null;
		//DB연동작업(SELECT)
		try {
			//2. DB연결하고 Connection 객체 생성
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			//3. SQL 실행을 위한 준비
			String sql = ""
					+ "SELECT ID, PW, NAME, PHONE,EMAIL "
					+ "  FROM MEMBER "
					+ " WHERE ID = ? AND PW = ? ";
			
			//3-1. SQL을 전달하고 실행준비 요청
			pstmt = conn.prepareStatement(sql);
			//3-2. SQL문장의 ? 위치에 값 설정
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//3-3. SQL문장 실행요청
			rs = pstmt.executeQuery();
			
			//4. SQL 실행결과에 대한 처리
			if (rs.next() ) {
				membervo = new MemberVO();
				membervo.setId(rs.getString("ID"));
				membervo.setPw(rs.getString("PW"));
				membervo.setName(rs.getString("NAME"));
				membervo.setPhone(rs.getString("PHONE"));
				membervo.setEmail(rs.getString("EMAIL"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return membervo;
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

