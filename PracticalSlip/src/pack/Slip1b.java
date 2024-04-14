package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip1b extends JFrame implements ActionListener {
    JLabel lblEno, lblEName, lblDesignation, lblSalary;
    JTextField txtEno, txtEName, txtDesignation, txtSalary;
    JButton btnSave;

    public void EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblEno = new JLabel("Employee No:");
        lblEName = new JLabel("Employee Name:");
        lblDesignation = new JLabel("Designation:");
        lblSalary = new JLabel("Salary:");

        txtEno = new JTextField();
        txtEName = new JTextField();
        txtDesignation = new JTextField();
        txtSalary = new JTextField();

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);

        add(lblEno);
        add(txtEno);
        add(lblEName);
        add(txtEName);
        add(lblDesignation);
        add(txtDesignation);
        add(lblSalary);
        add(txtSalary);
        add(new JLabel()); // Placeholder
        add(btnSave);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveEmployeeDetails();
        }
    }

    private void saveEmployeeDetails() {
        String eno = txtEno.getText();
        String eName = txtEName.getText();
        String designation = txtDesignation.getText();
        String salary = txtSalary.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            String query = "INSERT INTO employee (Eno, EName, Designation, Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, eno);
            pstmt.setString(2, eName);
            pstmt.setString(3, designation);
            pstmt.setString(4, salary);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee details saved successfully.");
            
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Slip1b();
            }
        });
    }
}
