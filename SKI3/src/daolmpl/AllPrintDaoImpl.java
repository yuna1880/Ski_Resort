package daolmpl;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AllPrintDAO;
import vo.AllprintVO;


public class AllPrintDaoImpl {
   Scanner sc = new Scanner(System.in);
   AllPrintDAO dao = new AllPrintDAO();
   ArrayList<AllprintVO> vo = null;
   
   public AllPrintDaoImpl() {
      vo = dao.selectAll();
      ArrayList<AllprintVO> list = dao.selectAll();
      
      System.out.println("아이디 \t\t│이름 \t│전화번호 \t\t│이메일\t\t\t│주문번호 \t│신발사이즈\t\t│보호장비 \t│스키종류\t│예약 날짜\t\t\t│주문번호\t│음료\t│스낵\t│라면");
      System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
      for (AllprintVO vo : list) {
    	  System.out.println(vo);
		
	}
   }
      
      
   
}