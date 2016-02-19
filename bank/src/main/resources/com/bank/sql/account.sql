	private int accountNo;
	private String name;
	private int money;
	private int password;
	
	
	CREATE TABLE account(
		seq NUMBER PRIMARY KEY,
		accountNo NUMBER,
		money NUMBER,
		password NUMBER,
		userid VARCHAR2(30),
		CONSTRAINT account_member_fk
		FOREIGN KEY (userid)
		REFERENCES member(userid)
	);
	
	CREATE SEQUENCE seq
	INCREMENT BY 1
	START WITH 1;
	
	INSERT INTO account(seq, accountNo, money, password, userid) VALUES(
		seq.NEXTVAL, 1000, 10000, 1, 'kwon'
	);
	
	INSERT INTO account VALUES(
		seq.NEXTVAL, 1001, 10000, 1, 'lee'
	);
	
	INSERT INTO account VALUES(
		seq.NEXTVAL, 1002, 10000, 1, 'jang'
	);
	
	
	