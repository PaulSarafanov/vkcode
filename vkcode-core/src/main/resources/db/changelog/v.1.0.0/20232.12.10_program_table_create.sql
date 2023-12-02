create table program_table
(
    id          BIGSERIAL,
    description varchar(6553),
    name        varchar(6553),
    version     varchar(40),
    group_id    varchar(6553)
);

create table program_obj_link_table
(
    id         BIGSERIAL,
    program_id BIGINT not null,
    obj_id     BIGINT not null
);

CREATE UNIQUE INDEX uidx_program_id_obj_id_program_obj_link_table ON program_obj_link_table (program_id, obj_id);


INSERT INTO program_table (id, description, name, version, group_id)
VALUES (1,
        'description',
        'VkCodeGen',
        '0.0.1-SNAPSHOT',
        'ru.nsk.positiveteam');
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (1,
        5);
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (1,
        6);
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (1,
        7);


