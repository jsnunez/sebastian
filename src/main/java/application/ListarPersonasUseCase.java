package application;

import java.util.List;
import domain.entity.persons;
import domain.service.PersonaService;

public class ListarPersonasUseCase {
    private final PersonaService userpersons;

    public ListarPersonasUseCase(PersonaService userpersons) {
        this.userpersons = userpersons;
    }

    public List<persons> execute(int id) {
        return userpersons.listarPersonas(id);
 
    }

}
