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
menu_price decimal not null,
menu_time int,
insert_date datetime,
update_date datetime
);

drop table if exists staff_data;

create table staff_data(
staff_id int not null primary key auto_increment,
staff_name varchar(50),
sfaff_comment varchar(300),
insert_date datetime,
delete_date datetime
);

drop table if exists salon_data;

create table salon_data(
salon_week varchar(50),
salon_hour varchar(50),
salon_info varchar(200),
insert_date date
);

INSERT INTO menu(menu_name, menu_price,menu_time) VALUES("CUT", 6480,60);
insert into salon_data(salon_info)values("サロンHP新規オープンしました！");