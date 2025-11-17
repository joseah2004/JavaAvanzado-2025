CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);



INSERT INTO usuarios (nombre, password) VALUES ('juan', '1234');
INSERT INTO usuarios (nombre, password) VALUES ('maria', 'abcd');



select * from usuarios;

