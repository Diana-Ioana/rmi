package com.assignment3.server;
// Java program to implement the Search interface

import com.assignment3.entities.MedicationPlan;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class SearchQuery extends UnicastRemoteObject
        implements Search {
    // Default constructor to throw RemoteException
    // from its parent constructor
    SearchQuery() throws RemoteException {
        super();
    }


    ArrayList<MedicationPlan> meds = new ArrayList<MedicationPlan>();

    // Implementation of the query interface
    public String query(String search)
            throws RemoteException {
        String result;
        if (search.equals("Reflection in Java"))
            result = "Found";
        else
            result = "Not Found";

        return result;
    }

    @Override
    public MedicationPlan findMedicationPlan(int pacientID) throws RemoteException {

        for (MedicationPlan med : meds) {
            if (med.getPatient_idPatient()==(pacientID)) {
                return med;
            }
        }
        return null;
    }


}