package com.assignment3.dbDataSQL;


import com.assignment3.entities.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PatientSQL {
    private static final Logger LOGGER = Logger.getLogger(PatientSQL.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String selectAll = "Select * from patient";
    private final static String findStatementString = "SELECT * FROM patient where id_patient = ?";

    public ArrayList<Patient> selectAll() {
        Patient toReturn = null;
        ArrayList<Patient> lista = new ArrayList<Patient>();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_patient");
                String address = resultSet.getString("patient_address");
                String email = resultSet.getString("patient_email");
                Date birthdate = resultSet.getDate("patient_birthdate");
                String gender = resultSet.getString("patient_gender");
                String password = resultSet.getString("patient_password");
                String name = resultSet.getString("patient_name");
                String surname = resultSet.getString("patient_surname");
                int caregiverID = resultSet.getInt("caregiver_id_caregiver");
                toReturn = new Patient(id, name, surname, gender, birthdate, address);
                lista.add(toReturn);
            }
            System.out.println(lista);
        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return lista;
    }


}