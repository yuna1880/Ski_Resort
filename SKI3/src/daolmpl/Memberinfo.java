package daolmpl;

import java.util.Scanner;

import dao.MemberDAO;
import vo.MemberVO;

public class Memberinfo {

	private MemberDAO dao;

	public Memberinfo() {
		dao = new MemberDAO();
	}

	// 조회, 수정, 삭제
	public boolean search(String id) {
		boolean withdraw = false;

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 회원 정보 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		System.out.println("\t\t\t\t (1). [ 내 정보 ] ");
		System.out.println("\t\t\t\t (2). [ 회원 정보 수정 ] ");
		System.out.println("\t\t\t\t (3). [ 회원 탈퇴 ] ");
		System.out.println("\t\t\t\t (4). [ 이전으로 ] ");
		
		System.out.println(
				"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.print("\t\t\t\t [ 원하시는 메뉴를 입력하세요.(1-3) ] >> ");
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println(
					"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 내 정보 조회 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t\t    * " + id + " 님의 회원 정보입니다. *");
			MemberVO vo = dao.memberSelect(id);
			System.out.println(vo);
			break;

		case 2:

			System.out.println(
					"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 회원 정보 수정 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t\t    * " + id + " 님 변경할 회원 정보를 입력하세요. *");

			System.out.print("\t\t\t\t [ 변경할 비밀번호를 입력하세요. ] >> ");
			String pw = sc.next();

			System.out.print("\t\t\t\t [ 변경할 이름을 입력하세요. ] >> ");
			String name = sc.next();

			System.out.print("\t\t\t\t [ 변경할 전화번호를 입력하세요. ] >> ");
			String phone = sc.next();

			System.out.print("\t\t\t\t [ 변경할 이메일을 입력하세요. ] >> ");
			String email = sc.next();

			MemberVO member = new MemberVO(id, pw, name, phone, email);

			dao.memberUpdate(member);

			System.out.println("\t\t\t\t [ 회원정보 수정이 완료되었습니다. ] ");

			break;

		case 3:

			System.out.println(
					"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓  [ 회원 탈퇴 ] 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t\t  * " + id + " 님 회원 탈퇴를 진행합니다. *");
			System.out.print("\t\t\t [ 정말 탈퇴하시겠습니까 ? (1.예  2.아니오) ] >> ");
			int num = sc.nextInt();
			if (num == 1) {
				dao.memberDelete(id);
				System.out.print("\t\t\t\t [ 회원탈퇴가 완료되었습니다. ]\n");
				withdraw = true;
				break;
			} else {
				break;
			}
		
		case 4:	
			break;
		}
		return withdraw;
	}
}
