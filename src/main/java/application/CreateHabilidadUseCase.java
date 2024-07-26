package application;

import domain.entity.Habilidad;
import domain.service.UserService;

public class CreateHabilidadUseCase {
    private final UserService userService;

    public CreateHabilidadUseCase(UserService userService) {
        this.userService = userService;
    }
 public void execute(Habilidad habilidad) {
        userService.createHabilidad(habilidad);
    }

}
