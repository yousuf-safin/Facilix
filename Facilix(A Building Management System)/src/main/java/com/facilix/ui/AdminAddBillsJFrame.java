/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.facilix.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @Yousuf
 */
public class AdminAddBillsJFrame extends javax.swing.JFrame {

    private String selectedFlat = "101";
    
    /**
     * Creates new form AdminAddBillsJFrame
     */
    public AdminAddBillsJFrame() {
        initComponents();
        populateFlatComboBox();
    }
    
    private void populateFlatComboBox() {
        flatComboBox.removeAllItems(); // Clear existing items
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT Id FROM Flats");

            while (resultSet.next()) {
                String flatName = resultSet.getString("Id");
                flatComboBox.addItem(flatName);
            }

            resultSet.close();
            statement.close();
            
            PreparedStatement flatOwnerStatement = connection.prepareStatement("SELECT Username FROM Users WHERE Id = (SELECT OwnerUserId FROM Flats WHERE Id = ?)");
            flatOwnerStatement.setString(1, selectedFlat);
            ResultSet flatOwnerResult = flatOwnerStatement.executeQuery();

            if (flatOwnerResult.next()) {
                String flatOwner = flatOwnerResult.getString("Username");
                flatOwnerLabel.setText(flatOwner);
            }
            
            flatOwnerResult.close();
            flatOwnerStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        flatOwnerLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        flatComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        electricField = new javax.swing.JTextField();
        waterField = new javax.swing.JTextField();
        gasField = new javax.swing.JTextField();
        liftField = new javax.swing.JTextField();
        securityField = new javax.swing.JTextField();
        commonElecField = new javax.swing.JTextField();
        generatorField = new javax.swing.JTextField();
        issueDateField = new javax.swing.JTextField();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facilix");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel23.setText("Owner");

        flatOwnerLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        flatOwnerLabel.setText("ABCD");

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Select Flat");

        flatComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        flatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        flatComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                flatComboBoxItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Issued Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Electrics Bill");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Utility Bills");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Water");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 33)); // NOI18N
        jLabel2.setText("Add Bills");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Gas");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Service Charges");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Lift");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Security");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Generator");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Common Elec");

        electricField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        waterField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        gasField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        liftField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        securityField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        commonElecField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        generatorField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        issueDateField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11))
                                        .addGap(204, 204, 204)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(gasField)
                                            .addComponent(waterField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(251, 251, 251)
                                        .addComponent(electricField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(172, 172, 172)
                                        .addComponent(generatorField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(140, 140, 140)
                                        .addComponent(commonElecField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(188, 188, 188)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(securityField)
                                            .addComponent(liftField)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(flatComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(flatOwnerLabel)))))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(52, 52, 52)
                .addComponent(add)
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(flatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(flatOwnerLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(electricField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(waterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(gasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(liftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(securityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(commonElecField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(generatorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(add))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        AdminDashboardJFrame frame = new AdminDashboardJFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void flatComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_flatComboBoxItemStateChanged
        selectedFlat = (String) flatComboBox.getSelectedItem();

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            PreparedStatement flatOwnerStatement = connection.prepareStatement("SELECT Username FROM Users WHERE Id = (SELECT OwnerUserId FROM Flats WHERE Id = ?)");
            flatOwnerStatement.setString(1, selectedFlat);
            ResultSet flatOwnerResult = flatOwnerStatement.executeQuery();

            if (flatOwnerResult.next()) {
                String flatOwner = flatOwnerResult.getString("Username");
                flatOwnerLabel.setText(flatOwner);
            }

            flatOwnerResult.close();
            flatOwnerStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_flatComboBoxItemStateChanged

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
         try {
            Connection connection = DatabaseConnection.getConnection();
            String selectedFlatId = selectedFlat; // Assuming selectedFlat contains the appropriate flat ID

            // Validate and parse bill amounts
            double waterBill = Double.parseDouble(waterField.getText());
            double gasBill = Double.parseDouble(gasField.getText());
            double electricBill = Double.parseDouble(electricField.getText());
            double liftBill = Double.parseDouble(liftField.getText());
            double securityBill = Double.parseDouble(securityField.getText());
            double commonElecBill = Double.parseDouble(commonElecField.getText());
            double generatorBill = Double.parseDouble(generatorField.getText());

            // Validate issue date
            String issueDate = issueDateField.getText();
            if (!isValidDate(issueDate)) {
                JOptionPane.showMessageDialog(null, "Invalid issue date format (YYYY-MM-DD).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if all fields are empty
            if (waterBill < 0 && gasBill < 0 && electricBill < 0 && liftBill < 0 && securityBill < 0 && commonElecBill < 0 && generatorBill < 0) {
                JOptionPane.showMessageDialog(null, "Please fill in at least one bill amount field.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Insert data into Utility_Bills
            PreparedStatement utilityBillsStatement = connection.prepareStatement(
                "INSERT INTO Utility_Bills (FlatId, IssuedDate, Water_Bill, Gas_Bill) VALUES (?, ?, ?, ?)"
            );
            utilityBillsStatement.setString(1, selectedFlatId);
            utilityBillsStatement.setString(2, issueDate);
            utilityBillsStatement.setDouble(3, waterBill);
            utilityBillsStatement.setDouble(4, gasBill);
            utilityBillsStatement.executeUpdate();
            utilityBillsStatement.close();

            // Insert data into Electrics_Bills
            PreparedStatement electricsBillsStatement = connection.prepareStatement(
                "INSERT INTO Electrics_Bills (FlatId, IssuedDate, BillAmount) VALUES (?, ?, ?)"
            );
            electricsBillsStatement.setString(1, selectedFlatId);
            electricsBillsStatement.setString(2, issueDate);
            electricsBillsStatement.setDouble(3, electricBill);
            electricsBillsStatement.executeUpdate();
            electricsBillsStatement.close();

            // Insert data into Service_Charges
            PreparedStatement serviceChargesStatement = connection.prepareStatement(
                "INSERT INTO Service_Charges (FlatId, IssuedDate, LiftBill, SecurityBill, CommonElecBill, GeneratorExpenses) VALUES (?, ?, ?, ?, ?, ?)"
            );
            serviceChargesStatement.setString(1, selectedFlatId);
            serviceChargesStatement.setString(2, issueDate);
            serviceChargesStatement.setDouble(3, liftBill);
            serviceChargesStatement.setDouble(4, securityBill);
            serviceChargesStatement.setDouble(5, commonElecBill);
            serviceChargesStatement.setDouble(6, generatorBill);
            serviceChargesStatement.executeUpdate();
            serviceChargesStatement.close();

            JOptionPane.showMessageDialog(null, "Bills added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while adding bills. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            // Handle invalid input
            JOptionPane.showMessageDialog(null, "Invalid bill amount.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_addActionPerformed

    // Function to validate a date in the format "YYYY-MM-DD"
    private boolean isValidDate(String date) {
        String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2}";
        return date.matches(dateFormatRegex);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminAddBillsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddBillsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddBillsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddBillsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddBillsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField commonElecField;
    private javax.swing.JTextField electricField;
    private javax.swing.JComboBox<String> flatComboBox;
    private javax.swing.JLabel flatOwnerLabel;
    private javax.swing.JTextField gasField;
    private javax.swing.JTextField generatorField;
    private javax.swing.JTextField issueDateField;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField liftField;
    private javax.swing.JTextField securityField;
    private javax.swing.JTextField waterField;
    // End of variables declaration//GEN-END:variables
}