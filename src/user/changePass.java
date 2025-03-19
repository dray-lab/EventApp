/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.dbConnector;
import config.passwordHasher;
import eventapp.loginForm;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class changePass extends javax.swing.JFrame {

    private Object iddisplay;

    /**
     * Creates new form userDashboard
     */
    public changePass() {
        initComponents();
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        id_display = new javax.swing.JLabel();
        ai = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        acct_fn = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        oldpass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        newpass = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        conpass = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        id_display.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_display.setForeground(new java.awt.Color(51, 0, 102));
        id_display.setText("(UID)");

        ai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ai.setForeground(new java.awt.Color(51, 0, 102));
        ai.setText("CHANGE PASSWORD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ai)
                .addGap(18, 18, 18)
                .addComponent(id_display)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_display, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(ai, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 40));

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(51, 0, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGOUT");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 20));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 140, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-account-100.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 80));

        jPanel8.setBackground(new java.awt.Color(51, 0, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acct_fn.setForeground(new java.awt.Color(255, 255, 255));
        acct_fn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acct_fn.setText("USER");
        jPanel8.add(acct_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 140, 30));

        pass.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pass.setText("Change Password");
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 140, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 140, 380));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 102));
        jLabel12.setText("Enter Old Password:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 130, 20));

        oldpass.setForeground(new java.awt.Color(102, 0, 102));
        oldpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 240, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 102));
        jLabel9.setText("New Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 120, 20));

        newpass.setForeground(new java.awt.Color(102, 0, 102));
        newpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 240, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 102));
        jLabel10.setText("Confirm Password");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 140, 20));

        conpass.setForeground(new java.awt.Color(102, 0, 102));
        conpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpassActionPerformed(evt);
            }
        });
        jPanel1.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 240, 30));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 100, 40));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Back");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 100, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/d6d0bdfdbdb9db439b8033c7681976dc.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 330, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    Session sess = Session.getInstance();
    id_display.setText("USER ID: "+sess.getUid());
    oldpass.setText(""+sess.getFname());
    newpass.setText(""+sess.getLname());
    conpass.setText(""+sess.getEmail());
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Check if any field is empty
        if (oldpass.getText().isEmpty() || newpass.getText().isEmpty() || conpass.getText().isEmpty() || pass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        if (pass.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
            pass.setText("");
            return;
        }

        if (duplicateCheck()) {
            JOptionPane.showMessageDialog(null, "Duplicate username exists!");
            return;
        }

        dbConnector dbc = new dbConnector();
        Connection conn = (Connection) dbc.getConnection();

        if (conn != null) {
            try {
                String sql = "INSERT INTO tbl_registeruser (u_fname, u_lname, u_email, u_username, u_password, u_type, u_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                String hashedPassword = passwordHasher.hashPassword(pass.getText());

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, oldpass.getText());
                pstmt.setString(2, newpass.getText());
                pstmt.setString(3, conpass.getText()); // Fixed email column reference

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Inserted Successfully!");
                    new loginForm().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insertion failed. Try again!");
                }

                pstmt.close();
                conn.close();
            } catch (SQLException | NoSuchAlgorithmException ex) {
                ex.printStackTrace(); // Print error details for debugging
            }
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error! Unable to connect to the database.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void conpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conpassActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Open accountDetails form
    accountDetails accDetails = new accountDetails();
    accDetails.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
    try{
        dbConnector dbc = new dbConnector();
        Session sess = Session.getInstance();
        
        String query = "SELECT * FROM tbl_registeruser WHERE u_id = '"+sess.getUid()+"'";
        ResultSet rs = dbc.getData(query);
        if(rs.next()){
         String olddbpass = rs.getString("u_password");
         String oldhash = passwordHasher.hashPassword(oldpass.getText());
         
         if(olddbpass.equals(oldhash)){
             String npass = passwordHasher.hashPassword(newpass.getText());
             dbc.updateData("UPDATE tbl_registeruser SET u_password = '"+npass+"'");
             JOptionPane.showMessageDialog(null, "Successfully Updated!");
             loginForm lg = new loginForm();
             lg.setVisible(true);
             this.dispose();
         }else{
         JOptionPane.showMessageDialog(null, "Old Password is Incorrect!");
         }
        
        }
    }catch(SQLException | NoSuchAlgorithmException ex){
        System.out.println(""+ex);
    }
    }//GEN-LAST:event_jButton4MouseClicked

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
     changePass cp = new changePass();
     cp.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_passMouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acct_fn;
    private javax.swing.JLabel ai;
    private javax.swing.JTextField conpass;
    private javax.swing.JLabel id_display;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField newpass;
    private javax.swing.JTextField oldpass;
    private javax.swing.JLabel pass;
    // End of variables declaration//GEN-END:variables

    private boolean duplicateCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
