package application;

import domain.entity.persons;
import domain.service.PersonaService;

public class CreatePersonUseCase {
    private final PersonaService userService;

    public CreatePersonUseCase(PersonaService userService) {
        this.userService = userService;
    }

    public void execute(persons user) {
        userService.createUser(user);
    }

    
}
