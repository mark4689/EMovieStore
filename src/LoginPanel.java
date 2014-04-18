
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mark4689
 */
public class LoginPanel extends javax.swing.JPanel {
    static Connection con;
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex){
                    System.out.println(ex);
                } 
                try{
                    con = DriverManager.getConnection("jdbc:derby://localhost"
                                                + ":1527/EMovieStoreDB", "administrator", "password");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");
                    
                    while(rs.next()){
                        
                        String un = rs.getString("username");
                        boolean isEmployee =  rs.getBoolean("employee");
                        boolean isAdmin = rs.getBoolean("admin");
                        String pw = rs.getString("password");
                        
                        if( jTextField1.getText().equals(un) && String.valueOf(jPasswordField1.getPassword()).equals(pw)){
                                EMovieStoreFrame.loginPanel.setVisible(false);
                                EMovieStoreFrame.emsf.remove(EMovieStoreFrame.loginPanel);
                                EMovieStoreFrame.emsf.add(EMovieStoreFrame.homePanel, BorderLayout.CENTER);
                                if(!isEmployee){//user is a customer
                                    EMovieStoreFrame.homePanel.custDelinquencyTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.inventoryTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.lateChargesTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.rentTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.returnRentalMgmtTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.returnTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.registerModifyTB.setEnabled(false);
                                }else if(!isAdmin){//user is an employee but not Admin
                                    EMovieStoreFrame.homePanel.custDelinquencyTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.inventoryTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.lateChargesTB.setEnabled(false);
                                    EMovieStoreFrame.homePanel.returnRentalMgmtTB.setEnabled(false);
                                }
                                EMovieStoreFrame.homePanel.setVisible(true);
                        }
                        EMovieStoreFrame.loginPanel.setVisible(false);
                        EMovieStoreFrame.registrationPanel.setVisible(true);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jTextField1.setText("username");
        jPanel1.add(jTextField1);

        jPasswordField1.setText("password");
        jPanel1.add(jPasswordField1);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Login");
        jPanel2.add(jButton1);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
