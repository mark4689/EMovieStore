/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import EMovieStore.Admin;
import EMovieStore.Employee;
import EMovieStore.User;
import GUI.EMovieStoreFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mark4689
 */
public class DBAdapter {

    private static Connection con = null;
    private static Boolean admin, employee;

    public DBAdapter() {
        if (con == null) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                System.out.println(ex);
            }
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost"
                        + ":1527/EMovieStoreDB", "administrator", "password");
            } catch (SQLException SQLEx) {
                System.out.println(SQLEx);
            }
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void updateUserDB(String SQL_Statement, User u) {
        try {
            PreparedStatement pstmt = EMovieStoreFrame.getDBA().getConnection().prepareStatement(SQL_Statement);

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getfName());
            pstmt.setString(4, u.getlName());
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getLocality());
            pstmt.setString(7, u.getState());
            pstmt.setLong(8, u.getPhonenumber());
            pstmt.setLong(9, u.getCcNumber());
            pstmt.setString(10, u.getEmail());
            
            Boolean admin, employee;
            if(u instanceof Admin){
                admin = true;
                employee = true;
            } else if (u instanceof Employee) {
                admin = false;
                employee = true;
            } else {
                    admin = false;
                    employee = false;
            }
            
            pstmt.setBoolean(11, admin);
            pstmt.setBoolean(12, employee);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("updateDB Failed!");
        }
    }
}
