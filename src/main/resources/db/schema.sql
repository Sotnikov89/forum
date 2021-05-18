create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);
create table users (
                       id serial primary key,
                       password varchar,
                       username varchar unique,
                       enabled boolean
);
create table roles (
                       id serial primary key,
                       name varchar
);
create table users_roles (
                        id serial primary key,
                        user_id int not null references users(id),
                        roles_id int not null references roles(id)
);