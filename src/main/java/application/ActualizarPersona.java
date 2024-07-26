package application;

import domain.entity.persons;
import domain.service.PersonaService;

public class ActualizarPersona {
    private final PersonaService userService;

    public ActualizarPersona(PersonaService userService) {
        this.userService = userService;
    }

    public void execute(persons persona) {
userService.actualizarPersona(persona);
    }

}
