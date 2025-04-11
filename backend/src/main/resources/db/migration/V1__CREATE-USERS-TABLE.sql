create table users (
    user_id uuid primary key,
    name varchar(100) not null,
    surname varchar(100) not null,
    email varchar(255) not null unique,
    password varchar(30) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);