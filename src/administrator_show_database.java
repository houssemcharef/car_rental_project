import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class administrator_show_database extends javax.swing.JFrame {

    /**
     * Creates new form administrator_show_database
     */
    public administrator_show_database() {
        initComponents();
                    try {
           // Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/project", "java", "java");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
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

        customers = new javax.swing.JButton();
        cars = new javax.swing.JButton();
        rentals = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 360));
        getContentPane().setLayout(null);

        customers.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-customer-30.png"))); // NOI18N
        customers.setText("customers");
        customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersActionPerformed(evt);
            }
        });
        getContentPane().add(customers);
        customers.setBounds(20, 20, 150, 39);

        cars.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-car-24.png"))); // NOI18N
        cars.setText("cars");
        cars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsActionPerformed(evt);
            }
        });
        getContentPane().add(cars);
        cars.setBounds(190, 20, 130, 40);

        rentals.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        rentals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-car-rental-26.png"))); // NOI18N
        rentals.setText("rentals ");
        rentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalsActionPerformed(evt);
            }
        });
        getContentPane().add(rentals);
        rentals.setBounds(340, 20, 130, 40);

        back.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(490, 20, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Toyotarentacarfleet1-620x360-1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 315);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersActionPerformed
    
         administrator_show_customers Frame= new administrator_show_customers();
                Frame.setVisible(true);
    }//GEN-LAST:event_customersActionPerformed

    private void carsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsActionPerformed
           administrator_show_cars Frame= new administrator_show_cars();
                Frame.setVisible(true);
    }//GEN-LAST:event_carsActionPerformed

    private void rentalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalsActionPerformed

   administrator_show_rentals Frame= new administrator_show_rentals();
                Frame.setVisible(true);

    }//GEN-LAST:event_rentalsActionPerformed

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
            java.util.logging.Logger.getLogger(administrator_show_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administrator_show_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administrator_show_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administrator_show_database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administrator_show_database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cars;
    private javax.swing.JButton customers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rentals;
    // End of variables declaration//GEN-END:variables
}
