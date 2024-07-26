package application;

import domain.service.PersonaService;

public class DeletePersonUserCase {
    private final PersonaService userService;

    public DeletePersonUserCase(PersonaService userService) {
        this.userService = userService;
    }
 public void execute(int id) {
    userService.deletePerson(id); }
    

}
