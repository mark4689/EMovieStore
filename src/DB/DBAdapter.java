/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import EMovieStore.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mark4689
 */
public class DBAdapter {
    private static Connection con = null;
    private static Boolean admin, employee;
    
    public DBAdapter(){
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

    public Connection getConnection(){
        return con;
    }

}
