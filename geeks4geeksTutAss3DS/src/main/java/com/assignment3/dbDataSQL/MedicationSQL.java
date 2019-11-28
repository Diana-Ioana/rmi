package com.assignment3.dbDataSQL;

import com.assignment3.entities.Medication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MedicationSQL {
    private static final Logger LOGGER = Logger.getLogger(MedicationSQL.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<Medication> printAllMedicationsForPatientId(int medication) {
        String query = "SELECT * FROM medication where medication_id_medication = ?";
        List<Medication> medicationList = new ArrayList();
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            PreparedStatement findStatement = connection.prepareStatement(query);
            findStatement.setInt(1, medication);
            ResultSet resultSet = findStatement.executeQuery();
            while (resultSet.next()) {
                Medication currentMedication = new Medication();
                int idmedication = resultSet.getInt("idmedication");
                String dosage = resultSet.getString("dosage");
                int intokeInterval = resultSet.getInt("intake_intervals");
                String medicationName = resultSet.getString("medication_name");
                int medication_id_medication = resultSet.getInt(medication);
                String sideEffects = resultSet.getString("side_effects");
                currentMedication.setIdmedication(idmedication);
                currentMedication.setDosage(dosage);
                currentMedication.setIntakeIntervals(intokeInterval);
                currentMedication.setMedication_idMedication(medication_id_medication);
                currentMedication.setMedicationName(medicationName);
                currentMedication.setSideEffects(sideEffects);
                medicationList.add(currentMedication);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return medicationList;
    }
}
