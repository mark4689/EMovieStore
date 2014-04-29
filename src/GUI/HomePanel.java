package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mark4689
 */
public class HomePanel extends JPanel {

    /**
     * Creates new form RegisterPanel
     */
    public HomePanel() {
        initComponents();
        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EMovieStoreFrame.getDBA().getConnection().close();
                    EMovieStoreFrame.getHomePanel().setVisible(false);
                    EMovieStoreFrame.instanceOf().remove(EMovieStoreFrame.getHomePanel());
                    EMovieStoreFrame.instanceOf().add(EMovieStoreFrame.getLoginPanel());
                    LoginPanel.setEmployee(false);
                    LoginPanel.setAdmin(false);
                    EMovieStoreFrame.getLoginPanel().jTextField1.setText("username");
                    EMovieStoreFrame.getLoginPanel().jPasswordField1.setText("password");
                    EMovieStoreFrame.getLoginPanel().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });

        customerReportsTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                customerReportsTB.setSelected(false);
            }
        });

        inventoryTB.addActionListener(new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame aFrame = new JFrame();
                aFrame.setSize(500, 500);
                //RegistrationPanel tempRP = new RegistrationPanel();
                //tempRP.setVisible(true);
                EMovieStoreFrame.getAdminInventoryPanel().setVisible(true);
                aFrame.add(EMovieStoreFrame.getAdminInventoryPanel());
                aFrame.setVisible(true);
                inventoryTB.setSelected(false);
            }
        });

        lateChargesTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lateChargesTB.setSelected(false);
            }
        });

        registerModifyTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EMovieStoreFrame.getLoginPanel().setVisible(false);
                try {
                    EMovieStoreFrame.instanceOf().remove(EMovieStoreFrame.getLoginPanel());
                } catch (SQLException ex) {
                    Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JFrame aFrame = new JFrame();
                aFrame.setSize(500, 500);
                RegistrationPanel tempRP = new RegistrationPanel();
                tempRP.setVisible(true);
                aFrame.add(tempRP);
                aFrame.setVisible(true);
                System.out.println("Register a user.");
                EMovieStoreFrame.getRegistrationPanel().setVisible(true);
                registerModifyTB.setSelected(false);
            }
        });

        rentTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                rentTB.setSelected(false);
            }
        });

        reserveTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reserveTB.setSelected(false);
            }
        });

        returnRentalMgmtTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnRentalMgmtTB.setSelected(false);
            }
        });

        returnTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnTB.setSelected(false);
            }
        });

        searchTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchTB.setSelected(false);
            }
        });

        viewPayTB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewPayTB.setSelected(false);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        searchTB = new javax.swing.JToggleButton();
        reserveTB = new javax.swing.JToggleButton();
        viewPayTB = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        returnTB = new javax.swing.JToggleButton();
        registerModifyTB = new javax.swing.JToggleButton();
        rentTB = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        returnRentalMgmtTB = new javax.swing.JToggleButton();
        lateChargesTB = new javax.swing.JToggleButton();
        inventoryTB = new javax.swing.JToggleButton();
        customerReportsTB = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        searchTB.setText("Search Title");
        searchTB.setToolTipText("");
        jPanel2.add(searchTB);

        reserveTB.setText("Reserve Title");
        jPanel2.add(reserveTB);

        viewPayTB.setText("View/Pay");
        viewPayTB.setActionCommand("");
        jPanel2.add(viewPayTB);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        returnTB.setText("Return Title");
        jPanel3.add(returnTB);

        registerModifyTB.setText("Register/Modify User");
        jPanel3.add(registerModifyTB);

        rentTB.setText("Rent Title");
        jPanel3.add(rentTB);

        jPanel1.add(jPanel3);

        add(jPanel1);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Management:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        returnRentalMgmtTB.setText("Update Rental Status");
        jPanel6.add(returnRentalMgmtTB);

        lateChargesTB.setText("Update Return Status");
        jPanel6.add(lateChargesTB);

        inventoryTB.setText("Inventory Status");
        jPanel6.add(inventoryTB);

        customerReportsTB.setText("Store Options & Reports");
        jPanel6.add(customerReportsTB);

        jPanel4.add(jPanel6);

        add(jPanel4);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        logoutButton.setText("Logout");
        jPanel9.add(logoutButton);

        jPanel7.add(jPanel9);

        add(jPanel7);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JToggleButton customerReportsTB;
    javax.swing.JToggleButton inventoryTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    javax.swing.JToggleButton lateChargesTB;
    javax.swing.JButton logoutButton;
    javax.swing.JToggleButton registerModifyTB;
    javax.swing.JToggleButton rentTB;
    javax.swing.JToggleButton reserveTB;
    javax.swing.JToggleButton returnRentalMgmtTB;
    javax.swing.JToggleButton returnTB;
    javax.swing.JToggleButton searchTB;
    javax.swing.JToggleButton viewPayTB;
    // End of variables declaration//GEN-END:variables
}
