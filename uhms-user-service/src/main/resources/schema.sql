create database uhms

use uhms

create table t_user(
	id bigint not null auto_increment,
    name varchar(255) not null,
    address varchar(255) not null,
    primary key(id)
)