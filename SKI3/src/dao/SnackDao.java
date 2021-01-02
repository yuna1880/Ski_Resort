package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ReservVO;
import vo.SnackVo;

public class SnackDao {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "SKI";
	private String upw = "skipw";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public int insertData(SnackVo vo) throws ClassNotFoundException, SQLException {
		
		String beverage = vo.getBeverage();
		String snack = vo.getSnack();
		String ramen = vo.getRamen();
		String memId = vo.getMem_id();
		
		String sql = "INSERT INTO SNACK("
				+ "    BEVERAGE,"
				+ "    SNACK,"
				+ "    RAMEN,"
				+ "    MEM_ID"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, beverage);
		st.setString(2, snack);
		st.setString(3, ramen);
		st.setString(4, memId);
		
		int result = st.executeUpdate();
		
		System.out.println("\t\t\t\t [ " + memId + " 님 주문예약이 완료되었습니다. ]");
		
		st.close();
		con.close();
		return result;
	}

	public ArrayList<SnackVo> selectData(String id) throws ClassNotFoundException, SQLException {
		
		SnackVo vo = null;
		
		String sql = "SELECT * FROM SNACK WHERE MEM_ID = ? ORDER BY ORDER_NUM " ;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		ArrayList<SnackVo> list = new ArrayList<>();
		
		while(rs.next()) { // 가져올 값이 있으면 출력 !
			vo = new SnackVo();
			vo.setOrderNum(rs.getInt("ORDER_NUM"));
			vo.setBeverage(rs.getString("BEVERAGE"));
			vo.setSnack(rs.getString("SNACK"));
			vo.setRamen(rs.getString("RAMEN"));
			vo.setMem_id(rs.getString("MEM_ID"));
			list.add(vo);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public int updateData(SnackVo vo1) throws ClassNotFoundException, SQLException {
		
		String beverage = vo1.getBeverage();
		String snack = vo1.getSnack();
		String ramen = vo1.getRamen();
		String memId = vo1.getMem_id();
		int orderNum = vo1.getOrderNum();
		
		String sql = "UPDATE SNACK " 
				+ "SET BEVERAGE = ? , " 
				+ "    SNACK = ? , " 
				+ "    RAMEN = ? " 
				+ "WHERE ORDER_NUM = ? ";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, beverage);
		st.setString(2, snack);
		st.setString(3, ramen);
		st.setInt(4, orderNum);
		
		int result = st.executeUpdate();
		
		System.out.println("\t\t[ " + memId + " 님의 주문번호 "+ orderNum +" 번 주문변경이 완료되었습니다. ]");
		
		st.close();
		con.close();
		
		return result;
	}

	public int deleteData(int orderNum) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM SNACK WHERE ORDER_NUM = ? " ;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,upw);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, orderNum);
		
		int result = st.executeUpdate();
		
		System.out.println("\t\t\t[ 예약번호 " + orderNum +" 번 주문이 취소되었습니다. ]");
		
		st.close();
		con.close();
		
		return result;
	}

}
