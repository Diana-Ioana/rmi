package com.assignment3.server;
// Creating a Search interface
import com.assignment3.entities.MedicationPlan;
import java.rmi.*;
public interface Search extends Remote
{
    // Declaring the method prototype
    public String query(String search) throws RemoteException;
    public MedicationPlan findMedicationPlan(int pacientID) throws RemoteException;
}