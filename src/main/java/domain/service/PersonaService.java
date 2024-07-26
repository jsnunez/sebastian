package domain.service;


import domain.entity.Habilidad;
import domain.entity.persons;

public interface PersonaService {
    void createUser(persons user);
    void createHabilidad(Habilidad habilidad);
    void asignarHabilidad(persons persona, Habilidad habilidad, String fecha);
    void deletePerson(int id);
    void actualizarPersona(persons persona);
}
