-- schema.sql (스키마 관련)
-- data.sql ( Data 관련 )
drop table user_info if exists
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table user_info account ( not null, email varchar(255), password varchar(255), uesrname varchar(255), id)id bigint