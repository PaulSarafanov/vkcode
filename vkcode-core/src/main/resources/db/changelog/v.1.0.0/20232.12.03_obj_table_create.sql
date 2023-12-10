create table obj_table
(
    id          BIGSERIAL,
    description varchar(6553),
    name        varchar(6553),
    version     varchar(40),
    type        varchar(6553),
    class_name  varchar(6553)
);

INSERT INTO obj_table (id, name, class_name, type)
VALUES (1,
        'Integer',
        'java.lang.Integer',
        'Inner');
INSERT INTO obj_table (id, name, class_name, type)
VALUES (2,
        'Long',
        'java.lang.Long',
        'Inner');
INSERT INTO obj_table (id, name, class_name, type)
VALUES (3,
        'String',
        'java.lang.String',
        'Inner');


INSERT INTO obj_table (id, description, name, version, type, class_name)
VALUES (4,
        'Интерфейс для получения Name типа String',
        'NameAware',
        1,
        'Interface',
        'NameAware');

INSERT INTO obj_table (id, description, name, version, type, class_name)
VALUES (5,
        'Интерфейс для получения Id типа Long',
        'IdAware',
        1,
        'Interface',
        'IdAware');
INSERT INTO obj_table (id, description, name, version, type, class_name)
VALUES (6,
        'Информация об объекте хранящейся в таблице obj_table',
        'ObjDo',
        1,
        'Class',
        'ObjDo');