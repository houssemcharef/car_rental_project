/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class insert_car extends javax.swing.JFrame {
Connection con;
    public insert_car() {
        initComponents();
            try {
          
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(insert_car.class.getName()).log(Level.SEVERE, null, ex);
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

        type = new javax.swing.JTextField();
        reference = new javax.swing.JTextField();
        availability = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(610, 610));
        getContentPane().setLayout(null);
        getContentPane().add(type);
        type.setBounds(260, 170, 170, 30);
        getContentPane().add(reference);
        reference.setBounds(260, 240, 170, 30);

        availability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabilityActionPerformed(evt);
            }
        });
        getContentPane().add(availability);
        availability.setBounds(260, 320, 170, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("type");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 170, 90, 23);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("reference");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 250, 110, 23);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("availability");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 330, 120, 23);

        back.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-arrow-24.png"))); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(50, 450, 110, 33);

        confirm.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-checked-radio-button-24.png"))); // NOI18N
        confirm.setText("confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(240, 450, 140, 33);

        jLabel6.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("insert a car");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 10, 180, 39);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sans titre(3).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 738, 667);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void availabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabilityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availabilityActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
try{
test_input input= new test_input();
int length=0;

            String TYPE = type.getText();
            String REFERENCE = reference.getText();
            String AVAILABILITY = availability.getText();



length += input.reference_length_test(REFERENCE,5);
length += input.availability_input(AVAILABILITY);

if (length==2)   
                
            {
            

      
            int count;
            PreparedStatement pstmt;
            String SQL1 = "select max(car_id) from car ;";
                         
                   
                  Statement stmt = con.createStatement( );
                 ResultSet rs1 = stmt.executeQuery( SQL1 );
                 int r_id = 0;
               
                 while(rs1.next()){
                 r_id=rs1.getInt("MAX(car_id)")+1;              
                 }
            String sql = "INSERT INTO CAR VALUES(?,?,?,?)" ;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, r_id);
            pstmt.setString(2, TYPE);
            pstmt.setString(3,REFERENCE);
            pstmt.setString(4, AVAILABILITY);
           
            count = pstmt.executeUpdate();
            

            if(count >0)
            //JOptionPane.showMessageDialog(null,"The Employee was added Successfully !");
            JOptionPane.showMessageDialog(this, "The car was added Successfully !", "Success Message", JOptionPane.INFORMATION_MESSAGE);
            else
            JOptionPane.showMessageDialog(this, "Insert Query Execution Failed", "Execution Alert", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            JOptionPane.showMessageDialog(this, "Failed to Add \nAll Fields are Mandatory", "Execution Alert", JOptionPane.ERROR_MESSAGE);    
        }
        catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            JOptionPane.showMessageDialog(this, "Failed to Add \nDuplicate ID !", "Execution Alert", JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
            JOptionPane.showMessageDialog(this, "Insert Query Execution Failed", "Execution Alert", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_confirmActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
this.setVisible(false);
 new administrator_control_database().setVisible(true);
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
            java.util.logging.Logger.getLogger(insert_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insert_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insert_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insert_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insert_car().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availability;
    private javax.swing.JButton back;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField reference;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}
