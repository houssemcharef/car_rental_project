
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
public class cancel_rent extends javax.swing.JFrame {

  Connection con;
    public cancel_rent() {
        initComponents();
            try {
           // con = DriverManager.getConnection("jdbc:derby://localhost:1527/project", "java", "java");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        } catch (SQLException ex) { 
          Logger.getLogger(cancel_rent.class.getName()).log(Level.SEVERE, null, ex);
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

        id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(610, 310));
        setResizable(false);
        getContentPane().setLayout(null);

        id.setText("enter the id of the rental you want to cancel please");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id);
        id.setBounds(20, 50, 310, 40);

        delete.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-52.png"))); // NOI18N
        delete.setOpaque(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(350, 50, 60, 40);

        back.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(40, 240, 120, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sans titre(2).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -90, 1087, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new customer().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try{
              
 if (! id.getText().isEmpty())
            {      
             int ID = Integer.parseInt(id.getText());
            int count;
            String sql = "DELETE FROM RENTAL WHERE RENTAL_ID = ? AND CUSTOMER_ID = ?" ;
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ID);
            pstmt.setInt(2,Current_User.id);
            count = pstmt.executeUpdate();
            
            
            
            if(count >0 )
            JOptionPane.showMessageDialog(this, "The rental was cancelled Successfully !", "Success Message", JOptionPane.INFORMATION_MESSAGE);
            else
            JOptionPane.showMessageDialog(this, "No record was found with the given ID", "Execution Alert", JOptionPane.ERROR_MESSAGE);
            
            
            }
            
            else
            JOptionPane.showMessageDialog(this, "ERROR \n please enter your correct id ", "Execution Alert", JOptionPane.ERROR_MESSAGE);    
        }
        
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
            JOptionPane.showMessageDialog(this, "DELETE Query Execution Failed", "Execution Alert", JOptionPane.ERROR_MESSAGE);
        }  
       

    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(cancel_rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cancel_rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cancel_rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cancel_rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cancel_rent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
