package pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip12b extends JFrame {
    private Connection connection;
    private DefaultTableModel tableModel;
    private JTable table;

    public Slip12b() {
        setTitle("Project Details");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Connect to the database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Project ID");
        tableModel.addColumn("Project Name");
        tableModel.addColumn("Project Description");
        tableModel.addColumn("Project Status");

        // Create a table
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Button to fetch and display data
        JButton fetchButton = new JButton("Fetch Data");
        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayData();
            }
        });

        // Panel to hold the fetch button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fetchButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void fetchAndDisplayData() {
        try {
            // Clear the table
            tableModel.setRowCount(0);

            // Fetch data from the database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PROJECT");

            // Add fetched data to the table model
            while (resultSet.next()) {
                String projectId = resultSet.getString("project_id");
                String projectName = resultSet.getString("Project_name");
                String projectDescription = resultSet.getString("Project_description");
                String projectStatus = resultSet.getString("Project_Status");

                tableModel.addRow(new Object[]{projectId, projectName, projectDescription, projectStatus});
            }

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Slip12b projectDetails = new Slip12b();
                projectDetails.setVisible(true);
            }
        });
    }
}
