package infrastructure.out;

import infrastructure.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void asignarHabilidad(persons persona, Habilidad habilidad,String fecha) {

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
        }
    }

    @Override
    public void deletePerson(int id) {
    String sql = "DELETE FROM persons WHERE id = ?";
    int rowsUpdate = 0;

    try (Connection connection = DatabaseConfig.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {

    statement.setInt(1, id);
    rowsUpdate = statement.executeUpdate();

    System.out.println("Número de filas eliminadas: " + rowsUpdate);

    } catch (SQLException e) {
    e.printStackTrace();
    }

}

    @Override
    public void actualizarPersona(persons persona) {
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
    }  }



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

    

 

 

}