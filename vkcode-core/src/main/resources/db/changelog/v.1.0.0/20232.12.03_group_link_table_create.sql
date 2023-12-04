create table group_link_table
(
    id       BIGSERIAL,
    obj_id   BIGINT not null,
    group_id BIGINT not null
);

CREATE UNIQUE INDEX idx_group_link_table_obj_group ON group_link_table (obj_id, group_id);

