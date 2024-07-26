package application;

import domain.service.PersonaService;

public class DeletePersonUserCase {
    private final PersonaService userpersons;

    public DeletePersonUserCase(PersonaService userpersons) {
        this.userpersons = userpersons;
    }
 public void execute(int id) {
    userpersons.deletePerson(id); }
    

}
