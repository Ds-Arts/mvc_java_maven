
create database bolsillo;


use bolsillo;

create table Usuario (
usu_id int primary key auto_increment,
usu_nombre varchar(20),
usu_contrasena varchar(30),
usu_telefono int,
usu_direccion varchar(50),
usu_email varchar(50),
usu_estado boolean);

create table Cuenta (
idCuenta int primary key auto_increment,
nombreCuenta varchar(30),
tipoCuenta boolean,
estadoCuenta boolean);

drop table Nequi;
drop table Daviplata;
create table Nequi (
idNequi int primary key auto_increment,
nombreCuenta varchar(30),
contrasenaCuenta varchar(30),
estadoCuenta boolean,
saldoNequi int
);

create table Daviplata (
idDaviplatai int primary key auto_increment,
nombreCuenta varchar(30),
contrasenaCuenta varchar(30),
estadoCuenta boolean,
saldoDaviplata int
);
use bolsillo; 

select * from Nequi;