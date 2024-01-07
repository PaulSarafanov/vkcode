create table method_table
(
    id            BIGSERIAL,
    description   varchar(6553),
    name          varchar(6553),
    version       varchar(6553),
    type          varchar(6553),
    return_obj_id BIGINT
);

create table obj_method_link_table
(
    id          BIGSERIAL,
    method_id   BIGINT not null,
    obj_id      BIGINT not null,
    description varchar(6553),
    type        varchar(6553)
);

CREATE UNIQUE INDEX uidx_obj_id_method_id_obj_method_link_table ON obj_method_link_table (obj_id, method_id);


INSERT INTO method_table (id,
                          description,
                          name,
                          version,
                          type,
                          return_obj_id)
VALUES (1,
        'Метод получает Id типа Long',
        'getId',
        1,
        'getter',
        2);

INSERT INTO method_table (id,
                          description,
                          name,
                          version,
                          type,
                          return_obj_id)
VALUES (2,
        'Метод получает Name типа String',
        'getName',
        1,
        'getter',
        3);

INSERT INTO method_table (id,
                          description,
                          name,
                          version,
                          type,
                          return_obj_id)
VALUES (3,
        'Метод получает ObjDo by Id',
        'getById',
        1,
        'abstractPublic',
        7);

INSERT INTO obj_method_link_table (method_id, obj_id, type)
VALUES (2,
        5,
        'abstractPublic');

INSERT INTO obj_method_link_table (method_id, obj_id, type)
VALUES (1,
        6,
        'abstractPublic');

INSERT INTO obj_method_link_table (method_id, obj_id, type)
VALUES (3,
        25,
        'abstractPublic');