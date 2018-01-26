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
