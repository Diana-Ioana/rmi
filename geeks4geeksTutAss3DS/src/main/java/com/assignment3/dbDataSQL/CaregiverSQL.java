package com.assignment3.dbDataSQL;

import com.assignment3.entities.Caregiver;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CaregiverSQL {
    private static final Logger LOGGER = Logger.getLogger(CaregiverSQL.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String selectAll = "Select * from Caregiver";
    private final static String findStatementString = "SELECT * FROM caregiver where id_caregiver = ?";

    public ArrayList<Caregiver> selectAll() {
        Caregiver toReturn = null;
        ArrayList<Caregiver> lista = new ArrayList<Caregiver>();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_caregiver");
                String address = resultSet.getString("caregiver_address");
                String email = resultSet.getString("caregiver_email");
                Date birthdate = resultSet.getDate("caregiver_birthdate");
                String gender = resultSet.getString("caregiver_gender");
                String password = resultSet.getString("caregiver_password");
                String name = resultSet.getString("caregiver_name");
                String surname = resultSet.getString("caregiver_surname");
                toReturn = new Caregiver(id, name, surname, gender, address, birthdate);
                lista.add(toReturn);
            }
            System.out.println(lista);
        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return lista;
    }
}