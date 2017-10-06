
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

create table bookmark (
	id bigint not null auto_increment,
	user_id bigint not null,
	name varchar(256) not null,
	url varchar(512) not null,
	parent_id bigint not null default 0,
	is_delete int not null default 0,
	category varchar(16) not null,
	create_time datetime not null default current_timestamp,
	-- h2 database 不支持 on update
	modify_time datetime not null default current_timestamp,
	primary key(id)
);
