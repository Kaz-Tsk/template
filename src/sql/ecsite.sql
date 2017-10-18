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
staff_comment varchar(300),
staff_img varchar(100) default "img/noimg.png",
insert_date datetime,
delete_date datetime
);

drop table if exists style_data;

create table style_data(
style_id int not null primary key auto_increment,
style_name varchar(50),
style_comment varchar(300),
style_img varchar(100) default "img/noimg.png",
insert_date datetime,
delete_date datetime
);

drop table if exists salon_data;

create table salon_data(
salon_id int not null primary key auto_increment,
salon_week varchar(50),
salon_hour varchar(50),
salon_address varchar(100),
salon_tel varchar(50),
salon_info varchar(200),
insert_date date
);

insert into menu(menu_name, menu_price,menu_time) values("CUT", 6480,60);

insert into salon_data(salon_week,salon_hour,salon_address,salon_tel,salon_info)values("月曜日","10:00","東京都武蔵野市吉祥寺本町0-0-0","0422-00-0000","サロンHP新規オープンしました！");
insert into salon_data(salon_week,salon_hour)values("火曜日","定休日");
insert into salon_data(salon_week,salon_hour)values("水曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("木曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("金曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("土曜日","9:00");
insert into salon_data(salon_week,salon_hour)values("日曜日","9:00");

insert into staff_data(staff_name,staff_comment)values("田崎和幸","よろしくお願いします。");

insert into style_data(style_name,style_comment)values("外国人風グラデーションカラー","外国人風のアッシュベースカラーがポイント");
