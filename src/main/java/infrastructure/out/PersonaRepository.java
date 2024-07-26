package infrastructure.out;

import infrastructure.config.DatabaseConfig;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.entity.Habilidad;
import domain.entity.persons;
import domain.service.PersonaService;

public class PersonaRepository implements PersonaService {

    @Override
    public void createUser(persons persona) {
        String sql = "INSERT INTO persons (name, lastname,idcity,adddress,age,email,idgender) VALUES (?, ?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, persona.getName());
            statement.setString(2, persona.getLastname());

            statement.setInt(3, persona.getIdcity());

            statement.setString(4, persona.getAddress());

            statement.setInt(5, persona.getAge());
            statement.setString(6, persona.getEmail());
            statement.setInt(7, persona.getIdgender());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persona.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createHabilidad(Habilidad habilidad) {



        String sql1 = "select name from skill where name= ?;";
        int validar=0;
                try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql1)) {
         
             statement.setString(1,habilidad.getName());
             try (ResultSet resultSet = statement.executeQuery()) {
             if (resultSet.next()) {
        validar=1;
        JOptionPane.showMessageDialog(null, "skill ya existe  intente otra", "agregar usuario", 1);

             }
             else{
        validar=0;
             }
             }
         System.out.println(validar);
             } catch (SQLException e) {
             e.printStackTrace();
             }
if (validar==0) {

        String sql = "INSERT INTO skill (name) VALUES (?)";
        System.out.println(habilidad.getName());
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, habilidad.getName());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    habilidad.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    }

    @Override
    public void asignarHabilidad(persons persona, Habilidad habilidad,String fecha) {

        String sql1 = "select name from skill where id= ?;";
int validar=0;
        try (Connection connection = DatabaseConfig.getConnection();
     PreparedStatement statement = connection.prepareStatement(sql1)) {
 
     statement.setLong(1, habilidad.getId());
     try (ResultSet resultSet = statement.executeQuery()) {
     if (resultSet.next()) {
validar=1;
     }
     else{
validar=0;
JOptionPane.showMessageDialog(null, "no se encontro skill", "agregar usuario", 1);
     }
     }
 System.out.println(validar);
     } catch (SQLException e) {
     e.printStackTrace();
     }
int validaduser=0;
     String sql2 = "select name from persons where id= ?;";
             try (Connection connection = DatabaseConfig.getConnection();
          PreparedStatement statement = connection.prepareStatement(sql1)) {
      
          statement.setLong(1, persona.getId());
          try (ResultSet resultSet = statement.executeQuery()) {
          if (resultSet.next()) {
            validaduser=1;
          }
          else{
            validaduser=0;
            JOptionPane.showMessageDialog(null, "no se encontro usuario", "agregar usuario", 1);

          }
          }
      System.out.println(validar);
          } catch (SQLException e) {
          e.printStackTrace();
          }
if (validar==1 & validaduser==1) {
    

        String sql = "INSERT INTO persons_skill (registration_date,iperson,idskill) VALUES (?,?,?)";
        System.out.println(habilidad.getName());
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, fecha);
            statement.setInt(2, persona.getId());
            statement.setInt(3, habilidad.getId());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    habilidad.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }}
        else{
            JOptionPane.showMessageDialog(null, "no se pudo asiganr el skill al usuario", "agregar usuario", 1);

        }
    }

    @Override
    public void deletePerson(int id) {


        String sql1 = "select id from persons where id= ?;";
        int validar=0;
                try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql1)) {
         
             statement.setInt(1,id);
             try (ResultSet resultSet = statement.executeQuery()) {
             if (resultSet.next()) {
        validar=1;

             }
             else{
        validar=0;
        JOptionPane.showMessageDialog(null, "usuario no existe", "agregar usuario", 1);

             }
             }
         System.out.println(validar);
             } catch (SQLException e) {
             e.printStackTrace();
             }
if (validar==1) {
    

        String sql = "DELETE FROM persons_skill WHERE iperson = ?";
    int rowsUpdate = 0;

    try (Connection connection = DatabaseConfig.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {

    statement.setInt(1, id);
    rowsUpdate = statement.executeUpdate();

    System.out.println("Número de filas eliminadas: " + rowsUpdate);

    } catch (SQLException e) {
    e.printStackTrace();
    }
    String sql2 = "DELETE FROM persons WHERE id = ?";
    int rowsUpdate2 = 0;

    try (Connection connection = DatabaseConfig.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql2)) {

    statement.setInt(1, id);
    rowsUpdate2 = statement.executeUpdate();

    System.out.println("Número de filas eliminadas: " + rowsUpdate);

    } catch (SQLException e) {
    e.printStackTrace();
    }
}
}

    @Override
    public void actualizarPersona(persons persona) {

        String sql1 = "select id from persons where id= ?;";
        int validar=0;
                try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql1)) {
         
             statement.setInt(1,persona.getId());
             try (ResultSet resultSet = statement.executeQuery()) {
             if (resultSet.next()) {
        validar=1;

             }
             else{
        validar=0;
        JOptionPane.showMessageDialog(null, "usuario no existe", "agregar usuario", 1);

             }
             }
         System.out.println(validar);
             } catch (SQLException e) {
             e.printStackTrace();
             }
if (validar==1) {
    

        String sql = 
       " UPDATE persons SET name = ?,lastname=?,idcity=?,adddress=?,age=?,email=?,idgender=? WHERE id = ?;";

    try (Connection connection = DatabaseConfig.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {

    statement.setString(1, persona.getName());
    statement.setString(2, persona.getLastname());
    statement.setInt(3, persona.getIdcity());
    statement.setString(4, persona.getAddress());
    statement.setInt(5, persona.getAge());
    statement.setString(6, persona.getEmail());
    statement.setInt(7, persona.getIdgender());
    statement.setInt(8, persona.getId());


    int rowsUpdate = statement.executeUpdate();
    System.out.println("Numero de filas actualizadas " + rowsUpdate);

    } catch (SQLException e) {
    e.printStackTrace();
    }  }}



    @Override
    public List<persons> listarPersonas(int id) {
       
        List<persons> listaPersonas= new ArrayList<>();
       String sql = "select p.name,p.lastname from persons p join persons_skill ps  on p.id=ps.iperson where ps.idskill =? ;";
       persons persona = null;
    try (Connection connection = DatabaseConfig.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {

    statement.setLong(1, id);
    try (ResultSet resultSet = statement.executeQuery()) {
    while (resultSet.next()) {
    persona = new persons();
    persona.setName(resultSet.getString("p.name"));
    persona.setLastname(resultSet.getString("p.lastname"));
    listaPersonas.add(persona);
    }
    }

    } catch (SQLException e) {
    e.printStackTrace();
    }
    return listaPersonas;
  }

    @Override
    public List<String> listarCiudades() {
        List<String> listaCiudades= new ArrayList<>();
        String sql = "select name from city c ;";
     try (Connection connection = DatabaseConfig.getConnection();
     PreparedStatement statement = connection.prepareStatement(sql)) {
 
     try (ResultSet resultSet = statement.executeQuery()) {
     while (resultSet.next()) {
   String ciudad=(resultSet.getString("name"));
   System.out.println(ciudad);
     listaCiudades.add(ciudad);
     }
     }
 
     } catch (SQLException e) {
     e.printStackTrace();
     }
     return listaCiudades;   }

    

 

 

}