package sv.edu.udb.repository;

import sv.edu.udb.Ocupacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OcupacionRepository {

    private Connection connection;

    public OcupacionRepository(Connection connection) {
        this.connection = connection;
    }

    // CREATE: Agregar una nueva ocupación
    public void agregarOcupacion(Ocupacion ocupacion) throws SQLException {
        String sql = "INSERT INTO ocupaciones (nombre_ocupacion) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, ocupacion.getNombreOcupacion());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ocupacion.setIdOcupacion(generatedKeys.getInt(1));
                }
            }
        }
    }

    // READ: Obtener una ocupación por su ID
    public Ocupacion obtenerOcupacionPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ocupaciones WHERE id_ocupacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ocupacion(
                            rs.getInt("id_ocupacion"),
                            rs.getString("nombre_ocupacion")
                    );
                }
                return null;
            }
        }
    }

    // READ: Obtener todas las ocupaciones
    public List<Ocupacion> obtenerTodasLasOcupaciones() throws SQLException {
        List<Ocupacion> ocupaciones = new ArrayList<>();
        String sql = "SELECT * FROM ocupaciones";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ocupaciones.add(new Ocupacion(
                            rs.getInt("id_ocupacion"),
                            rs.getString("nombre_ocupacion")
                    ));
                }
            }
        }
        return ocupaciones;
    }

    // UPDATE: Actualizar una ocupación
    public void actualizarOcupacion(Ocupacion ocupacion) throws SQLException {
        String sql = "UPDATE ocupaciones SET nombre_ocupacion = ? WHERE id_ocupacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ocupacion.getNombreOcupacion());
            stmt.setInt(2, ocupacion.getIdOcupacion());
            stmt.executeUpdate();
        }
    }

    // DELETE: Eliminar una ocupación por su ID
    public void eliminarOcupacion(int id) throws SQLException {
        String sql = "DELETE FROM ocupaciones WHERE id_ocupacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
