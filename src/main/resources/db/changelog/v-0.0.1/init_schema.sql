create schema if not exists kontora_schema;

create table kontora_schema.role
(
    id     bigint       not null primary key,
    "name" varchar(100) not null
);

insert into kontora_schema.role (id, name)
values (1, 'ADMIN');


insert into kontora_schema.role (id, name)
values (2, 'USER');

create table kontora_schema."user"
(
    id         bigint primary key generated always as identity,
    full_name  varchar(100),
    phone      varchar(100),
    username   varchar(100),
    "password" varchar(100),
    role_id    bigint not null references kontora_schema.role
);
create table kontora_schema.service
(
    id   bigint primary key,
    name varchar(100)
);

create table kontora_schema.hairdresser
(
    id          bigint primary key,
    full_name   varchar(100),
    phone       varchar(100),
    description varchar(256)
);

create table kontora_schema.service_info
(
    id             bigint primary key,
    price          int,
    service_id     integer references kontora_schema.service,
    hairdresser_id bigint references kontora_schema.hairdresser
);

create table kontora_schema.visit
(
    id              bigint primary key generated always as identity,
    user_id         bigint references kontora_schema."user",
    service_info_id bigint references kontora_schema.service_info,
    "comment"       varchar(150),
    "date"          timestamp
);

insert into kontora_schema."user" (full_name, username, "password", role_id)
values ('admin', 'admin', '$2a$12$0t9gr1NRKOEwkbx6UZhUf.4Gcj7AEW0aQHIF4mg39qe0jpD1JQ5C6', 1);

insert into kontora_schema.hairdresser (id, full_name)
values (1, 'Егор Савковский'),
       (2, 'Илья Шевчук'),
       (3, 'Стас Угольников'),
       (4, 'Леха Москвинов');


insert into kontora_schema.service (id, name)
values (1, 'Стрижка налысо'),
       (2, 'Барбер стрижка'),
       (3, 'Маникюр'),
       (4, 'Стрижка + маникюр');


insert into kontora_schema.service_info (id, price, service_id, hairdresser_id)
values (1, 1000, 1, 3),
       (2, 1000, 2, 4),
       (3, 1000, 4, 2),
       (4, 1000, 3, 1);


