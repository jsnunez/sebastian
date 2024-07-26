package application;

import domain.entity.Habilidad;
import domain.entity.persons;
import domain.service.PersonaService;

public class CrearPersonSkilsUSerCase {
    private final PersonaService userpersons;

    public CrearPersonSkilsUSerCase(PersonaService userpersons) {
        this.userpersons = userpersons;
    }
     public void execute(persons persona,Habilidad habilidad,String fecha) {
        userpersons.asignarHabilidad(persona,habilidad,fecha);
    }

}
