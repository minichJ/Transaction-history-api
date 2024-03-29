-- 거래내역 테이블
DROP TABLE IF EXISTS TRSC_HIST;

CREATE TABLE TRSC_HIST (
	TRSC_DT VARCHAR(8),
	ACCT_NO INT REFERENCES TRSC_HIST(ACCT_NO),
	TRSC_NO INT,
	TRSC_AMT INT, 
	TRSC_FEE INT,
	CANCEL_YN CHAR(1),
	PRIMARY KEY (TRSC_DT, ACCT_NO, TRSC_NO)
) AS
SELECT *
  FROM CSVREAD('classpath:/sqlmap/data/data_transaction_history.csv');


-- 관리점 정보 테이블
DROP TABLE IF EXISTS BR_INFO;

CREATE TABLE BR_INFO (
	BR_CODE CHAR(1) PRIMARY KEY,
	BR_NAME VARCHAR(500)
) AS
SELECT *
  FROM CSVREAD('classpath:/sqlmap/data/data_branch_information.csv');


-- 계좌정보 테이블
DROP TABLE IF EXISTS ACCT_INFO;

CREATE TABLE ACCT_INFO (
	ACCT_NO INT,
	ACCT_NM VARCHAR(100),
	BR_CODE CHAR(1) REFERENCES BR_INFO(BR_CODE),
	PRIMARY KEY (ACCT_NO, BR_CODE)	
) AS
SELECT *
  FROM CSVREAD('classpath:/sqlmap/data/data_account_information.csv');