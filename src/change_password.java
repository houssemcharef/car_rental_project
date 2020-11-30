
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class change_password extends javax.swing.JFrame {

    Connection con;
    public change_password() {
        initComponents();
                    try {
           
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(update_car.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        mdp = new javax.swing.JPasswordField();
        cmdp = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(610, 320));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("change your password ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 0, 370, 47);

        mdp.setText("jPasswordField1");
        getContentPane().add(mdp);
        mdp.setBounds(210, 90, 111, 30);

        cmdp.setText("jPasswordField2");
        getContentPane().add(cmdp);
        cmdp.setBounds(210, 140, 111, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("confirm your password ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 150, 186, 18);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 100, 80, 23);

        confirm.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-checked-radio-button-24.png"))); // NOI18N
        confirm.setText("confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(110, 200, 160, 33);

        back.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(20, 250, 109, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sans titre(2).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        try{
test_input input= new test_input();
int test=0;
test += input.password_verification(mdp.getText(), cmdp.getText());
test += input.password_length_test(mdp.getText(), 5);
if (test==2)

            {
            String sql = "UPDATE ADMINISTRATOR SET PASSWORD = ?  WHERE ADMIN_ID = ?";
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,mdp.getText());
            pstmt.setInt(2, Current_User.id);
                
          int  count = pstmt.executeUpdate();
            

            if(count >0)
            {
            JOptionPane.showMessageDialog(this, "Your password is changed Successfully ! Log in with your new password ", "Success Message", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            new login().setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(this, "something went wrong, try again!", "Execution Alert", JOptionPane.ERROR_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(this, "All Fields MUST be filled", "Execution Alert", JOptionPane.ERROR_MESSAGE);    
        }
        
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
            JOptionPane.showMessageDialog(this, "Update Query Execution Failed", "Execution Alert", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new administrator().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(change_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new change_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPasswordField cmdp;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField mdp;
    // End of variables declaration//GEN-END:variables
}
