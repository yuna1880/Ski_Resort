package daolmpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ReservDAO;
import dao.SnackDao;
import main.MainClass;
import vo.ReservVO;
import vo.SnackVo;

public class ReservDaoImpl2 {

	private ReservDAO dao;
	
	public ReservDaoImpl2() {
		dao = new ReservDAO();
		
	}
	//메뉴
	public void ReservMenu(String id) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓 ☏ 스키장 예약 ☏   〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("\t\t\t    스키장 및 대여물품을 미리 예약하세요");
		System.out.println(
				"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t\t\t (1). [ 물품대여 신청 ]");
		System.out.println("\t\t\t\t (2). [ 대여목록 변경 ]");
		System.out.println("\t\t\t\t (3). [ 대여목록 삭제 ]");
		System.out.println("\t\t\t\t (4). [ 대여목록 조회 ]");
		System.out.println("\t\t\t\t (5). [ 이전으로 ]");
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t\t\t [ 원하시는 메뉴를 선택하세요.(1-4) ] ");
		System.out.print("\t\t\t\t >>");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: //물품대여
			Reserve(id);
			break;
		case 2: //물품대여 변경
			ReserveUpdate(id);
			break;
		case 3: //물품대여 취소
			ReserveDelete(id);
			break;
		case 4: //물품대여 조회
			ReserveSelect(id);
			break;
		case 5: //이전 메뉴로 이동
			break;
		case 6: //종료
			System.out.println("\t\t\t\t[ 물품 대여를 종료합니다. 감사합니다. ]");
			System.exit(0);
			break;
		default :
			System.out.println("\t\t\t[ ※ 메뉴는 1~6사이의 숫자만 입력 가능합니다. 다시 입력해주세요. ※ ]");
			break;
			}
		}
	
	// 물품대여
	private void Reserve(String id) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		
		System.out.println("\t\t\t\t (1). [ 대여하실 신발사이즈를 입력하세요. ] ");
		System.out.print("\t\t\t\t >>");
		String shoe_size = sc.next();
		System.out.println("\t\t\t\t (2). [ 대여하실 보호장비를 입력하세요. (헬멧 or 장갑) ] ");
		System.out.print("\t\t\t\t >>");
		String equit = sc.next();
		System.out.println("\t\t\t\t (3). [ 대여하실 스키종류를 입력하세요. (보드 or 스키) ] ");
		System.out.print("\t\t\t\t >>");
		String ride = sc.next();
		System.out.println("\t\t\t\t (4). [ 대여하실 날짜를 입력하세요 ] ");
		System.out.print("\t\t\t\t >>");
		String date = sc.next();
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		ReservVO r_vo1 = new ReservVO(shoe_size, equit, ride, date, id);
		System.out.println("\t\t\t\t 예약신청이 완료되었습니다.");

		dao.reserv_insert(r_vo1);
	}

	//물품대여 조회 
	public void ReserveSelect(String id) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		List<ReservVO> r_vo3 = dao.reserv_select(id);
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ ★" + id + " 님의 스키장 예약 내역 ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t주문번호 \t│신발사이즈\t\t│보호장비 \t│스키종류\t│예약 날짜 ");
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		for (ReservVO vo : r_vo3) {
			System.out.println(vo);
		}

	}

	//물품대여 변경
	private void ReserveUpdate(String id) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		ReserveSelect(id);
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");

		System.out.println("\t\t\t\t [ 변경을 원하는 주문번호를 선택해 주세요. ] ");
		System.out.print("\t\t\t\t >>");
		int reserv_num = sc.nextInt();
		System.out.println("\t\t\t\t [ " + id + "님의 " + reserv_num + "번 주문을 변경합니다. ]");
		System.out.println("\t\t\t\t (1). [ 변경하실 신발사이즈를 입력하세요. ] ");
		System.out.print("\t\t\t\t >>");
		String Up_shoe_size = sc.next();
		System.out.println("\t\t\t\t (2). [ 변경하실 보호장비를 입력하세요. (헬멧 or 장갑) ]");
		System.out.print("\t\t\t\t >>");
		String Up_equit = sc.next();
		System.out.println("\t\t\t\t (3). [ 변경하실 스키종류를 입력하세요. (보드 or 스키) ]");
		System.out.print("\t\t\t\t >>");
		String Up_ride = sc.next();
		System.out.println("\t\t\t\t (4). [ 변경하실 날짜를 입력하세요 ] ");
		System.out.print("\t\t\t\t >>");
		String Up_date = sc.next();
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t\t\t [ " + id + "님의 " + reserv_num + "번 주문이 변경되었습니다. ]");

		ReservVO r_vo2 = new ReservVO(Up_shoe_size, Up_equit, Up_ride, Up_date, id, reserv_num);
		dao.reserv_update(r_vo2);
		
	}
	//물품대여 취소
	private void ReserveDelete(String id) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ ★" + id + " 님의 스키장 예약 내역 ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t주문번호 \t│신발사이즈\t\t│보호장비 \t│스키종류\t│예약 날짜 ");
		System.out.println(
				"⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		ReserveSelect(id);
		
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t\t\t [ (1). 삭제하실 주문번호를 입력해 주세요. ]");
		System.out.print("\t\t\t\t >>");
		int reserv_num2 = sc.nextInt();
		System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
		System.out.println("\t\t\t\t [ " + reserv_num2 + "번의 주문이 삭제되었습니다. ]");

		dao.reserv_delete(id, reserv_num2);
	}
}
