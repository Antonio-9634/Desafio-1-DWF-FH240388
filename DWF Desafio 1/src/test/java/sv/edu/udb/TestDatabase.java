package sv.edu.udb;

import org.junit.jupiter.api.*;
import sv.edu.udb.model.Persona;
import sv.edu.udb.repository.PersonaRepository;

import java.sql.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestDatabase {

    private static Connection connection;
    private static PersonaRepository personaRepository;

    @BeforeAll
    public static void setup() throws SQLException {
        // Establecer la conexión a la base de datos H2 en memoria
        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", "sa", "");
        // Ejecutar los scripts de creación de las tablas
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("RUNSCRIPT FROM 'classpath:schema.sql'");
            stmt.execute("RUNSCRIPT FROM 'classpath:data.sql'");
        }
        personaRepository = new PersonaRepository(connection);
    }

    @Test
    public void testAgregarPersona() throws SQLException {
        // Crear una persona
        Persona persona = new Persona(0, "Juan Perez", 30, "12345678", "Masculino", 1, new Date());
        personaRepository.agregarPersona(persona);

        // Recuperar la persona insertada
        Persona personaGuardada = personaRepository.obtenerPersonaPorId(1);
        assertNotNull(personaGuardada);
        assertEquals("Juan Perez", personaGuardada.getNombre_persona());
        assertEquals(30, personaGuardada.getEdad_persona());
    }

    @Test
    public void testObtenerTodasLasPersonas() throws SQLException {
        // Agregar varias personas
        personaRepository.agregarPersona(new Persona(0, "Maria Lopez", 25, "87654321", "Femenino", 2, new Date()));
        personaRepository.agregarPersona(new Persona(0, "Carlos Sanchez", 40, "11223344", "Masculino", 3, new Date()));

        // Obtener todas las personas
        List<Persona> personas = personaRepository.obtenerTodasLasPersonas();
        assertNotNull(personas);
        assertTrue(personas.size() >= 2);
    }
}
