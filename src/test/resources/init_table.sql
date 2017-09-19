--create table account(
--	id bigint not null auto_increment,
--	account_name varchar(64) not null default "",
--	password varchar(64) not null,
--	salt varchar(64) not null,
--	create_time datetime not null default current_timestamp,
--	modify_time datetime not null default current_timestamp on update current_timestamp,
--	primary key(id)
--);
select * from account;