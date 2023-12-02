create table annotation_link_table
(
    id          BIGSERIAL,
    main_obj_id BIGINT not null,
    obj_id      BIGINT not null,
    type        varchar(6553)
);

CREATE INDEX idx_main_obj_id_obj_id_annotation_link_table ON annotation_link_table (main_obj_id, obj_id);

INSERT INTO annotation_link_table (main_obj_id, obj_id,  type)
VALUES (7,
        8,
        'classAnnotation');