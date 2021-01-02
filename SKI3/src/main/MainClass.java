package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.MemberDAO;
import daolmpl.LoginDaoImpl;
import daolmpl.MemberDaoImpl;
import daolmpl.Memberinfo;
import daolmpl.ReservDaoImpl2;
import daolmpl.SnackDaoImpl;
import vo.MemberVO;
import vo.ReservVO;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		SnackDaoImpl Sn_dao = new SnackDaoImpl();
		LoginDaoImpl log = new LoginDaoImpl();
		Memberinfo info = new Memberinfo();
		ReservDaoImpl2 reserv = new ReservDaoImpl2();

		MemberVO id = null;

		System.out.println("  _______  _       _________   _______  _______  _______  _______  _______ _________");
		System.out
				.println(" (  ____ \\| \\    /\\\\__   __/  (  ____ )(  ____ \\(  ____ \\(  ___  )(  ____ )\\__   __/");
		System.out.println(" | (    \\/|  \\  / /   ) (     | (    )|| (    \\/| (    \\/| (   ) || (    )|   ) (  ");
		System.out.println(" | (_____ |  (_/ /    | |     | (____)|| (__    | (_____ | |   | || (____)|   | |  ");
		System.out.println(" (_____  )|   _ (     | |     |     __)|  __)   (_____  )| |   | ||     __)   | | ");
		System.out.println("       ) ||  ( \\ \\    | |     | (\\ (   | (            ) || |   | || (\\ (      | | ");
		System.out
				.println(" /\\____) ||  /  \\ \\___) (___  | ) \\ \\__| (____/\\/\\____) || (___) || ) \\ \\__   | | ");
		System.out
				.println(" \\_______)|_/    \\/\\_______/  |/   \\__/(_______/\\_______)(_______)|/   \\__/   )_(   ");

		while (true) {
			System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ 스키장 예약 시스템 ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
			System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("\t\t\t\t (1). [ 회원가입 ] ");
			System.out.println("\t\t\t\t (2). [ 로그인 ] ");
			System.out.println("\t\t\t\t (3). [ 회원정보 ] ");
			System.out.println("\t\t\t\t (4). [ 스키장예약  ]");
			System.out.println("\t\t\t\t (5). [ 간식 주문  ]");
			System.out.println("\t\t\t\t (6). [ 주문서 출력 ]");
			System.out.println("\t\t\t\t (7). [ 종료 ]");
			System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
			System.out.println("\t\t\t\t [ 원하시는 메뉴를 입력하세요.(1-7) ] ");
			System.out.print("\t\t\t\t >>");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: // 회원가입
				new MemberDaoImpl();
				break;

			case 2: // 로그인
				id = log.login1();
				break;

			case 3: // 회원정보 조회
				if (id == null) {
					System.out.println("\t\t\t\t [ 로그인이 필요한 서비스입니다. ] ");
					continue;
				}
				if (info.search(id.getId())) {
					id = null;
				}
				break;

			case 4: //스키장 예약

				if (id == null) {
					System.out.println("\t\t\t\t [ 로그인이 필요한 서비스입니다. ] ");
					continue;
				}
				reserv.ReservMenu(id.getId());
				break;

			case 5: // 간식 주문
				if (id == null) {
					System.out.println("\t\t\t\t [ 로그인이 필요한 서비스입니다. ] ");
					continue;
				}
				Sn_dao.inputMenu(id.getId());
				break;

			case 6: //주문서 출력
				if (id == null) {
					System.out.println("\t\t\t\t [ 로그인이 필요한 서비스입니다. ] ");
					continue;
				}
				reserv.ReserveSelect(id.getId());
				Sn_dao.selectSnack(id.getId());
				break;

			case 7:
				System.out.println("\t\t\t\t  [ 프로그램을 종료합니다. ]");
				System.exit(0);
				break;

			default:
				System.out.println("\t\t\t[ ※ 메뉴는 1~7 사이의 숫자만 입력 가능합니다. 다시 입력해주세요. ※ ]");
				break;
			}
		}
	}
}