Proyecto: Conexión a Base de Datos y Operaciones Básicas en Java

Este proyecto es una aplicación Java que se conecta a una base de datos y realiza operaciones básicas de CRUD (Crear, Leer, Actualizar y Eliminar) sobre las tablas persona y ocupaciones. Fue desarrollado como parte de un desafío práctico para demostrar habilidades en el manejo de bases de datos y programación en Java.
🛠️ Tecnologías Utilizadas

    Java: Lenguaje de programación principal.

    JDBC: Para la conexión y manipulación de la base de datos.

    H2 Database: Base de datos en memoria utilizada para pruebas (también compatible con otras bases de datos como MySQL o PostgreSQL).

    Spring Boot: Framework para simplificar la configuración y el desarrollo de la aplicación.

    Maven: Gestión de dependencias y construcción del proyecto.

📋 Funcionalidades Implementadas

El proyecto incluye las siguientes operaciones básicas:

    Conexión a la Base de Datos: Configuración de la conexión mediante JDBC.

    Operaciones CRUD:

        Crear: Insertar nuevos registros en las tablas persona y ocupaciones.

        Leer: Obtener registros por ID o listar todos los registros.

        Actualizar: Modificar registros existentes.

        Eliminar: Borrar registros de la base de datos.

    Manejo de Relaciones: La tabla persona tiene una relación con la tabla ocupaciones mediante una clave foránea (id_ocupacion).

📂 Estructura del Proyecto

El proyecto está organizado de la siguiente manera:
src
└── main
    └── java
        └── sv
            └── edu
                └── udb
                    ├── Main.java                    # Clase principal de la aplicación
                    ├── model                        # Paquete para las entidades
                    │   ├── Persona.java             # Entidad Persona
                    │   └── Ocupacion.java           # Entidad Ocupacion
                    ├── repository                   # Paquete para los repositorios
                    │   ├── PersonaRepository.java   # Repositorio para la entidad Persona
                    │   └── OcupacionRepository.java # Repositorio para la entidad Ocupacion
                    ├── service                      # Paquete para los servicios
                         └── PersonaService.java     # Servicio para la entidad Persona
          
👨‍💻 Contribución

Este proyecto fue desarrollado de manera individual por Diego Antonio Flores Herrera (Carnet: FH240388). Mi compañero no participó en la creación del proyecto, por lo que todo el código, la documentación y la configuración fueron realizados por mí.
