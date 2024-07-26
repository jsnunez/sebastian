package domain.service;


import domain.entity.Habilidad;
import domain.entity.persons;

public interface UserService {
    void createUser(persons user);
    void createHabilidad(Habilidad habilidad);
}
