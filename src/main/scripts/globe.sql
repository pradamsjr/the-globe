# create database script
drop database if exists globe;
create database globe;

ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
flush privileges;

create table globe.country(
    id int not null AUTO_INCREMENT,
    code char(2) not null unique,
    name varchar(80),
    population int,
    primary key(id)
);



