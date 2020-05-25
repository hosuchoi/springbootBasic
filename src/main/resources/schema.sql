-- schema.sql (스키마 관련)
-- data.sql ( Data 관련 )
drop table if exists account cascade;
drop table if exists user_infodvo cascade;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table account (id int4 not null, password varchar(255), role varchar(255), username varchar(255), primary key (id));
create table user_infodvo (id int8 not null, password varchar(255), username varchar(255), primary key (id);
