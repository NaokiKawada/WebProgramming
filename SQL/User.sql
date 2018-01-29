CREATE DATABASE User;

USE User;

create table Userinfo (
	id  SERIAL PRIMARY KEY ,
	login_id VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	birth_date DATE NOT NULL,
	password VARCHAR(255) NOT NULL,
	create_date DATETIME NOT NULL,
	update_date DATETIME NOT NULL
);

INSERT 
INTO Userinfo 
VALUES 
(1, 
'admin',
'ä«óùé“',
'1994/11/25',
'kaka22',
'2018/01/29',
'2018/01/29'); 
