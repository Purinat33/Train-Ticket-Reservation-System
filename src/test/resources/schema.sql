CREATE SCHEMA IF NOT EXISTS RESERVATION;

CREATE TABLE RESERVATION.CUSTOMER 
(	
    MAILID VARCHAR(40) PRIMARY KEY, 
    PWORD VARCHAR(20) NOT NULL, 
    FNAME VARCHAR(20) NOT NULL, 
    LNAME VARCHAR(20), 
    ADDR VARCHAR(100), 
    PHNO NUMBER(12) NOT NULL
);

CREATE TABLE RESERVATION.ADMIN 
(	
    MAILID VARCHAR(40) PRIMARY KEY, 
    PWORD VARCHAR(20) NOT NULL, 
    FNAME VARCHAR(20) NOT NULL, 
    LNAME VARCHAR(20), 
    ADDR VARCHAR(100), 
    PHNO NUMBER(12) NOT NULL
);

CREATE TABLE RESERVATION.TRAIN 
(	
    TR_NO NUMBER(10) PRIMARY KEY, 
    TR_NAME VARCHAR(70) NOT NULL, 
    FROM_STN VARCHAR(20) NOT NULL, 
    TO_STN VARCHAR(20) NOT NULL, 
    SEATS NUMBER(4) NOT NULL, 
    FARE NUMBER(6,2) NOT NULL 
);

CREATE TABLE RESERVATION.HISTORY 
(	
    TRANSID VARCHAR(36) PRIMARY KEY, 
    MAILID VARCHAR(40) REFERENCES RESERVATION.CUSTOMER(MAILID), 
    TR_NO NUMBER(10), 
    DATE DATE, 
    FROM_STN VARCHAR(20) NOT NULL, 
    TO_STN VARCHAR(20) NOT NULL, 
    SEATS NUMBER(3) NOT NULL, 
    AMOUNT NUMBER(8,2) NOT NULL
);
