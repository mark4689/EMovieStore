
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.DriverManager;
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

    /**
     * Creates new form HomePanel
     */
    public RegistrationPanel() {
        initComponents();
        if (!LoginPanel.isAdmin) {
            jCheckBox1.setEnabled(false);
            jCheckBox2.setEnabled(false);
        }
        
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = jTextField3.getText();
                    if (!"username".equals(username)){
                        LoginPanel.con = DriverManager.getConnection("jdbc:derby://localhost"
                                + ":1527/EMovieStoreDB", "administrator", "password");
                        Statement stmt = LoginPanel.con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");
                        while(rs.next()){
                            if(username.equals(rs.getString("username"))){
                                String SQL_Statement0 = "UPDATE ACCOUNTINFO SET firstname = ? WHERE username = '" + username + "'";
                                String SQL_Statement1 = "UPDATE ACCOUNTINFO SET lastname = ? WHERE username = '" + username + "'";
                                String SQL_Statement2 = "UPDATE ACCOUNTINFO SET username = ? WHERE username = '" + username + "'";
                                String SQL_Statement3 = "UPDATE ACCOUNTINFO SET password = ? WHERE username = '" + username + "'";
                                String SQL_Statement4 = "UPDATE ACCOUNTINFO SET address = ? WHERE username = '" + username + "'";
                                String SQL_Statement5 = "UPDATE ACCOUNTINFO SET locality = ? WHERE username = '" + username + "'";
                                String SQL_Statement6 = "UPDATE ACCOUNTINFO SET state = ? WHERE username = '" + username + "'";
                                String SQL_Statement7 = "UPDATE ACCOUNTINFO SET phonenumber = ? WHERE username = '" + username + "'";
                                String SQL_Statement8 = "UPDATE ACCOUNTINFO SET creditcardno = ? WHERE username = '" + username + "'";
                                String SQL_Statement9 = "UPDATE ACCOUNTINFO SET email = ? WHERE username = '" + username + "'";
                                String SQL_Statement10 = "UPDATE ACCOUNTINFO SET admin = ? WHERE username = '" + username + "'";
                                String SQL_Statement11 = "UPDATE ACCOUNTINFO SET employee = ? WHERE username = '" + username + "'";

                                PreparedStatement updateQuery = LoginPanel.con.prepareStatement(SQL_Statement0);
                                updateQuery.setString(1, jTextField1.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement1);
                                updateQuery.setString(1, jTextField2.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement2);
                                updateQuery.setString(1, username);
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement3);
                                updateQuery.setString(1, String.valueOf(jPasswordField1.getPassword()));
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement4);
                                updateQuery.setString(1, jTextField5.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement5);
                                updateQuery.setString(1, jTextField6.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement6);
                                updateQuery.setString(1, jTextField7.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement7);
                                updateQuery.setBigDecimal(1, BigDecimal.valueOf(Integer.getInteger(jTextField10.getText()).longValue()));
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement8);
                                updateQuery.setBigDecimal(1, BigDecimal.valueOf(Integer.getInteger(jTextField8.getText()).longValue()));
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement9);
                                updateQuery.setString(1, jTextField9.getText());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement10);
                                updateQuery.setBoolean(1, jCheckBox1.isSelected());
                                updateQuery.execute();
                                updateQuery = LoginPanel.con.prepareStatement(SQL_Statement11);
                                updateQuery.setBoolean(1, jCheckBox2.isSelected());
                                updateQuery.execute();
                            }
                        }
                        
                    }
                    
                    Statement stmt = LoginPanel.con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM accountInfo");
                    
                    
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
                        LoginPanel.con = DriverManager.getConnection("jdbc:derby://localhost"
                                + ":1527/EMovieStoreDB", "administrator", "password");
                        Statement stmt = LoginPanel.con.createStatement();
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
                    jTextField1.setText("username");
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
