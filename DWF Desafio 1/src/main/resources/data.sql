-- Insertar datos en la tabla `ocupaciones` (si es necesario)
INSERT INTO ocupaciones (nombre_ocupacion)
VALUES ('Ingeniero de Software');
INSERT INTO ocupaciones (nombre_ocupacion)
VALUES ('Diseñador Gráfico');
INSERT INTO ocupaciones (nombre_ocupacion)
VALUES ('Analista de Datos');

-- Insertar datos en la tabla `persona`
INSERT INTO persona (nombre_persona, edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac)
VALUES ('Jose', 40, '77889966', 'Masculino', 1, '1940-04-08');
INSERT INTO persona (nombre_persona, edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac)
VALUES ('Juan', 25, '77558899', 'Masculino', 2, '1990-05-20');
INSERT INTO persona (nombre_persona, edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac)
VALUES ('Emerson', 25, '76150644', 'Masculino', 3, '1999-03-08');
