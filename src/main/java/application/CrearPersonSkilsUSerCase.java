package application;

import domain.entity.Habilidad;
import domain.entity.persons;
import domain.service.PersonaService;

public class CrearPersonSkilsUSerCase {
    private final PersonaService userService;

    public CrearPersonSkilsUSerCase(PersonaService userService) {
        this.userService = userService;
    }
     public void execute(persons persona,Habilidad habilidad,String fecha) {
        userService.asignarHabilidad(persona,habilidad,fecha);
    }

}
