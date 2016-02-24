package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AdminServiceImpl;

@Controller
public class AdminController {

	public static void main(String[] args) {
		
		AdminService service = new AdminServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("[업무선택]\n"
					+ "1. 통장 개설\n"
					+ "2. 전체 계좌 수 조회\n"
					+ "3. 계좌번호로 해당 계좌 정보 조회\n"
					+ "4. 이름으로 계좌 정보 조회\n"
					+ "5. 계좌 삭제\n"
					+ "6. 이름으로 계좌 수 조회\n"
					+ "9. 종료");
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("이름, 비밀번호 :");
				System.out.println(service.open(sc.next(), sc.nextInt()));
				break;
			case 2:
				System.out.println("전체 계좌 수 : " + service.countAll());						
				break;
			case 3:
				System.out.println("조회하려는 계좌번호 입력 :");
				System.out.println("조회한 계좌 : " + service.searchAccountByAccountNo(sc.nextInt()).toString());
				break;
			case 4:
				System.out.println("조회하려는 이름 입력 :");
				AccountVO[] accounts = service.searchAccountByName(sc.next());
				for (int i = 0; i < accounts.length; i++) {
					System.out.println(accounts[i]);
				}
				break;
			case 5:
				System.out.println("삭제하려는 계좌번호 입력 :");
				System.out.println(service.closeAccount(sc.nextInt()));
				break;
			case 6:break;
			case 7:break;
			case 8:break;
			case 9:return;

			default:
				System.out.println("1~9번 사이에서 선택가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			}
		}
	
		
		
		/*// 1. 전체 계좌 수 조회
		public int countAll();
		// 2. 계좌번호로 해당 계좌 정보 조회
		public String searchAccountByAccountNo(int accountNo);
		// 3. 이름으로 계좌 정보 조회
		public AccountBean[] searchAccountByName(String name);
		// 4. 계좌 삭제
		public String closeAccount(int accountNo);
		// 5. 이름으로 계좌 수 조회 (3번 기능 수행하기 위해 필요한 메소드)
		public int searchCountByName(String name);*/
	}
}
