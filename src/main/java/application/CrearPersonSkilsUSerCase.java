package application;

import domain.entity.Habilidad;
import domain.entity.persons;
import domain.service.UserService;

public class CrearPersonSkilsUSerCase {
    private final UserService userService;

    public CrearPersonSkilsUSerCase(UserService userService) {
        this.userService = userService;
    }
     public void execute(persons persona,Habilidad habilidad,String fecha) {
        userService.asignarHabilidad(persona,habilidad,fecha);
    }

}
