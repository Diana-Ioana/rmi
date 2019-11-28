package com.assignment3.client;
//program for client application
import com.assignment3.server.Search;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.*;
public class ClientRequest
{
    public static void main(String args[])
    {
        String answer,value="Reflection in Java";
        try
        {
            // lookup method to find reference of remote object
            Search access =
                    (Search)Naming.lookup("rmi://localhost:1900"+
                            "/assignmet3");
            answer = access.query(value);
            // creating instance of JFrame
            JFrame f = new JFrame();
            f.setTitle("Medication Plan");
            // creating instance of JButton
            JButton b = new JButton("Click me!");
            b.setBounds(50,50,10,10);
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello world!");
                }
            });

            String[] columnNames = {"Medication Name",
                    "Intake intervals",
                    "dosage",
                    "Start hour"};

            Object[][] data = {
                    {"Aspirina", "8",
                            "3", new Integer(5)},
                    {"Antihistaminice", "6",
                            "4", new Integer(3)},
                    {"Augumentin", "12",
                            "2", new Integer(2)},
                    {"Parasinus", "8",
                            "3", new Integer(10)},
                    {"Paracetamol", "8",
                            "3", new Integer(10)}
            };
            JTable table = new JTable(data, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            scrollPane.setBounds(0,0,40,40);

            f.setSize(400, 500);
            f.add(scrollPane);
            f.add(b);




            // make the frame visible
            f.setVisible(true);


        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}