drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists user_data;

create table user_data(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
tel_number varchar(50),
e_mail varchar(50),
address varchar(100),
user_flg int not null default 1,
login_flg int not null default 0,
insert_date datetime,
updated_date datetime
);

drop table if exists menu;

create table menu(
menu_id int not null primary key auto_increment,
menu_name varchar(50),
menu_price int,
menu_time int,
insert_date datetime,
update_date datetime
);

drop table if exists stylist_data;

create table stylist_data(
stylist_id int not null primary key auto_increment,
stylist_name varchar(50),
insert_date datetime,
delete_date datetime
);


INSERT INTO menu(menu_name, menu_price) VALUES("CUT", 6480);
