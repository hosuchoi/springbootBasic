select account0_.id as id1_0_, account0_.password as password2_0_, account0_.role as role3_0_, account0_.username as username4_0_ from account account0_ where account0_.username='lake';
select nextval ('hibernate_sequence');
insert into account (password, role, username, id) values (1, '{bcrypt}$2a$10$Gom1CMVU0/GsVZ5AgPFqd.4E34LFdlTskl60TqMid4e9O6fQlDHJ2', 'ROLE_ADMIN', 'lake');
select account0_.id as id1_0_, account0_.password as password2_0_, account0_.role as role3_0_, account0_.username as username4_0_ from account account0_ where account0_.username='USER';
select nextval ('hibernate_sequence');
insert into account (password, role, username, id) values (2, '{bcrypt}$2a$10$Gom1CMVU0/GsVZ5AgPFqd.4E34LFdlTskl60TqMid4e9O6fQlDHJ2', 'ROLE_AUTH', 'USER');