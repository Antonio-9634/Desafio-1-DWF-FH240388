--
-- Tablas de la base de datos: `personabdd`
--

-- ----------------------------------------------------------------
--  TABLE PERSONA
-- ----------------------------------------------------------------
CREATE TABLE persona (
    id_persona INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre_persona VARCHAR(100) NOT NULL,
    edad_persona INT NOT NULL,
    telefono_persona VARCHAR(9) NOT NULL,
    sexo_persona VARCHAR(50) NOT NULL,
    id_ocupacion INT NOT NULL,
    fecha_nac DATE NOT NULL
);

-- ----------------------------------------------------------------
--  TABLE OCUPACIONES (si es necesario)
-- ----------------------------------------------------------------
CREATE TABLE ocupaciones (
    id_ocupacion INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre_ocupacion VARCHAR(100) NOT NULL
);

-- ----------------------------------------------------------------
--  FOREIGN KEY PARA PERSONA
-- ----------------------------------------------------------------
ALTER TABLE persona
ADD CONSTRAINT fk_persona_ocupacion
FOREIGN KEY (id_ocupacion) REFERENCES ocupaciones(id_ocupacion);
