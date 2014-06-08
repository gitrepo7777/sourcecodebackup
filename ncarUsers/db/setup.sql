Create database NCAR_USERS;
USE NCAR_USERS;

DROP TABLE USER;
CREATE TABLE USER(
	ID int PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(50),
	PASSWORD VARCHAR(50), 
	EMAIL VARCHAR(50),
	FIRST_NAME VARCHAR(50), 
	LAST_NAME VARCHAR(50),
	LAB int,
	DIVISION int);

DROP TABLE LAB;
CREATE TABLE LAB (
	ID int,
	SHORT_NAME VARCHAR(10),
	NAME VARCHAR(100),
	DESCRIPTION VARCHAR(500)
	);
INSERT INTO LAB VALUES (1,'CISL','Computational and Information Systems Laboratory','Computational and Information Systems Laboratory');
INSERT INTO LAB VALUES (2,'ESSL','Earth and Sun Systems Laboratory','Earth and Sun Systems Laboratory');
INSERT INTO LAB VALUES (3,'EOL','Earth Observing Laboratory','Earth Observing Laboratory');
INSERT INTO LAB VALUES (4,'RAL','Research Applications Laboratory','Research Applications Laboratory');

DROP TABLE DIVISION;
CREATE TABLE DIVISION (
	ID int,
	SHORT_NAME VARCHAR(10),
	NAME VARCHAR(100),
	DESCRIPTION VARCHAR(500),
	LAB_ID int
	);
INSERT INTO DIVISION VALUES (1,'IMAGe','Institute for Mathematics Applied to Geosciences','Institute for Mathematics Applied to Geosciences', 1);
INSERT INTO DIVISION VALUES (2,'OSD','Operations and Services Division','Operations and Services Division', 1);
INSERT INTO DIVISION VALUES (3,'TDD','Technology Development Division','Technology Development Division', 1);

INSERT INTO DIVISION VALUES (4,'ACD','Atmospheric Chemistry Division','Atmospheric Chemistry Division', 2);
INSERT INTO DIVISION VALUES (5,'CGD','Climate & Global Dynamics','Climate & Global Dynamics', 2);
INSERT INTO DIVISION VALUES (6,'HAO','High Altitude Observatory','High Altitude Observatory', 2);
INSERT INTO DIVISION VALUES (7,'MMM','Mesoscale & Microscale Meteorology','Mesoscale & Microscale Meteorology', 2);
INSERT INTO DIVISION VALUES (8,'TIIMES','The Institute for Integration & Multidisciplinary Earth Studies','The Institute for Integration & Multidisciplinary Earth Studies', 2);

INSERT INTO DIVISION VALUES (9,'CDS','Computing, Data And Software Facility','Computing, Data And Software Facility', 3);
INSERT INTO DIVISION VALUES (10,'DFS','Design and Fabrication Services','Design and Fabrication Services', 3);
INSERT INTO DIVISION VALUES (11,'FPS','Field Project Services','Field Project Services', 3);
INSERT INTO DIVISION VALUES (12,'ISF','In-Situ Sensing Facility','In-Situ Sensing Facility', 3);
INSERT INTO DIVISION VALUES (13,'RAF','Research Aviation Facility','Research Aviation Facility', 3);
INSERT INTO DIVISION VALUES (14,'RSF','Remote Sensing Facility','Remote Sensing Facility', 3);
INSERT INTO DIVISION VALUES (15,'TDF','Technology Development Facility','Technology Development Facility', 3);

INSERT INTO DIVISION VALUES (16,'AAP','Aviation Applications Program','Aviation Applications Program', 4);
INSERT INTO DIVISION VALUES (17,'HAP','Hydrometeorological Applications Program','Hydrometeorological Applications Program', 4);
INSERT INTO DIVISION VALUES (18,'ISSE','Institute for the Study of Society and Environment','Institute for the Study of Society and Environment', 4);
INSERT INTO DIVISION VALUES (19,'JNT','Joint Numerical Testbed','Joint Numerical Testbed', 4);
INSERT INTO DIVISION VALUES (20,'NSAP','National Security Applications Program','National Security Applications Program', 4);
INSERT INTO DIVISION VALUES (21,'WSAP','Weather Systems and Assessment Program','Weather Systems and Assessment Program', 4);





GRANT ALL ON REST_WS_TUTORIAL.* to 'tutorial'@'localhost' IDENTIFIED BY 'tutorial';