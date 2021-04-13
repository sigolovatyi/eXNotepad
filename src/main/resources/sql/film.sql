create database notepad;

use notepad;

drop table movie;

create table movies
(
    id bigint auto_increment,
    title varchar(30),
    style varchar(30) default 'unknown',
    ref varchar(100) default 'https://www.kinopoisk.ru',
    advice tinyint default 0,
    PRIMARY KEY (id)
);

delete from movies;

select * from movies;