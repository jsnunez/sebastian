package application;

import domain.entity.persons;
import domain.service.UserService;

public class CreatePersonUseCase {
    private final UserService userService;

    public CreatePersonUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(persons user) {
        userService.createUser(user);
    }

    
}
