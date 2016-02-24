package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.service.AccountService;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AccountServiceImpl;
import com.bank.web.serviceImpl.AdminServiceImpl;

@Controller
public class AccountController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountService service = new AccountServiceImpl();
		AdminService service2 = new AdminServiceImpl();
		
		while (true) {
			System.out.println("업무선택 : 1. 계좌개설 2. 입금 3. 출금 4. 잔액조회 5. 종료");
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("이름, 비밀번호 :");
				System.out.println(service2.open(sc.next(), sc.nextInt()));
				break;
			case 2:
				System.out.println("입금할 금액 : ");
				System.out.println(service.deposit(sc.nextInt()));
				break;
			case 3:
				System.out.println("출금할 금액 : ");
				System.out.println(service.withdraw(sc.nextInt()));
				break;
			case 4:break;
			case 5:return;

			default:
				System.out.println("1~5번 사이에서 선택가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			}
		}
	}
}
