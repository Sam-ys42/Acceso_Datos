-- create database BDZapatos;

-- use BDZapatos;

create table zapato(
ID int primary key auto_increment,
marca varchar(20) not null,
modelo varchar(20) not null,
tamano varchar(20) not null,
color varchar(20) not null,
stock int not null,
precio decimal not null

);