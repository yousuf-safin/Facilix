/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.facilix.ui;

import static com.facilix.ui.UserLoginJFrame.loggedInUser;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @Yousuf
 */
public class UserDashboardJFrame extends javax.swing.JFrame {

    private String selectedFlat = "101";
    private String selectedIssuedDate;

    /**
     * Creates new form UserDashboardJFrame
     */
    public UserDashboardJFrame() {
        initComponents();
        populateFlatComboBox();
    }

    private void populateFlatComboBox() {
        flatComboBox.removeAllItems(); // Clear existing items

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Fetch the user ID based on the email stored in loggedInUser
            String getUserIdQuery = "SELECT Id FROM Users WHERE Email = ?";
            PreparedStatement getUserIdStatement = connection.prepareStatement(getUserIdQuery);
            getUserIdStatement.setString(1, loggedInUser); // Assuming loggedInUser contains the email
            ResultSet getUserIdResult = getUserIdStatement.executeQuery();

            int userId = -1; // Default value in case no user with the email is found
            if (getUserIdResult.next()) {
                userId = getUserIdResult.getInt("Id");
            }

            getUserIdResult.close();
            getUserIdStatement.close();

            if (userId != -1) {
                // Fetch the flats where the ResidentUserId matches the user's ID
                PreparedStatement getFlatsStatement = connection.prepareStatement(
                        "SELECT DISTINCT Id FROM Flats WHERE ResidentUserId = ?");
                getFlatsStatement.setInt(1, userId);
                ResultSet resultSet = getFlatsStatement.executeQuery();

                while (resultSet.next()) {
                    String flatName = resultSet.getString("Id");
                    flatComboBox.addItem(flatName);
                }

                resultSet.close();
                getFlatsStatement.close();

                // Fetch the owner of the selected flat
                String getFlatOwnerQuery = "SELECT Username FROM Users WHERE Id = (SELECT OwnerUserId FROM Flats WHERE Id = ?)";
                PreparedStatement getFlatOwnerStatement = connection.prepareStatement(getFlatOwnerQuery);
                getFlatOwnerStatement.setString(1, selectedFlat); // Assuming selectedFlat contains the appropriate flat ID
                ResultSet flatOwnerResult = getFlatOwnerStatement.executeQuery();

                if (flatOwnerResult.next()) {
                    String flatOwner = flatOwnerResult.getString("Username");
                    flatOwnerLabel.setText(flatOwner);
                }

                flatOwnerResult.close();
                getFlatOwnerStatement.close();
            } else {
                // No user found with the specified email
                JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        liftBill = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        generatorBill = new javax.swing.JLabel();
        commonElecBill = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalBill = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        flatComboBox = new javax.swing.JComboBox<>();
        flatOwnerLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        issueDateComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        electricsBill = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        waterBill = new javax.swing.JLabel();
        gasBill = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        securityBill = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facilix");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("My Bills");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        liftBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        liftBill.setText("0000");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Generator");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Common Elec");

        generatorBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        generatorBill.setText("0000");

        commonElecBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        commonElecBill.setText("0000");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setText("Total");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Select Flat");

        totalBill.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalBill.setText("0000");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel23.setText("Owner");

        flatComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        flatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        flatComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                flatComboBoxItemStateChanged(evt);
            }
        });

        flatOwnerLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        flatOwnerLabel.setText("ABCD");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Issued Date");

        issueDateComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        issueDateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        issueDateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                issueDateComboBoxItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Electrics Bill");

        electricsBill.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        electricsBill.setText("0000");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Utility Bills");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Water");

        waterBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        waterBill.setText("0000");

        gasBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gasBill.setText("0000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Gas");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Service Charges");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Lift");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Security");

        securityBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        securityBill.setText("0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(issueDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(flatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(electricsBill))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel12))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(waterBill, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(gasBill, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(generatorBill))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(commonElecBill))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel14)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(securityBill))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(liftBill))))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalBill))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(flatOwnerLabel))))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(flatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(issueDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(flatOwnerLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(electricsBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(waterBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(gasBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(liftBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(securityBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(commonElecBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(generatorBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(totalBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        HomeJFrame frame = new HomeJFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
        
        issueDateComboBox.removeAllItems(); // Clear existing items
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            // Assuming that the Electrics_Bills table contains the issued dates
            String issueDateQuery = "SELECT DISTINCT IssuedDate FROM Electrics_Bills WHERE FlatId IN (SELECT Id FROM Flats WHERE Id = '" + selectedFlat + "')";
            ResultSet resultSet = statement.executeQuery(issueDateQuery);

            while (resultSet.next()) {
                String issueDate = resultSet.getString("IssuedDate");
                issueDateComboBox.addItem(issueDate);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
    }//GEN-LAST:event_flatComboBoxItemStateChanged

    private void issueDateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_issueDateComboBoxItemStateChanged
        selectedIssuedDate = (String) issueDateComboBox.getSelectedItem();

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Fetch data from Utility_Bills
            PreparedStatement utilityBillsStatement = connection.prepareStatement("SELECT Water_Bill, Gas_Bill FROM Utility_Bills WHERE FlatId = ? AND IssuedDate = ?");
            utilityBillsStatement.setString(1, selectedFlat);
            utilityBillsStatement.setString(2, selectedIssuedDate);
            ResultSet utilityBillsResult = utilityBillsStatement.executeQuery();

            if (utilityBillsResult.next()) {
                String waterBillData = utilityBillsResult.getString("Water_Bill");
                String gasBillData = utilityBillsResult.getString("Gas_Bill");

                // Populate waterBill and gasBill labels
                waterBill.setText(waterBillData != null && !waterBillData.isEmpty() ? waterBillData : "-");
                gasBill.setText(gasBillData != null && !gasBillData.isEmpty() ? gasBillData : "-");
            }

            utilityBillsResult.close();
            utilityBillsStatement.close();

            // Fetch data from Service_Charges
            PreparedStatement serviceChargesStatement = connection.prepareStatement("SELECT LiftBill, SecurityBill, CommonElecBill, GeneratorExpenses FROM Service_Charges WHERE FlatId = ? AND IssuedDate = ?");
            serviceChargesStatement.setString(1, selectedFlat);
            serviceChargesStatement.setString(2, selectedIssuedDate);
            ResultSet serviceChargesResult = serviceChargesStatement.executeQuery();

            if (serviceChargesResult.next()) {
                String liftBillData = serviceChargesResult.getString("LiftBill");
                String securityBillData = serviceChargesResult.getString("SecurityBill");
                String commonElecBillData = serviceChargesResult.getString("CommonElecBill");
                String generatorBillData = serviceChargesResult.getString("GeneratorExpenses");

                // Populate liftBill, securityBill, commonElecBill, and generatorBill labels
                liftBill.setText(liftBillData != null && !liftBillData.isEmpty() ? liftBillData : "-");
                securityBill.setText(securityBillData != null && !securityBillData.isEmpty() ? securityBillData : "-");
                commonElecBill.setText(commonElecBillData != null && !commonElecBillData.isEmpty() ? commonElecBillData : "-");
                generatorBill.setText(generatorBillData != null && !generatorBillData.isEmpty() ? generatorBillData : "-");
            }

            serviceChargesResult.close();
            serviceChargesStatement.close();

            // Fetch data from Electrics_Bills
            PreparedStatement electricsBillsStatement = connection.prepareStatement("SELECT BillAmount FROM Electrics_Bills WHERE FlatId = ? AND IssuedDate = ?");
            electricsBillsStatement.setString(1, selectedFlat);
            electricsBillsStatement.setString(2, selectedIssuedDate);
            ResultSet electricsBillsResult = electricsBillsStatement.executeQuery();

            if (electricsBillsResult.next()) {
                String electricsBillData = electricsBillsResult.getString("BillAmount");

                // Populate electricsBill label
                electricsBill.setText(electricsBillData != null && !electricsBillData.isEmpty() ? electricsBillData : "-");
            }

            electricsBillsResult.close();
            electricsBillsStatement.close();

            // Calculate total bills
            double waterBillAmount = parseBillAmount(waterBill.getText());
            double gasBillAmount = parseBillAmount(gasBill.getText());
            double liftBillAmount = parseBillAmount(liftBill.getText());
            double securityBillAmount = parseBillAmount(securityBill.getText());
            double commonElecBillAmount = parseBillAmount(commonElecBill.getText());
            double generatorBillAmount = parseBillAmount(generatorBill.getText());
            double electricsBillAmount = parseBillAmount(electricsBill.getText());

            double totalBillAmount = waterBillAmount
                    + gasBillAmount
                    + liftBillAmount
                    + securityBillAmount
                    + commonElecBillAmount
                    + generatorBillAmount
                    + electricsBillAmount;

            // Set the total bill in the "totalBill" label
            totalBill.setText(Double.toString(totalBillAmount));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_issueDateComboBoxItemStateChanged

    private double parseBillAmount(String billAmountText) {
        // Replace "-" with "0" and parse the bill amount as double
        return Double.parseDouble(billAmountText.trim().replace("-", "0"));
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
            java.util.logging.Logger.getLogger(UserDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboardJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commonElecBill;
    private javax.swing.JLabel electricsBill;
    private javax.swing.JComboBox<String> flatComboBox;
    private javax.swing.JLabel flatOwnerLabel;
    private javax.swing.JLabel gasBill;
    private javax.swing.JLabel generatorBill;
    private javax.swing.JComboBox<String> issueDateComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel liftBill;
    private javax.swing.JLabel securityBill;
    private javax.swing.JLabel totalBill;
    private javax.swing.JLabel waterBill;
    // End of variables declaration//GEN-END:variables
}
