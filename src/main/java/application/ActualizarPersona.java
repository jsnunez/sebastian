package application;

import domain.entity.persons;
import domain.service.PersonaService;

public class ActualizarPersona {
    private final PersonaService userpersons;

    public ActualizarPersona(PersonaService userpersons) {
        this.userpersons = userpersons;
    }

    public void execute(persons persona) {
userpersons.actualizarPersona(persona);
    }

}
