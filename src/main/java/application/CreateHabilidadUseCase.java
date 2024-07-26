package application;

import domain.entity.Habilidad;
import domain.service.PersonaService;

public class CreateHabilidadUseCase {
    private final PersonaService userpersons;

    public CreateHabilidadUseCase(PersonaService userpersons) {
        this.userpersons = userpersons;
    }
 public void execute(Habilidad habilidad) {
        userpersons.createHabilidad(habilidad);
    }

}
