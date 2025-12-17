-- create database BDZapatos;

 use BDZapatos;

create table zapato(
ID int primary key auto_increment,
marca varchar(20) not null,
modelo varchar(20) not null,
tamano varchar(20) not null,
color varchar(20) not null,
stock int not null,
precio decimal not null

);

call contarZapatos() ;


DELIMITER //
CREATE FUNCTION contarZapatosDOS()
RETURNS INT
DETERMINISTIC
begin
	declare total int;
    select count(*) into total from zapato;
    
    return total;
end //
DELIMITER ;