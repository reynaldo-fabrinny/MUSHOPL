CREATE TABLE user (
  id INTEGER NOT NULL IDENTITY,
  email varchar(45) UNIQUE NOT NULL,
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL
);

--CREATE TABLE item (
--  id INTEGER NOT NULL IDENTITY,
--  email varchar(45) UNIQUE NOT NULL,
--  name varchar(45) NOT NULL,
--  password varchar(45) NOT NULL
--);


insert into user (email, name, password) values ('reynaldo@gmail.com','reynaldo','1234');