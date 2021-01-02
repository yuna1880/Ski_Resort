package daolmpl;

import java.util.Scanner;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberDaoImpl {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();

	public MemberDaoImpl() {
		
			System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 회원가입 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t\t    * 회원가입에 필요한 정보를 입력하세요. *");
		
			System.out.print("\t\t\t\t [ 아이디를 입력하세요 ] >> ");
			String id = sc.next();
			
			System.out.print("\t\t\t\t [ 비밀번호를 입력하세요 ] >> ");
			String pw = sc.next();
					
			System.out.print("\t\t\t\t [ 이름을 입력하세요 ] >> ");
			String name = sc.next();
			
			System.out.print("\t\t\t\t [ 전화번호를 입력하세요 ] >> ");
			String phone = sc.next();
			
			System.out.print("\t\t\t\t [ 이메일을 입력하세요 ] >> ");
			String email = sc.next();
			
			MemberVO member = new MemberVO(id, pw, name, phone, email);		
			
			dao.memberInsert(member);
			
			System.out.println("\t\t\t[ " +name+ " 님 회원가입이 완료되었습니다. 환영합니다! ] ");

	}

}