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
insert_date date
);

drop table if exists menu;

create table menu(
menu_id int ,
menu_name varchar(50),
menu_price int not null,
menu_time int
);

drop table if exists staff_data;

create table staff_data(
staff_id int ,
staff_name varchar(50),
staff_comment varchar(300),
staff_img varchar(100)
);

drop table if exists style_data;

create table style_data(
style_vol int not null,
style_name varchar(50),
style_sex varchar(10) default "ladies",
style_comment varchar(300),
style_img varchar(100),
staff_id int not null
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
salon_vol int  ,
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

insert into menu(menu_id,menu_name, menu_price,menu_time) values(1,"CUT",6480,60);
insert into menu(menu_id,menu_name, menu_price,menu_time) values(2,"COLOR",6480,60);
insert into menu(menu_id,menu_name, menu_price,menu_time) values(3,"PERM",6480,60);
insert into menu(menu_id,menu_name, menu_price,menu_time) values(4,"STRAIGT", 20000,180);
insert into menu(menu_id,menu_name, menu_price,menu_time) values(5,"TREATMENT", 4860,60);
insert into menu(menu_id,menu_name, menu_price,menu_time) values(6,"SHAMPOO&BLOW", 3240,60);

insert into salon_data(salon_week,salon_hour,salon_address,salon_tel) values("月曜日","10:00","東京都武蔵野市吉祥寺本町0-0-0","0422-00-0000");
insert into salon_data(salon_week,salon_hour) values("火曜日","定休日");
insert into salon_data(salon_week,salon_hour) values("水曜日","10:00");
insert into salon_data(salon_week,salon_hour) values("木曜日","10:00");
insert into salon_data(salon_week,salon_hour) values("金曜日","10:00");
insert into salon_data(salon_week,salon_hour) values("土曜日","9:00");
insert into salon_data(salon_week,salon_hour) values("日曜日","9:00");

insert into staff_data(staff_id,staff_name,staff_comment,staff_img) values(1,"田崎 和幸","よろしくお願いします。","img/staff1.jpg");
insert into staff_data(staff_id,staff_name,staff_comment,staff_img) values(2,"田中 千尋","よろしくお願いします。","img/staff2.jpg");
insert into staff_data(staff_id,staff_name,staff_comment,staff_img) values(3,"青木 真弓","よろしくお願いします。","img/staff3.jpg");
insert into staff_data(staff_id,staff_name,staff_comment,staff_img) values(4,"横山 舞","よろしくお願いします。","img/staff4.jpg");

insert into user_data(id,login_id,login_pass,user_name,tel_number,e_mail,address,user_flg,login_flg) values(1,"user",1234,"テストユーザー",08011111111,"test@gmail.com","長崎県",1,0);
insert into user_data(id,login_id,login_pass,user_name,tel_number,e_mail,address,user_flg,login_flg) values(2,"admin",1234,"管理者",08022222222,"admin@gmail.com","長崎県",2,0);


insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(1,"外国人風グラデーションカラー","ladies","外国人風のアッシュ系のグラデーションカラーがポイントのヘアスタイル","img/style1.jpg",1);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(2,"クリアボブ","ladies","透明感のあるショートボブがポイントのヘアスタイル","img/style2.jpg",1);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(3,"ショートバングボブ","ladies","斜めに切り込んだショートバングがポイントのヘアスタイル","img/style3.jpg",1);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(4,"グランジショートボブ","ladies","ラフなパーマが今時のヘアスタイル","img/style4.jpg",2);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(5,"スイングカール","ladies","軽い弾むようなパーマがポイントのヘアスタイル","img/style5.jpg",1);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(6,"クリアボブ（サイド）","ladies","透明感のあるアッシュカラーがポイントのヘアスタイル","img/style6.jpg",3);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(7,"グレージュミディアム","ladies","外国人風のグレージュカラーがポイントのヘアスタイル","img/style7.jpg",4);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(8,"メンズマッシュショート","mens","軽い束感がポイントのヘアスタイル","img/style8.jpg",1);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(9,"外国人風リーゼントスタイル","mens","外国人風のロカビリー調のスタイルがポイントのヘアスタイル","img/style9.jpg",2);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(10,"外国人風リーゼントスタイル２","mens","強めの刈り上げがポイントのヘアスタイル","img/style10.jpg",3);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(11,"外国人風リーゼントスタイル３","mens","外国人風のアッシュ系のカラーがポイントの男らしいヘアスタイル","img/style11.jpg",4);
insert into style_data(style_vol,style_name,style_sex,style_comment,style_img,staff_id) values(12,"刈り上げマッシュショート","ladies","サイドの刈り上げがさりげない少し柔らかな雰囲気がポイントのヘアスタイル","img/style12.jpg",2);

insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(1,"新規ホームページ開設しました。",'2017-11-1');
insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(2,"ヘアスタイル更新しました。",'2017-11-2');
insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(3,"料金表更新しました。",'2017-11-3');
insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(4,"サロンの休日変更しました。",'2017-11-4');
insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(5,"スタッフ情報更新しました。",'2017-11-5');
insert into salon_info(salon_vol,salon_info_text,salon_info_date) values(6,"HPでご予約いただけるようになりました。",'2017-11-6');
