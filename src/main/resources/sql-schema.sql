create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(product_id int primary key auto_increment, title varchar(40), rating int, price int , stock int);
create table if not exists ims.orders(order_id int primary key auto_increment, fk_customer_id int, quantity int, total int, foreign key(fk_customer_id) references customers(id));
create table if not exists ims.orderline(fk_order_id int , fk_customer_id int, foreign key(fk_order_id) references orders(order_id), foreign key(fk_customer_id) references customers(id));