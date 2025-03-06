package sv.edu.udb.service;

import sv.edu.udb.Persona;
import sv.edu.udb.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Método para agregar una persona
    public void agregarPersona(Persona persona) throws SQLException {
        personaRepository.agregarPersona(persona);
    }

    // Método para obtener una persona por su ID
    public Persona obtenerPersonaPorId(int id) throws SQLException {
        return personaRepository.obtenerPersonaPorId(id);
    }

    // Método para obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() throws SQLException {
        return personaRepository.obtenerTodasLasPersonas();
    }

    // Método para actualizar una persona
    public void actualizarPersona(Persona persona) throws SQLException {
        personaRepository.actualizarPersona(persona);
    }

    // Método para eliminar una persona por su ID
    public void eliminarPersona(int id) throws SQLException {
        personaRepository.eliminarPersona(id);
    }
}
