package pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Slip27a extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public Slip27a() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table model with columns
        String[] columns = {"CID", "CName", "Address", "Year"};
        tableModel = new DefaultTableModel(columns, 0);

        // Create a table with the model
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Populate table with dummy data
        addCollegeDetails("101", "ABC College", "123 Main St", "2022");
        addCollegeDetails("102", "XYZ College", "456 Oak Ave", "2021");
    }

    private void addCollegeDetails(String cid, String cname, String address, String year) {
        Object[] rowData = {cid, cname, address, year};
        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CollegeDetails collegeDetails = new CollegeDetails();
                collegeDetails.setVisible(true);
            }
        });
    }
}
