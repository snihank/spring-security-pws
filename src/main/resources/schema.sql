create schema if not exists game_store;
use game_store;

create table if not exists game (
    game_id int(11) not null auto_increment primary key,
    title varchar(50) not null,
    esrb_rating varchar(50) not null,
    description varchar(255) not null,
    price decimal(5, 2) not null,
    studio varchar(50) not null,
    quantity int(11)
);

create table if not exists console (
    console_id int(11) not null auto_increment primary key,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    memory_amount varchar(20),
    processor varchar(20),
    price decimal(5, 2) not null,
    quantity int(11) not null
);

create table if not exists t_shirt (
    t_shirt_id int(11) not null auto_increment primary key,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int(11) not null
);

create table if not exists sales_tax_rate (
    state char(2) not null,
    rate decimal(3,2) not null
);

create unique index ix_state_rate on sales_tax_rate (state, rate);

create table if not exists processing_fee (
    product_type varchar(20) not null,
    fee decimal (4,2)
);

create unique index ix_product_type_fee on processing_fee (product_type, fee);

create table if not exists invoice (
    invoice_id int(11) not null auto_increment primary key,
    name varchar(80) not null,
    street varchar(30) not null,
    city varchar(30) not null,
    state varchar(30) not null,
    zipcode varchar(5) not null,
    item_type varchar(20) not null,
    item_id int(11) not null,
    unit_price decimal(5,2) not null,
    quantity int(11) not null,
    subtotal decimal(5,2) not null,
    tax decimal(5,2) not null,
    processing_fee decimal (5,2) not null,
    total decimal(5,2) not null
);


create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));
	create unique index ix_auth_username on authorities (username,authority
);

insert into users (username, password, enabled) values ('managerUser', '$2a$10$8cNmo/pMyjK01AkAtcugFuCA5D44SJB47PCE.fc7lQC6Ffz7jWz2u', true);
insert into users (username, password, enabled) values ('adminUser', '$2a$10$eJ8VFDBc1Vo7vYOIUb03o.JwFcvfl99jEPvVImA2lbeDfgMdVYheG', true);
insert into users (username, password, enabled) values ('staffUser', '$2a$10$4Z8QOpcJjqVcIHf/lxtuAOW9cgfQ5ipVaoun2Omzlq9gUUEr5s7I2', true);

insert into authorities (username, authority) values ('managerUser', 'STAFF');
insert into authorities (username, authority) values ('managerUser', 'MANAGER');
insert into authorities (username, authority) values ('adminUser', 'STAFF');
insert into authorities (username, authority) values ('adminUser', 'MANAGER');
insert into authorities (username, authority) values ('adminUser', 'ADMIN');
insert into authorities (username, authority) values ('staffUser', 'STAFF');