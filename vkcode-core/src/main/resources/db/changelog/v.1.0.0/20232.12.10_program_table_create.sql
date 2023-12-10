create table program_table
(
    id          BIGSERIAL,
    name        varchar(6553),
    version     varchar(40),
    type        varchar(6553),
    description varchar(6553),
    group_id    varchar(6553)
);

create table program_obj_link_table
(
    id         BIGSERIAL,
    program_id BIGINT not null,
    obj_id     BIGINT not null
);

CREATE UNIQUE INDEX idx_program_id_obj_id_program_obj_link_table ON program_obj_link_table (program_id, obj_id);

create table program_group_link_table
(
    id         BIGSERIAL,
    program_id BIGINT not null,
    group_id   BIGINT not null
);

CREATE UNIQUE INDEX idx_program_id_group_id_program_group_link_table ON program_group_link_table (program_id, group_id);

