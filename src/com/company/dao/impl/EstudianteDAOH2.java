package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class EstudianteDAOH2 implements IDao {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_estudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Estudiante guardar(Estudiante estudiante) {

        Connection connection = null;

        // 1-levantar el driver y la coneccion

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        // 2- Crear una sentencia

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setInt(1, estudiante.getId());
            preparedStatement.setString(2,estudiante.getNombre());
            preparedStatement.setString(3,estudiante.getApellido());

        // 3- ejecutar la sentencia

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return estudiante;

    }


    @Override
    public void eliminar(Long id) {

        Connection connection = null;

        // 1-levantar el driver y la coneccion

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2- Crear una sentencia

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE id= ?");
            preparedStatement.setInt(1, id);

            // 3- ejecutar la sentencia

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante buscar(Long id) {

        Connection connection = null;

        // 1-levantar el driver y la coneccion

        Estudiante estudiante = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2- Crear una sentencia

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE id= ?");
            preparedStatement.setInt(1, id);


            // 3- ejecutar la sentencia

            ResultSet resultSet = preparedStatement.executeQuery();

            // 4- evaluar los resultados

            while (resultSet.next()) {
                Long idEstudiante = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                estudiante = new Estudiante();
                estudiante.setId(id);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

            }
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection = null;

        // 1-levantar el driver y la coneccion
        List<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2- Crear una sentencia

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE id= ?");
            preparedStatement.setInt(1, id);


            // 3- ejecutar la sentencia

            ResultSet resultSet = preparedStatement.executeQuery();

            // 4- evaluar los resultados

            while (resultSet.next()) {
                Long idEstudiante = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                estudiante = new Estudiante();
                estudiante.setId(id);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiantes.add(estudiante);

            }
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
}
