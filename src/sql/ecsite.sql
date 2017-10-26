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
style_sex varchar(10) default "ladies",
style_comment varchar(300),
style_img varchar(100) default "img/noimg.png",
staff_id int not null,
insert_date datetime,
delete_date datetime,
foreign key(staff_id) references ecsite.staff_data(staff_id) on delete cascade
);

drop table if exists salon_data;

create table salon_data(
salon_id int not null primary key auto_increment,
salon_week varchar(50),
salon_hour varchar(50),
salon_address varchar(100),
salon_tel varchar(50),
insert_date date
);

drop table if exists salon_info;

create table salon_info(
salon_vol int not null ,
salon_info_text varchar(300),
salon_info_date varchar(100)
);

drop table if exists reserve_date;

create table reserve_date(
reserve_id int not null primary key auto_increment,
reserve_menu varchar(100),
reserve_price int(10),
reserve_time int(10),
reserve_staff varchar(100),
reserve_pay varchar(10),
user_id int not null,
reserve_flg int default 0,
reserve_start_date datetime,
reserve_end_date datetime,
insert_date date
);


insert into menu(menu_name, menu_price,menu_time) values("CUT", 6480,60);

insert into salon_data(salon_week,salon_hour,salon_address,salon_tel)values("月曜日","10:00","東京都武蔵野市吉祥寺本町0-0-0","0422-00-0000");
insert into salon_data(salon_week,salon_hour)values("火曜日","定休日");
insert into salon_data(salon_week,salon_hour)values("水曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("木曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("金曜日","10:00");
insert into salon_data(salon_week,salon_hour)values("土曜日","9:00");
insert into salon_data(salon_week,salon_hour)values("日曜日","9:00");

insert into staff_data(staff_name,staff_comment)values("田崎和幸","よろしくお願いします。");

insert into style_data(style_name,style_comment,staff_id)values("外国人風グラデーションカラー","外国人風のアッシュベースカラーがポイント",1);
insert into style_data(style_name,style_sex,style_comment,staff_id)values("外国人風グラデーションカラー","mens","外国人風のアッシュベースカラーがポイント",1);

