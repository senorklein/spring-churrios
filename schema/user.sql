CREATE DATABASE churrios;
USE DATABASE churrios;
CREATE TABLE user 
(
	uuid VARCHAR(50) NOT NULL PRIMARY KEY,
	name VARCHAR(100),
	email VARCHAR(100)
);

insert into user values ("eb8e8fa4-1e04-4aa5-bd7e-f44480e0a231", "Erik Klein" , "erik@audiotrap.com");
