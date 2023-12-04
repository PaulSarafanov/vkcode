create table field_link_table
(
    id          BIGSERIAL,
    main_obj_id BIGINT not null,
    obj_id      BIGINT not null
);

CREATE UNIQUE INDEX idx_link_table_obj_group ON field_link_table (main_obj_id, obj_id);

