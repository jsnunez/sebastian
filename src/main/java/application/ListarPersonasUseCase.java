package application;

import java.util.List;
import java.util.ArrayList;

import domain.entity.persons;
import domain.service.PersonaService;

public class ListarPersonasUseCase {
    private final PersonaService userService;

    public ListarPersonasUseCase(PersonaService userService) {
        this.userService = userService;
    }

    public List<persons> execute(int id) {
        return userService.listarPersonas(id);
 
    }

}
