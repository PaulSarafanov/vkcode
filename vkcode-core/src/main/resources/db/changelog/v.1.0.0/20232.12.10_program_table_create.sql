create table program_table
(
    id          BIGSERIAL,
    description varchar(6553),
    name        varchar(6553),
    version     varchar(40),
    group_id    varchar(6553),
    type        varchar(40)
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
    id                    BIGSERIAL,
    program_id            BIGINT not null,
    dependency_program_id BIGINT not null
);
CREATE UNIQUE INDEX uidx_prg_id_dependency_prg_id_program_dependencies_link_table ON program_dependencies_link_table (program_id, dependency_program_id);