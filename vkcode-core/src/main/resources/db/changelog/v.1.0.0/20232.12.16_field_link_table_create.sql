create table field_link_table
(
    id          BIGSERIAL,
    main_obj_id BIGINT not null,
    obj_id      BIGINT not null,
    description varchar(6553),
    name        varchar(6553),
    type        varchar(6553)
);

CREATE UNIQUE INDEX uidx_main_obj_id_name_field_link_table ON field_link_table (main_obj_id, name);

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        2,
        'id',
        'private');

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        3,
        'description',
        'private');

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        3,
        'name',
        'private');

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        1,
        'version',
        'private');

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        3,
        'type',
        'private');

INSERT INTO field_link_table (main_obj_id, obj_id, name, type)
VALUES (7,
        3,
        'className',
        'private');