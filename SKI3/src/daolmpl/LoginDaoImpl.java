package daolmpl;

import java.util.Scanner;

import dao.LoginDAO;
import vo.MemberVO;

//로그인
public class LoginDaoImpl {
	Scanner sc = new Scanner(System.in);
	LoginDAO dao = new LoginDAO();
	
	public MemberVO login1() {
		
		MemberVO vo = new MemberVO();
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 로그인 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("\t\t\t    * 로그인에 필요한 정보를 입력하세요. *");
		System.out.print("\t\t\t\t [ 아이디 ] >> ");
		String id = sc.next();
		System.out.print("\t\t\t\t [ 비밀번호 ] >> ");
		String pw = sc.next();
		
		vo =  dao.selectid(id,pw);
		if(vo==null){
			System.out.println("\t\t\t\t [ 아이디나 비밀번호가 일치하지 않습니다. ]");
			
		}else{
			System.out.println();
			System.out.println("\t\t\t [ 로그인에 성공하였습니다. "+ id + " 님 환영합니다! ]");
		}
		return vo;
	}
	
	
}
	


