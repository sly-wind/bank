package com.bank.web.service;

public interface AccountService {
	// Database 에서 CRUD
	// create
	// read
	// update
	// delete
	
	/*// 1. 통장개설
	public String open(String name, int password);*/
	// 2. 입금
	public String deposit(int money);
	// 3. 출금
	public String withdraw(int money);
	// 4. 조회
	public String search();
	
}
