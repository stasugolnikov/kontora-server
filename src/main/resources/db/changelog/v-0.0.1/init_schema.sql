create schema if not exists kontora_schema;

create table kontora_schema.role
(
    id   bigint       not null primary key,
    "name" varchar(100) not null
);
create table kontora_schema."user"
(
    id         bigint       not null primary key,
    full_name  varchar(100) not null,
    phone      varchar(100) not null,
    username   varchar(100) not null,
    "password" varchar(100) not null,
    role_id    bigint       not null references kontora_schema.role
);



create table kontora_schema.hairdresser
(
    id          bigint       not null primary key,
    full_name   varchar(100) not null,
    phone       varchar(100) not null,
    description varchar(256) not null
);

create table kontora_schema.service
(
    id   bigint primary key,
    name varchar(100)
);

create table kontora_schema.service_info
(
    id             bigint  not null primary key,
    price          int     not null,
    service_id     integer not null references kontora_schema.service,
    hairdresser_id bigint  not null references kontora_schema.hairdresser
);

create table kontora_schema.visit
(
    id              bigint not null primary key,
    user_id         bigint not null references kontora_schema."user",
    service_info_id bigint not null references kontora_schema.service_info,
    "comment"       varchar(150),
    "date"          timestamp
);
;;