package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.AllprintVO;
import vo.MemberVO;

public class AllPrintDAO {
   final String DRIVER = "oracle.jdbc.OracleDriver";
   final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   final String USER = "SKI";
   final String PASSWORD = "skipw"; 
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   public AllPrintDAO() {
      try {
         //1. JDBC 드라이버 로딩
         Class.forName(DRIVER);
         conn = DriverManager.getConnection(URL,   USER, PASSWORD);
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }
   
   public ArrayList<AllprintVO> selectAll(){
      ArrayList<AllprintVO> list = null;
      
      try {
         conn = DriverManager.getConnection(URL,   USER, PASSWORD);
         
         //3. SQL 실행을 위한 준비
         String sql = ""
               + "SELECT M.ID, M.NAME, M.PHONE, M.EMAIL, R.RESERV_NUM, R.SHOE_SIZE, R.EQUIT, R.RIDE, R.RESERV_DATE, S.ORDER_NUM, S.BEVERAGE, S.SNACK, S.RAMEN "
               + "  FROM MEMBER M, RESERV R, SNACK S "
               + "  WHERE M.ID = R.MEM_ID "
               + "  AND M.ID = S.MEM_ID "
               + "  ORDER BY R.RESERV_NUM ";
         
         //3-1. DB에 SQL문 전달하고 실행준비
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         list = new ArrayList<AllprintVO>();
         //4. 결과값에 대한 처리
         while(rs.next()) {
        	 
        	
            AllprintVO allprint = new AllprintVO(
                  rs.getString("ID"),
                  rs.getString("NAME"),
                  rs.getString("PHONE"),
                  rs.getString("EMAIL"),
                  rs.getInt("RESERV_NUM"),
                  rs.getString("SHOE_SIZE"),
                  rs.getString("EQUIT"),
                  rs.getString("RIDE"),
                  rs.getString("RESERV_DATE"),
                  rs.getInt("ORDER_NUM"),
                  rs.getString("BEVERAGE"),
                  rs.getString("SNACK"),
                  rs.getString("RAMEN")
                  );
            
            list.add(allprint);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(conn, pstmt, rs);
      }   
      
      return list;
   }
   
   
   private void close(Connection conn, PreparedStatement pstmt,
         ResultSet rs) {
      try {
         if (rs != null) rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (pstmt != null) pstmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (conn != null) conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   

   
   
   
}