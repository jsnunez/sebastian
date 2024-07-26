package infrastructure.in;

import javax.swing.*;
import java.awt.*;

import application.CreateHabilidadUseCase;
import application.CreatePersonUseCase;
import domain.entity.Habilidad;
import domain.entity.persons;

public class UserController {
    private final CreatePersonUseCase createUserUseCase;
    private final CreateHabilidadUseCase createHabilidadUseCase;


    public UserController(CreatePersonUseCase createUserUseCase, CreateHabilidadUseCase createHabilidadUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.createHabilidadUseCase = createHabilidadUseCase;
    }


    public void start() {

        JPanel menu = new JPanel(new GridLayout(0, 1));

        menu.add(new JLabel("seleccione opcion:"));
        menu.add(new JLabel("1: Registrar una Persona:"));
        menu.add(new JLabel("2: Asignar una Habilidad a una Persona:"));
        menu.add(new JLabel("3: Crear una Nueva Habilidad:"));
        menu.add(new JLabel("4: Consultar Personas por Habilidad:"));
        menu.add(new JLabel("5: Actualizar Información de una Persona:"));
        menu.add(new JLabel("6: Eliminar una Persona:"));

   

        JTextField opcion = new JTextField();
        menu.add(opcion);

        int seleccion = JOptionPane.showConfirmDialog(null, menu, "Tipo Usuario",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

if (seleccion == JOptionPane.OK_OPTION) {
    if (opcion.getText().equals("1")) {
        JPanel panelUsuario = new JPanel(new GridLayout(0, 2));

    panelUsuario.add(new JLabel("nombre:"));
    JTextField nombre = new JTextField();
    panelUsuario.add(nombre);

    panelUsuario.add(new JLabel("apellido:"));
    JTextField apellido = new JTextField();
    panelUsuario.add(apellido);

    panelUsuario.add(new JLabel("idCiudad:"));
    JTextField idciudad = new JTextField();
    panelUsuario.add(idciudad);

    panelUsuario.add(new JLabel("address:"));
    JTextField address = new JTextField();
    panelUsuario.add(address);


    panelUsuario.add(new JLabel("age:"));
    JTextField age = new JTextField();
    panelUsuario.add(age);

    panelUsuario.add(new JLabel("email:"));
    JTextField email = new JTextField();
    panelUsuario.add(email);

    panelUsuario.add(new JLabel("idgenero:"));
    JTextField idgenero = new JTextField();
    panelUsuario.add(idgenero);

int result = JOptionPane.showConfirmDialog(null, panelUsuario, "Tipo Usuario",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

if (result == JOptionPane.OK_OPTION) {
persons persona = new persons();
persona.setName(nombre.getText());
persona.setLastname(apellido.getText());
persona.setIdcity(Integer.parseInt(idciudad.getText()));
persona.setAddress(address.getText());
persona.setAge(Integer.parseInt(age.getText()));
persona.setEmail(email.getText());
persona.setIdgender(Integer.parseInt(idgenero.getText()));

createUserUseCase.execute(persona);

}
    }
    
if(opcion.getText().equals("2")){


}
if(opcion.getText().equals("3")){

    JPanel habilidades = new JPanel(new GridLayout(0, 1));

    habilidades.add(new JLabel("ingrese nombre nueva habilidad:"));
    JTextField nombreHabilidad = new JTextField();
    habilidades.add(nombreHabilidad);

    int result = JOptionPane.showConfirmDialog(null, habilidades, "Tipo Usuario",
    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    Habilidad habilidad = new Habilidad();
    habilidad.setName(nombreHabilidad.getText());
    if (result  == JOptionPane.OK_OPTION) {

        createHabilidadUseCase.execute(habilidad);
    }
}
if(opcion.getText().equals("4")){

    
}
if(opcion.getText().equals("5")){

    
}if(opcion.getText().equals("6")){

    
}
}

      
}}

