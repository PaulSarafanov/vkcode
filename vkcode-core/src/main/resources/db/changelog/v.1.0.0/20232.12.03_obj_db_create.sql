create table obj_table
(
    id       BIGSERIAL,
    uuid     varchar(36) unique ,
    name     varchar(6553),
    type     varchar(6553),
    jsonData varchar
);

