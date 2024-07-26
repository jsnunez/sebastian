package application;

import java.util.List;

import domain.service.PersonaService;

public class ListarCiudades {

    private final PersonaService userpersons;

    public ListarCiudades(PersonaService userpersons) {
        this.userpersons = userpersons;
    }
      public List<String> execute() {
        return userpersons.listarCiudades();
        
      }


}
