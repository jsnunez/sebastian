package application;

import domain.entity.Habilidad;
import domain.service.PersonaService;

public class CreateHabilidadUseCase {
    private final PersonaService userService;

    public CreateHabilidadUseCase(PersonaService userService) {
        this.userService = userService;
    }
 public void execute(Habilidad habilidad) {
        userService.createHabilidad(habilidad);
    }

}
