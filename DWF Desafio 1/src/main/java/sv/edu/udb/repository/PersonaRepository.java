package sv.edu.udb.repository;

import sv.edu.udb.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private Connection connection;

    public PersonaRepository(Connection connection) {
        this.connection = connection;
    }

    // CREATE: Agregar una nueva persona
    public void agregarPersona(Persona persona) throws SQLException {
        String sql = "INSERT INTO persona (nombre_persona, edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, persona.getNombrePersona());
            stmt.setInt(2, persona.getEdadPersona());
            stmt.setString(3, persona.getTelefonoPersona());
            stmt.setString(4, persona.getSexoPersona());
            stmt.setInt(5, persona.getIdOcupacion());
            stmt.setDate(6, new java.sql.Date(persona.getFechaNac().getTime()));
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persona.setIdPersona(generatedKeys.getInt(1));
                }
            }
        }
    }

    // READ: Obtener una persona por su ID
    public Persona obtenerPersonaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM persona WHERE id_persona = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Persona(
                            rs.getInt("id_persona"),
                            rs.getString("nombre_persona"),
                            rs.getInt("edad_persona"),
                            rs.getString("telefono_persona"),
                            rs.getString("sexo_persona"),
                            rs.getInt("id_ocupacion"),
                            rs.getDate("fecha_nac")
                    );
                }
                return null;
            }
        }
    }

    // READ: Obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    personas.add(new Persona(
                            rs.getInt("id_persona"),
                            rs.getString("nombre_persona"),
                            rs.getInt("edad_persona"),
                            rs.getString("telefono_persona"),
                            rs.getString("sexo_persona"),
                            rs.getInt("id_ocupacion"),
                            rs.getDate("fecha_nac")
                    ));
                }
            }
        }
        return personas;
    }

    // UPDATE: Actualizar una persona
    public void actualizarPersona(Persona persona) throws SQLException {
        String sql = "UPDATE persona SET nombre_persona = ?, edad_persona = ?, telefono_persona = ?, sexo_persona = ?, id_ocupacion = ?, fecha_nac = ? WHERE id_persona = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, persona.getNombrePersona());
            stmt.setInt(2, persona.getEdadPersona());
            stmt.setString(3, persona.getTelefonoPersona());
            stmt.setString(4, persona.getSexoPersona());
            stmt.setInt(5, persona.getIdOcupacion());
            stmt.setDate(6, new java.sql.Date(persona.getFechaNac().getTime()));
            stmt.setInt(7, persona.getIdPersona());
            stmt.executeUpdate();
        }
    }

    // DELETE: Eliminar una persona por su ID
    public void eliminarPersona(int id) throws SQLException {
        String sql = "DELETE FROM persona WHERE id_persona = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
