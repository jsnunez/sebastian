package infrastructure.in;

import javax.swing.*;
import java.awt.*;

import application.ActualizarPersona;
import application.CrearPersonSkilsUSerCase;
import application.CreateHabilidadUseCase;
import application.CreatePersonUseCase;
import application.DeletePersonUserCase;
import domain.entity.Habilidad;
import domain.entity.persons;

public class PersonaController {
    private final CreatePersonUseCase createUserUseCase;
    private final CreateHabilidadUseCase createHabilidadUseCase;
    private final CrearPersonSkilsUSerCase crearPersonSkilsUSerCase;
    private final DeletePersonUserCase deletePersonUserCase;
    private final ActualizarPersona actualizarPersona;

    public PersonaController(CreatePersonUseCase createUserUseCase, CreateHabilidadUseCase createHabilidadUseCase,
            CrearPersonSkilsUSerCase crearPersonSkilsUSerCase, DeletePersonUserCase deletePersonUserCase,
            ActualizarPersona actualizarPersona) {
        this.createUserUseCase = createUserUseCase;
        this.createHabilidadUseCase = createHabilidadUseCase;
        this.crearPersonSkilsUSerCase = crearPersonSkilsUSerCase;
        this.deletePersonUserCase = deletePersonUserCase;
        this.actualizarPersona = actualizarPersona;
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

            if (opcion.getText().equals("2")) {
                JPanel habilidades = new JPanel(new GridLayout(0, 2));

                habilidades.add(new JLabel("ingrese id persona:"));
                JTextField idpersona = new JTextField();
                habilidades.add(idpersona);
                habilidades.add(new JLabel("ingrese id habilidad:"));
                JTextField idhabilidad = new JTextField();
                habilidades.add(idhabilidad);
                habilidades.add(new JLabel("ingrese fecha aaaa-mm-dd:"));
                JTextField fecha = new JTextField();
                habilidades.add(fecha);

                int result = JOptionPane.showConfirmDialog(null, habilidades, "Tipo Usuario",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                Habilidad habilidad = new Habilidad();
                habilidad.setId(Integer.parseInt(idhabilidad.getText()));
                persons persona = new persons();
                persona.setId(Integer.parseInt(idpersona.getText()));

                if (result == JOptionPane.OK_OPTION) {

                    crearPersonSkilsUSerCase.execute(persona, habilidad, fecha.getText());
                }

            }
            if (opcion.getText().equals("3")) {

                JPanel habilidades = new JPanel(new GridLayout(0, 1));

                habilidades.add(new JLabel("ingrese nombre nueva habilidad:"));
                JTextField nombreHabilidad = new JTextField();
                habilidades.add(nombreHabilidad);

                int result = JOptionPane.showConfirmDialog(null, habilidades, "Tipo Usuario",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    Habilidad habilidad = new Habilidad();
                    habilidad.setName(nombreHabilidad.getText());
                    createHabilidadUseCase.execute(habilidad);
                }
            }
            if (opcion.getText().equals("4")) {

            }
            if (opcion.getText().equals("5")) {
                JPanel panelUsuario = new JPanel(new GridLayout(0, 2));
                panelUsuario.add(new JLabel("id a modificar:"));
                JTextField id = new JTextField();
                panelUsuario.add(id);

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

                int modif = JOptionPane.showConfirmDialog(null, panelUsuario, "id a modificar",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (modif == JOptionPane.OK_OPTION) {
                    persons persona = new persons();
                    persona.setId(Integer.parseInt(id.getText()));
                    persona.setName(nombre.getText());
                    persona.setLastname(apellido.getText());
                    persona.setIdcity(Integer.parseInt(idciudad.getText()));
                    persona.setAddress(address.getText());
                    persona.setAge(Integer.parseInt(age.getText()));
                    persona.setEmail(email.getText());
                    persona.setIdgender(Integer.parseInt(idgenero.getText()));
                    actualizarPersona.execute(persona);
                }
            }
            if (opcion.getText().equals("6")) {
                JPanel eliminarUser = new JPanel(new GridLayout(0, 1));
                eliminarUser.add(new JLabel("ingrese id persona a elimninar:"));
                JTextField idPersona = new JTextField();
                eliminarUser.add(idPersona);
                int result = JOptionPane.showConfirmDialog(null, eliminarUser, "Tipo Usuario",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    int idUser = Integer.parseInt(idPersona.getText());
                    deletePersonUserCase.execute(idUser);
                }
            }

        }
    }
}
