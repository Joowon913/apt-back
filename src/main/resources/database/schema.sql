drop database if exists apt;
create database apt character set = utf8mb4;
use apt;

create table place (
place_id bigint not null auto_increment,
work_place varchar(30) not null,
address varchar(30) not null,
primary key(seq)
);

create table emp (
emp_id bigint not null auto_increment,
place_id bigint not null,
id varchar(50) not null,
password varchar(20) not null,
department varchar(10) not null,
position varchar(10) not null,
auth varchar(10) not null,
name varchar(10) not null,
phone varchar(13) not null,
address varchar(100) not null,
address_detail varchar(100),
birth varchar(8) not null,
primary key(emp_id),
foreign key(place_id) references place(place_id) on delete cascade
);

create table integration (
integration_id bigint not null auto_increment,
emp_id bigint not null comment,
field varchar(10) not null,
title varchar(30) not null,
content text(1000) not null,
origin_filename varchar(255),
save_filename varchar(255),
save varchar(255),
purpose varchar(50),
image_title varchar(100),
emp_name varchar(10) not null,
insert_date date not null,
update_date date,
primary key(integration_id),
foreign key(emp_id) references emp(emp_id) on delete cascade
);

create table lost_item (
seq bigint not null auto_increment,
emp_id bigint not null,
title varchar(30) not null,
content text(1000) not null,
note text(1000),
status varchar(10) not null,
emp_name varchar(10) not null,
insert_date date not null,
update_date date,
primary key(seq),
foreign key(emp_id) references emp(emp_id) on delete cascade
);

create table event (
seq bigint not null auto_increment,
emp_id bigint not null,
date_time datetime not null,
title varchar(30) not null,
content text(1000) not null,
note text(1000),
emp_name varchar(10) not null,
insert_date date not null,
update_date date,
primary key(seq),
foreign key(emp_id) references emp(emp_id) on delete cascade
);

create table parking (
seq bigint not null auto_increment,
emp_id bigint not null,
car_number varchar(10) not null,
location varchar(10) not null,
note text(1000),
emp_name varchar(10) not null,
insert_date date not null,
update_date date,
primary key(seq),
foreign key(emp_id) references emp(emp_id) on delete cascade
);