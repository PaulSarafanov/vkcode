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

create table program_dependencies_link_table
(
    id         BIGSERIAL,
    program_id BIGINT not null,
    dependency_program_id     BIGINT not null
);
CREATE UNIQUE INDEX uidx_prg_id_dependency_prg_id_program_dependencies_link_table ON program_dependencies_link_table (program_id, dependency_program_id);



INSERT INTO program_table (id, description, name, version, group_id)
VALUES (1,
        'description',
        'vkcode',
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

INSERT INTO program_table (id, description, name, version, group_id)
VALUES (2,
        'Lombock https://projectlombok.org/',
        'lombok',
        '1.18.30',
        'org.projectlombok');
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (2,
        8);


INSERT INTO program_table (id, description, name, version, group_id)
VALUES (3,
        'Java SE 21',
        'java',
        '21.0.1',
        '');
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (3,
        1);
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (3,
        2);
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (3,
        3);
INSERT INTO program_obj_link_table (program_id, obj_id)
VALUES (3,
        4);



INSERT INTO program_dependencies_link_table (program_id, dependency_program_id)
VALUES (1,
        2);
INSERT INTO program_dependencies_link_table (program_id, dependency_program_id)
VALUES (1,
        3);