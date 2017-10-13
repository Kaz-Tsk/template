drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table user_data(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
tel_number varchar(50),
e_mail varchar(50),
address varchar(100),
insert_date datetime,
updated_date datetime
);

drop table if exists menu;

create table menu(
id int not null primary key auto_increment,
menu_name varchar(50),
menu_price int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);


INSERT INTO menu(menu_name, menu_price) VALUES("CUT", 6480);
INSERT INTO user_data(login_id, login_pass, user_name,tel_number,e_mail,address) VALUES("tasaki","1234","田崎和幸","012345678","tasaki@gmail.com",	"日本");