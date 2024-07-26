package application;

import domain.entity.persons;
import domain.service.PersonaService;

public class CreatePersonUseCase {
    private final PersonaService userpersons;

    public CreatePersonUseCase(PersonaService userpersons) {
        this.userpersons = userpersons;
    }

    public void execute(persons user) {
        userpersons.createUser(user);
    }

    
}
