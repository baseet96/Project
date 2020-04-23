DROP TABLE Users CASCADE CONSTRAINTS;

create table Users {
	email VARCHAR2(20) NOT NULL,
	kind ENUM('ADMIN', 'CUSTOMER') NOT NULL,
	name VARCHAR2(20),
	dob DATE,
	password VARCHAR2(20) NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY (email)
}

INSERT INTO Users VALUES ('admin@infosys.com', 'ADMIN', 'Sam Williams', '1990-01-01', 'password');
INSERT INTO Users VALUES ('customer@infosys.com', 'CUSTOMER', 'Bill Billiams', '1990-01-01', 'password');
