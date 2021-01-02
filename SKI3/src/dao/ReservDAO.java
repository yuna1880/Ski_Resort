package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.ReservVO;
import vo.SnackVo;

public class ReservDAO {
	Scanner sc = new Scanner(System.in);
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "SKI";
	final String PASSWORD = "skipw";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	List<ReservVO> list = new ArrayList<>();
	

	public ReservDAO() {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int reserv_insert(ReservVO r_vo1) {
		int result = 0;
		int i = 1;
		// DB연동작업 : vo 데이터 DB에 입력
		try {
			// 2. DB연결하고 Connection 객체 생성
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL 실행을 위한 준비

			String sql = "" + "INSERT INTO RESERV "
					+ "       (RESERV_NUM, SHOE_SIZE, EQUIT, RIDE, RESERV_DATE, MEM_ID) "
					+ "VALUES (SEQ_RESERV_NUM.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(i++, r_vo1.getShoe_size());
			pstmt.setString(i++, r_vo1.getEquit());
			pstmt.setString(i++, r_vo1.getRide());
			pstmt.setString(i++, r_vo1.getDate());
			pstmt.setString(i++, r_vo1.getMem_id());

			// SQL 실행요청
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}

	public int reserv_update(ReservVO r_vo2) {
		int result = 0;

		// DB연동작업 : VO데이터로 테이블 데이터 수정처리
		try {
			// 2. DB연결하고 Connection 객체 생성
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. Statement 객체 생성해서 SQL 실행 요청
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE RESERV ");
			sb.append("SET SHOE_SIZE = ? ");
			sb.append(", EQUIT = ? ");
			sb.append(", RIDE = ? ");
			sb.append(", RESERV_DATE = ? ");
			sb.append("WHERE RESERV_NUM = ? ");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, r_vo2.getShoe_size());
			pstmt.setString(2, r_vo2.getEquit());
			pstmt.setString(3, r_vo2.getRide());
			pstmt.setString(4, r_vo2.getDate());
			pstmt.setInt(5, r_vo2.getReserv_num());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}
	
	public int reserv_delete(String De_id, int reserv_num2) {
	int result = 0;
		
		//DB연동작업 : id 값으로 데이터 삭제
		try {
			//2. DB연결하고 Connection 객체 생성
			conn = DriverManager.getConnection(URL,	USER, PASSWORD);
			
			//3. Statement 객체 생성해서 SQL 실행 요청
			String sql = "DELETE FROM RESERV WHERE RESERV_NUM = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserv_num2);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		return result;
	}
	
	public ArrayList<ReservVO> reserv_select(String Se_id) throws ClassNotFoundException, SQLException {
			ReservVO reservo = null;
		
			String sql = ""
					+ "SELECT * FROM RESERV "
					+ " WHERE MEM_ID = ? "
					+ " ORDER BY RESERV_NUM ";
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, Se_id);
			
			//3-3. SQL문장 실행요청
			ResultSet rs = st.executeQuery();
			ArrayList<ReservVO> list = new ArrayList<>();
			
			//4. SQL 실행결과에 대한 처리
			while (rs.next() ) {
				reservo = new ReservVO();
				reservo.setReserv_num(rs.getInt("RESERV_NUM"));
				reservo.setShoe_size(rs.getString("SHOE_SIZE"));
				reservo.setEquit(rs.getString("EQUIT"));
				reservo.setRide(rs.getString("RIDE"));
				reservo.setDate(rs.getString("RESERV_DATE"));
				list.add(reservo);
			}
		
		return list;
	}

	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
