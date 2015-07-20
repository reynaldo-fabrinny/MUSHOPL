--Working 

alter table ITEM drop constraint FK_30qxelxj4lnq7fxjufwn2dwf7;
 alter table USER drop constraint FK_jj1i1ejomt70kg80tncyl1uo5;
 alter table item_shoplist drop constraint FK_m17rx3mxyy578rt5ihmpnc4pn;
 alter table item_shoplist drop constraint FK_dk1ngitqf21hqsfm3vw22ko90;
 drop table ITEM if exists;
 drop table SHOPLIST if exists;
 drop table USER if exists;
 drop table item_shoplist if exists;
 create table ITEM (ITEM_ID bigint generated by default as identity (start with 1), NAME varchar(255) not null, QUANTITY integer not null, SHOPLIST_ID bigint, primary key (ITEM_ID));
 create table SHOPLIST (SHOPLIST_ID bigint generated by default as identity (start with 1), primary key (SHOPLIST_ID));
 create table USER (USER_ID bigint generated by default as identity (start with 1), EMAIL varchar(255) not null, NAME varchar(255) not null, PASSWORD varchar(255) not null, SHOPLIST_ID bigint, primary key (USER_ID));
 create table item_shoplist (SHOPLIST_ID bigint not null, ITEM_ID bigint not null);
 alter table USER add constraint UK_ejfk3g58oxsgbb4ju3u4fhivk  unique (EMAIL);
 alter table item_shoplist add constraint UK_m17rx3mxyy578rt5ihmpnc4pn  unique (ITEM_ID);
 alter table ITEM add constraint FK_30qxelxj4lnq7fxjufwn2dwf7 foreign key (SHOPLIST_ID) references SHOPLIST;
 alter table USER add constraint FK_jj1i1ejomt70kg80tncyl1uo5 foreign key (SHOPLIST_ID) references SHOPLIST;
 alter table item_shoplist add constraint FK_m17rx3mxyy578rt5ihmpnc4pn foreign key (ITEM_ID) references ITEM;
 alter table item_shoplist add constraint FK_dk1ngitqf21hqsfm3vw22ko90 foreign key (SHOPLIST_ID) references SHOPLIST;
 
--Basic data
insert into SHOPLIST ("SHOPLIST_ID") values(0);
insert into SHOPLIST ("SHOPLIST_ID") values(1);
insert into user (email, name, password,SHOPLIST_ID) values ('reynaldo@gmail.com','reynaldo','1234',0);
insert into user (email, name, password,SHOPLIST_ID) values ('test@gmail.com','test','1234',1);
