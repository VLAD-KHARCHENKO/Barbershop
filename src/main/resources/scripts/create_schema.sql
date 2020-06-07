drop schema if exists barber_database;
create schema barber_database character set utf8 collate utf8_general_ci;
use barber_database;

create table user (
id Int auto_increment,
first_name varchar(255),
last_name varchar(255),
phone varchar(255),
login varchar(255) unique,
password varchar(255) not null,
role enum("CUSTOMER", "ADMIN", "MASTER"),
primary key (id));

create table feedback(
id int auto_increment,
`date` datetime,
feedback varchar(2000) not null,
userId int,
primary key (id),
foreign key (userId) references user(id)
);

create table service (
id Int auto_increment,
service_name varchar(255),
price decimal,
primary key (id));

create table master (
id Int auto_increment,
userId int,
photo varchar(255),
primary key (id),
foreign key (userId) references user (id)
);
 create table skills(
 id Int auto_increment,
 masterId int,
 serviceId int,
 primary key (id),
 foreign key (masterId) references master (id),
foreign key (serviceId) references service (id)
  );

create table schedule(
 id Int auto_increment,
  userId int,
  datetime TIMESTAMP,
 status ENUM( "BOOKED", "FREE"),
 masterId int,
 primary key (id),
 foreign key (masterId) references master (id),
foreign key (userId) references user (id)
  );