CREATE TABLE USER (
  id INTEGER NOT NULL IDENTITY,
  email varchar(45) UNIQUE NOT NULL,
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL
);

CREATE TABLE ITEM (
  id INTEGER NOT NULL IDENTITY,
  name varchar(45) NOT NULL,
);


--CREATE TABLE item (
--  id INTEGER NOT NULL IDENTITY,
--  email varchar(45) UNIQUE NOT NULL,
--  name varchar(45) NOT NULL,
--  password varchar(45) NOT NULL
--);

GRANT ALL PRIVILEGES ON ITEM TO PUBLIC;
GRANT ALL PRIVILEGES ON USER TO PUBLIC

insert into item(name) values ('rice');
insert into user (email, name, password) values ('reynaldo@gmail.com','reynaldo','1234');