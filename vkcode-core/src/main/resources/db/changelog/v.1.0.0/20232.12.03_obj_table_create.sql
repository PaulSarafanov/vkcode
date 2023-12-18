create table obj_table
(
    id          BIGSERIAL,
    description varchar(6553),
    name        varchar(6553),
    version     varchar(40),
    type        varchar(6553),
    package_name  varchar(6553)
);

INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (1,
        'Integer',
        'java.lang',
        21,
        'Inner');
INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (2,
        'Long',
        'java.lang',
        21,
        'Inner');
INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (3,
        'String',
        'java.lang',
        21,
        'Inner');
INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (4,
        'Boolean',
        'java.lang',
        21,
        'Inner');


INSERT INTO obj_table (id, description, name, version, type, package_name)
VALUES (5,
        'Интерфейс для получения Name типа String',
        'NameAware',
        1,
        'interface',
        '');

INSERT INTO obj_table (id, description, name, version, type, package_name)
VALUES (6,
        'Интерфейс для получения Id типа Long',
        'IdAware',
        1,
        'interface',
        '');
INSERT INTO obj_table (id, description, name, version, type, package_name)
VALUES (7,
        'Информация об объекте хранящейся в таблице obj_table',
        'ObjDo',
        1,
        'class',
        '');

INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (8,
        'Data',
        'lombok',
        '1.18.30',
        '@interface');

INSERT INTO obj_table (id, name, package_name, version, type)
VALUES (9,
        'FunctionalInterface',
        'java.lang',
        '21',
        'Inner');