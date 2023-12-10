create table method_table
(
    id            BIGSERIAL,
    description   varchar(6553),
    name          varchar(6553),
    version       integer,
    type          varchar(6553),
    return_obj_id BIGINT
);

create table obj_method_link_table
(
    id        BIGSERIAL,
    method_id BIGINT not null,
    obj_id    BIGINT not null
);

CREATE UNIQUE INDEX idx_obj_id_method_id_obj_method_link_table ON obj_method_link_table (obj_id, method_id);


INSERT INTO method_table (id,
                          description,
                          name,
                          version,
                          type,
                          return_obj_id)
VALUES (1,
        'Метод получает Name',
        'getName',
        1,
        'getter',
        3);

INSERT INTO obj_method_link_table (id, method_id, obj_id)
VALUES (1,
        1,
        5);

