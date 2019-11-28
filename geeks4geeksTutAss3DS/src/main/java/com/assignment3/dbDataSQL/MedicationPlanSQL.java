package com.assignment3.dbDataSQL;

import com.assignment3.entities.Medication;
import com.assignment3.entities.MedicationPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MedicationPlanSQL {
    private static final Logger LOGGER = Logger.getLogger(MedicationPlanSQL.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public MedicationPlan printAllMedicationPlansForPatientId(int patient_id) {
        MedicationPlan currentMedicationPlan = new MedicationPlan();
        String query = "SELECT * FROM medication_plan where id_patient = ?";
        List<Medication> medicationList = new ArrayList();
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
            PreparedStatement findStatement = connection.prepareStatement(query);
            findStatement.setInt(1, patient_id);
            ResultSet resultSet = findStatement.executeQuery();
            while (resultSet.next()) {
                int id_medication_plan = resultSet.getInt("id_medication_plan");
                Date end_date = resultSet.getDate("end_date");
                Date start_date = resultSet.getDate("start_date");
                currentMedicationPlan.setIdMedicationPlan(id_medication_plan);
                currentMedicationPlan.setEndDate(end_date);
                currentMedicationPlan.setStartDate(start_date);
                currentMedicationPlan.setPatient_idPatient(patient_id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return currentMedicationPlan;
    }


}
