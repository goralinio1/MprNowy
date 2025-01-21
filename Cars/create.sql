create table car (cylinders integer, year integer, car_class_id bigint, car_model_id bigint, fuel_type_id bigint, id bigint not null auto_increment, drive varchar(255), transmission varchar(255), primary key (id)) engine=InnoDB;
create table car_class (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table car_model (id bigint not null auto_increment, producer_id bigint, name varchar(255), primary key (id)) engine=InnoDB;
create table fuel_type (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table producer (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
alter table car add constraint FKbp2cjm2fx85d538siqn09ubsd foreign key (car_class_id) references car_class (id);
alter table car add constraint FKgfht1l5lcn8gbugha10mnt4bg foreign key (car_model_id) references car_model (id);
alter table car add constraint FKchdpe924jrjx3mbgtcod0amcg foreign key (fuel_type_id) references fuel_type (id);
alter table car_model add constraint FK39nh3m4918h84h2rcnaf14x02 foreign key (producer_id) references producer (id);

create table car (cylinders integer, year integer, car_class_id bigint, car_model_id bigint, fuel_type_id bigint, id bigint not null auto_increment, drive varchar(255), transmission varchar(255), primary key (id)) engine=InnoDB;
create table car_class (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table car_model (id bigint not null auto_increment, producer_id bigint, name varchar(255), primary key (id)) engine=InnoDB;
create table fuel_type (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table producer (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
alter table car add constraint FKbp2cjm2fx85d538siqn09ubsd foreign key (car_class_id) references car_class (id);
alter table car add constraint FKgfht1l5lcn8gbugha10mnt4bg foreign key (car_model_id) references car_model (id);
alter table car add constraint FKchdpe924jrjx3mbgtcod0amcg foreign key (fuel_type_id) references fuel_type (id);
alter table car_model add constraint FK39nh3m4918h84h2rcnaf14x02 foreign key (producer_id) references producer (id);
