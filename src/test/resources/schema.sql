
create table account(
	id bigint not null auto_increment,
	account_name varchar(64) default '' not null,
	password varchar(64) not null,
	salt varchar(64) not null,
	create_time datetime not null default current_timestamp,
	-- h2 database 不支持 on update
	modify_time datetime not null default current_timestamp,
	primary key(id)
);

-- 模拟 on update
create trigger ACCOUNT_UPD  after update on account for each row call "xin.soren.micelle.service.account.ModifyTimeTrigger";