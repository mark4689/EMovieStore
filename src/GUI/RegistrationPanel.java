package GUI;

import EMovieStore.Admin;
import EMovieStore.Customer;
import EMovieStore.Employee;
import EMovieStore.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mark4689
 */
public class RegistrationPanel extends javax.swing.JPanel {

    private static Connection con;

    /**
     * Creates new form HomePanel
     */
    public RegistrationPanel() {

        initComponents();
        if (!LoginPanel.isAdmin()) {
            jCheckBox1.setEnabled(false);
            jCheckBox2.setEnabled(false);
        }

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con = EMovieStoreFrame.getDBA().getConnection();
                    Statement stmt = con.createStatement();
                    String username = jTextField4.getText();
                    if ("username".equals(username)) {
                        String SQL_Statement = "INSERT INTO ACCOUNTINFO (USERNAME, "
                                + "PASSWORD, FIRSTNAME, LASTNAME, ADDRESS, LOCALITY, STATE, "
                                + "PHONENUMBER, CREDITCARDNO, EMAIL, ADMIN, EMPLOYEE) "
                                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
                        Employee empl = null;
                        if (EMovieStoreFrame.currentUser instanceof Employee
                                || EMovieStoreFrame.currentUser instanceof Admin) {
                            empl = new Employee();
                        }
                        User user = null;
                        if (empl != null) {
                            user = empl.registerUser(jTextField1.getText(), jTextField2.getText(),
                                    jTextField5.getText(), jTextField6.getText(), jTextField7.getText(),
                                    jTextField9.getText(), jTextField3.getText(),
                                    String.valueOf(jPasswordField1.getPassword()), Long.parseLong(jTextField10.getText()),
                                    Long.parseLong(jTextField8.getText()));
                        }

                       //registerUser(String firstname, String lastname, String address, String locality,
                        //String state, String email, String username, String password, long phonenumber, long ccNumber)
                        if (jCheckBox1.isSelected() && jCheckBox2.isSelected() && user != null) {
                            user = (Admin) user;
                        }

//                        user.setUsername(jTextField3.getText());
//                        user.setPassword(String.valueOf(jPasswordField1.getPassword()));
//                        user.setfName(jTextField1.getText());
//                        user.setlName(jTextField2.getText());
//                        user.setAddress(jTextField5.getText());
//                        user.setLocality(jTextField6.getText());
//                        user.setState(jTextField7.getText());
//                        user.setPhonenumber(Long.getLong(jTextField10.getText()));
//                        user.setCcNumber(Long.getLong(jTextField8.getText()));
//                        user.setEmail(jTextField9.getText());
                        EMovieStoreFrame.getDBA().updateUserDB(SQL_Statement, user);

                        System.out.println("User Added.");
                    } else if (!"username".equals(username)) {
                        String SQL_Statement = "UPDATE ACCOUNTINFO SET USERNAME = ?,"
                                + "PASSWORD = ?, FIRSTNAME = ?, LASTNAME = ?, ADDRESS = ?, "
                                + "LOCALITY = ?, STATE = ?, PHONENUMBER = ?, CREDITCARDNO = ?, "
                                + "EMAIL = ?, ADMIN = ?, EMPLOYEE = ? WHERE USERNAME = '" + username + "'";
                        ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");
                        while (rs.next()) {
                            if (EMovieStoreFrame.currentUser instanceof Admin && jCheckBox3.isSelected()) {
                                SQL_Statement = "DELETE FROM ACCOUNTINFO WHERE USERNAME = '" + username + "'";
                                stmt.executeUpdate(SQL_Statement);
                                break;
                            }
                            if (username.equals(rs.getString("username"))) {
                                User user;
                                if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
                                    user = new Admin();
                                } else if (jCheckBox2.isSelected()) {
                                    user = new Employee();
                                } else {
                                    user = new Customer();
                                }

                                user.setUsername(jTextField3.getText());
                                user.setPassword(String.valueOf(jPasswordField1.getPassword()));
                                user.setfName(jTextField1.getText());
                                user.setlName(jTextField2.getText());
                                user.setAddress(jTextField5.getText());
                                user.setLocality(jTextField6.getText());
                                user.setState(jTextField7.getText());
                                user.setPhonenumber(Long.getLong(jTextField10.getText()));
                                user.setCcNumber(Long.getLong(jTextField8.getText()));
                                user.setEmail(jTextField10.getText());

                                EMovieStoreFrame.getDBA().updateUserDB(SQL_Statement, user);
                                System.out.println("User Updated.");
                                break;
                            }
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        });

        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String un = jTextField4.getText();
                if (!un.equals("username")) {
                    try {
                        con = EMovieStoreFrame.getDBA().getConnection();
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");

                        while (rs.next()) {
                            if (un.equals(rs.getString("username"))) {
                                String firstname = rs.getString("firstname");
                                String lastname = rs.getString("lastname");
                                String address = rs.getString("address");
                                String locality = rs.getString("locality");
                                String state = rs.getString("state");
                                String password = rs.getString("password");
                                String ccNo = rs.getString("creditcardno");
                                String phonenumber = rs.getString("phonenumber");
                                String email = rs.getString("email");
                                boolean isAdministrator = rs.getBoolean("admin");
                                boolean isEmployee = rs.getBoolean("employee");

                                jTextField1.setText(firstname);
                                jTextField2.setText(lastname);
                                jTextField3.setText(un);
                                jPasswordField1.setText(password);
                                jTextField4.setText(un);
                                jTextField5.setText(address);
                                jTextField6.setText(locality);
                                jTextField7.setText(state);
                                jTextField8.setText(ccNo);
                                jTextField9.setText(email);
                                jTextField10.setText(phonenumber);
                                jCheckBox1.setSelected(isAdministrator);
                                jCheckBox2.setSelected(isEmployee);
                            }

                        }
                    } catch (SQLException sqlEx) {
                        System.out.println(sqlEx);
                    }
                } else {
                    jTextField1.setText("First Name");
                    jTextField2.setText("Last Name");
                    jTextField4.setText("username");
                    jTextField3.setText("username");
                    jPasswordField1.setText("password");
                    jTextField10.setText("Phone No.");
                    jTextField5.setText("Address");
                    jTextField6.setText("City / Locality");
                    jTextField7.setText("State");
                    jTextField8.setText("CC Number");
                    jTextField9.setText("email");
                }
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField10 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(750, 500));
        setPreferredSize(new java.awt.Dimension(750, 500));
        setLayout(new java.awt.GridLayout(1, 3));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Back");
        jPanel1.add(jButton1, java.awt.BorderLayout.SOUTH);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new java.awt.GridLayout(10, 1));

        jTextField1.setText("First Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);

        jTextField2.setText("Last Name");
        jPanel2.add(jTextField2);

        jTextField3.setText("username");
        jPanel2.add(jTextField3);

        jPasswordField1.setText("password");
        jPanel2.add(jPasswordField1);

        jTextField10.setText("Phone No.");
        jPanel2.add(jTextField10);

        jTextField5.setText("Address");
        jPanel2.add(jTextField5);

        jTextField6.setText("City / Locality");
        jPanel2.add(jTextField6);

        jTextField7.setText("State");
        jPanel2.add(jTextField7);

        jTextField8.setText("CC Number");
        jPanel2.add(jTextField8);

        jTextField9.setText("email");
        jPanel2.add(jTextField9);

        jCheckBox1.setText("Administrator");
        jPanel2.add(jCheckBox1);

        jCheckBox2.setText("Employee");
        jPanel2.add(jCheckBox2);

        jCheckBox3.setText("Delete User");
        jPanel2.add(jCheckBox3);

        add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jTextField4.setText("username");
        jTextField4.setPreferredSize(new java.awt.Dimension(170, 50));
        jPanel4.add(jTextField4);

        jButton3.setText("Search User");
        jPanel4.add(jButton3);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jButton2.setText("Register/Update User");
        jPanel3.add(jButton2, java.awt.BorderLayout.SOUTH);

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
