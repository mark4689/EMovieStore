package GUI;


import DB.DBAdapter;
import EMovieStore.User;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mark4689
 */
public class EMovieStoreFrame extends JFrame {
    private static LoginPanel loginPanel;
    private static HomePanel homePanel;
    private static RegistrationPanel registrationPanel;
    private static AdminInventory adminInventoryPanel;
    private static DBAdapter dBA;
    private static EMovieStoreFrame emsf = null;
    static User currentUser;
    /**
     * Creates new form NewJFrame
     */
    private EMovieStoreFrame() throws SQLException {
        initComponents();
        dBA = new DBAdapter();
        loginPanel = new LoginPanel();
        homePanel = new HomePanel();
        registrationPanel = new RegistrationPanel();
        adminInventoryPanel = new AdminInventory();
        
        loginPanel.setVisible(true);
        homePanel.setVisible(false);
        registrationPanel.setVisible(false);
        adminInventoryPanel.setVisible(false);
        
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.add(loginPanel ,BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static EMovieStoreFrame instanceOf() throws SQLException{
        if(emsf == null)
            emsf = new EMovieStoreFrame();
        
        return emsf;
    }

    public static LoginPanel getLoginPanel(){
        return loginPanel;
    }
    
    public static HomePanel getHomePanel(){
        return homePanel;
    }
    
    public static RegistrationPanel getRegistrationPanel(){
        return registrationPanel;
    }
    
    public static AdminInventory getAdminInventoryPanel(){
        return adminInventoryPanel;
    }
    
    public static DBAdapter getDBA(){
        return dBA;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EMovieStoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EMovieStoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EMovieStoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EMovieStoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EMovieStoreFrame eMovieStoreFrame;
                try {
                    eMovieStoreFrame = instanceOf();
                } catch (SQLException ex) {
                    Logger.getLogger(EMovieStoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
