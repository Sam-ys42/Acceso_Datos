-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS Alumnos;

-- Crear la base de datos
CREATE DATABASE Alumnos;
USE alumnos;


DELIMITER $$

CREATE FUNCTION contarAlumnos()
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    
    SELECT count(*) INTO total FROM ALUMNO; 
    
    RETURN total;
END$$

DELIMITER ;



DELIMITER $$

CREATE FUNCTION chequearAlumno(idAlumno INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE existe BOOLEAN;

    IF EXISTS (SELECT * FROM ALUMNO WHERE id = idAlumno) THEN
        SET existe = TRUE;
    ELSE
        SET existe = FALSE;
    END IF;

    RETURN existe;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE insertarAlumno(
    IN p_nombre VARCHAR(50),
    IN p_curso ENUM('1DAM','1DAW','2DAM','2DAW')
)
BEGIN
    INSERT INTO ALUMNO (nombre, curso) VALUES (p_nombre, p_curso);
END$$

DELIMITER ;



-- Crear la tabla 'alumno' con más datos de ejemplo
CREATE TABLE ALUMNO (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    curso ENUM('1DAM', '1DAW', '2DAM', '2DAW')
) ENGINE=InnoDB;

-- Crear la tabla 'modulo' con diferentes módulos
CREATE TABLE MODULO(
    codigo VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(20)
) ENGINE=InnoDB;

-- Crear la tabla 'nota' que registra la nota de cada alumno en cada módulo
CREATE TABLE NOTA(
    alumno INT,
    modulo VARCHAR(10),
    nota INT,
    PRIMARY KEY(alumno, modulo),
    FOREIGN KEY (alumno) REFERENCES ALUMNO(id),
    FOREIGN KEY (modulo) REFERENCES MODULO(codigo)
) ENGINE=InnoDB;

-- Insertar datos de ejemplo en la tabla 'alumno'
INSERT INTO ALUMNO (id, nombre, curso) VALUES 
    (NULL, 'Pedro Pascual', '2DAM'),
    (NULL, 'Laura Gomez', '1DAM'),
    (NULL, 'Carlos Ruiz', '2DAW'),
    (NULL, 'Ana Torres', '1DAW'),
    (NULL, 'Javier Morales', '2DAM'),
    (NULL, 'Sonia Martinez', '1DAM');

-- Insertar datos de ejemplo en la tabla 'modulo'
INSERT INTO MODULO (codigo, nombre) VALUES 
    ('AD', 'Acceso a datos'),
    ('BD', 'Bases de datos'),
    ('PROG', 'Programacion'),
    ('PSP', 'Servicios y Procesos'),
    ('SI', 'Sis informaticos');

-- Insertar datos de ejemplo en la tabla 'notas'
INSERT INTO NOTA (alumno, modulo, nota) VALUES 
    (1, 'AD', 10),
    (1, 'BD', 9),
    (2, 'PROG', 8),
    (2, 'SI', 7),
    (3, 'PSP', 6),
    (4, 'AD', 5),
    (4, 'PROG', 9),
    (5, 'SI', 8),
    (5, 'BD', 6),
    (6, 'PSP', 9),
    (1, 'SI', 8),
    (3, 'BD', 7);
