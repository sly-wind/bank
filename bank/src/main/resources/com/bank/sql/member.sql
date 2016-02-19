SELECT * FROM test;

	private String ;
	private String ;
	private String ;
	private String ;
	private int ;
	
CREATE table member (
	userid VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30),
	password VARCHAR2(30),
	addr VARCHAR2(30),
	birth NUMBER
);

SELECT * from member;

INSERT INTO member(userid, name, password, addr, birth)
VALUES ('lee', '이주녁', '1', '서울', 2000);

INSERT INTO member(userid, name, password, addr, birth)
VALUES ('kwon', '권해리', '1', '서울', 2000);

INSERT INTO member(userid, name, password, addr, birth)
VALUES ('jang', '장미노', '1', '서울', 2000);