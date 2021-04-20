
CREATE DATABASE DUAN1
GO
USE DUAN1
GO
IF OBJECT_ID ('STUDENTS') IS NOT NULL
DROP TABLE STUDENTS
GO
CREATE TABLE STUDENTS 
(
SVID VARCHAR(10) NOT NULL,
NAMES NVARCHAR(50) NULL,
CONSTRAINT PK_STUDENTS PRIMARY KEY(SVID)
)
IF OBJECT_ID ('USERS') IS NOT NULL
DROP TABLE USERS
GO
CREATE TABLE USERS
(
USERID VARCHAR(10) NOT NULL,
PASS VARCHAR(10) NOT NULL,
Names Nvarchar(50)
CONSTRAINT PK_USERS PRIMARY KEY (USERID)
) 
IF OBJECT_ID ('CLASSES') IS NOT NULL
DROP TABLE CLASSES 
GO 
CREATE TABLE CLASSES
(
CLASSID VARCHAR(10) NOT NULL,
NAMECLASS NVARCHAR(10) NULL,
USERID VARCHAR(10) NOT NULL,
TIMES varchar(30) NULL,
KIHOC varchar(15),
CONSTRAINT PK_LOP PRIMARY KEY(CLASSID),
CONSTRAINT PK_USERS_CLASS FOREIGN KEY (USERID) REFERENCES USERS(USERID),
)

IF OBJECT_ID ('CATHI') IS NOT NULL
DROP TABLE STCL 
GO
create table CATHi(
	maca int primary key,
	Thoigian varchar(20)
)

IF OBJECT_ID ('SVCL') IS NOT NULL
DROP TABLE STCL 
GO
CREATE TABLE STCL
(
SVID VARCHAR(10) NOT NULL,
CLASSID VARCHAR(10) NOT NULL,
trangthai nvarchar(50),
ngaythi date,
macathi int
CONSTRAINT PK_STUDENTS_STCL FOREIGN KEY (SVID) REFERENCES STUDENTS(SVID),
CONSTRAINT PK_CLASS_STCL FOREIGN KEY (CLASSID) REFERENCES CLASSES(CLASSID),
CONSTRAINT PK_CLASS_CATHI FOREIGN KEY (macathi) REFERENCES CATHI(MACA)
)
/*insert user*/
insert USERS values('duytn','1','Nguyen Duc Duy')
	--insert cathi
insert CATHi values(1,'07:15 - 09:15')
insert CATHi values(2,'09:25 - 11:25')
insert CATHi values(3,'12:00 - 14:00')
insert CATHi values(4,'14:10 - 16:10')
insert CATHi values(5,'16:20 - 18:20')
insert CATHi values(6,'18:30 - 20:30')