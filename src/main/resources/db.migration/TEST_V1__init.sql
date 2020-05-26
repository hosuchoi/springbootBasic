
--실행하고 싶으면 파일명의 맨앞의 v를 대문자로 바꿔라
drop table if exists account cascade;
drop table if exists user_infodvo cascade;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table account (id int4 not null, password varchar(255), role varchar(255), username varchar(255), primary key (id));
create table user_infodvo (id int8 not null, password varchar(255), username varchar(255), primary key (id);