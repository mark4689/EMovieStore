package GUI;



import EMovieStore.Admin;
import EMovieStore.Customer;
import EMovieStore.Employee;
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
    private static Connection con;
    private static boolean isEmployee;
    private static boolean isAdmin;
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stmt;
                try {
                    stmt = EMovieStoreFrame.getDBA().getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");
                    
                    while(rs.next()){
                        String un = rs.getString("username");
                        String pw = rs.getString("password");
                        
                        if( jTextField1.getText().equals(un) && String.valueOf(jPasswordField1.getPassword()).equals(pw)){
                                isEmployee =  rs.getBoolean("employee");
                                isAdmin = rs.getBoolean("admin");
                                EMovieStoreFrame.getLoginPanel().setVisible(false);
                                EMovieStoreFrame.instanceOf().remove(EMovieStoreFrame.getLoginPanel());
                                EMovieStoreFrame.instanceOf().add(EMovieStoreFrame.getHomePanel(), BorderLayout.CENTER);
                                EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().inventoryTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().lateChargesTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().rentTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().returnRentalMgmtTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().returnTB.setEnabled(true);
                                EMovieStoreFrame.getHomePanel().registerModifyTB.setEnabled(true);
                                if(!isEmployee){//user is a customer
                                    EMovieStoreFrame.currentUser = new Customer(rs.getString("firstname"), rs.getString("lastname"),
                                            rs.getString("address"), rs.getString("locality"), rs.getString("state"), rs.getString("email"),
                                            rs.getString("username"), rs.getString("password"), rs.getLong("phonenumber"));
                                    EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().inventoryTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().lateChargesTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().rentTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().returnRentalMgmtTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().returnTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().registerModifyTB.setEnabled(false);
                                }else if(!isAdmin){//user is an employee but not Admin
                                    EMovieStoreFrame.currentUser = new Employee(rs.getString("firstname"), rs.getString("lastname"),
                                            rs.getString("address"), rs.getString("locality"), rs.getString("state"), rs.getString("email"),
                                            rs.getString("username"), rs.getString("password"), rs.getLong("phonenumber"));
                                    EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().customerReportsTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().inventoryTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().lateChargesTB.setEnabled(false);
                                    EMovieStoreFrame.getHomePanel().returnRentalMgmtTB.setEnabled(false);
                                }else{
                                    EMovieStoreFrame.currentUser = new Admin(rs.getString("firstname"), rs.getString("lastname"),
                                            rs.getString("address"), rs.getString("locality"), rs.getString("state"), rs.getString("email"),
                                            rs.getString("username"), rs.getString("password"), rs.getLong("phonenumber"));
                                }
                                EMovieStoreFrame.getHomePanel().setVisible(true);
                        }
                        EMovieStoreFrame.getLoginPanel().setVisible(false);
                        EMovieStoreFrame.getRegistrationPanel().setVisible(true);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            
        });
        
    }
    
    public static boolean isAdmin(){
         return isAdmin;
    }
    
    public static boolean isEmployee(){
        return isEmployee;
    }
    
    public static void setAdmin(boolean admin){
        isAdmin = admin;
    }
    
    public static void setEmployee(boolean employee){
        isEmployee = employee;
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
    javax.swing.JPasswordField jPasswordField1;
    javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
