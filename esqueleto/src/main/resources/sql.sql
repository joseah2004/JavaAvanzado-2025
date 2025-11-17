-- Crear tabla (con nombre correcto)
CREATE TABLE IF NOT EXISTS usuarios3333 (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    nombre TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

-- Insertar usuarios en la tabla correcta
INSERT INTO usuarios3333 (nombre, password) VALUES ('juan', '1234'); 
INSERT INTO usuarios3333 (nombre, password) VALUES ('maria', 'abcd');
