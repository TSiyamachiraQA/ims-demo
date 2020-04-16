create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(product_id int primary key auto_increment, title varchar(40), rating int, price int , stock int);