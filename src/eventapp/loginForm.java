/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp;

import config.Session;
import organizer.adminDashboard;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import user.attendeesForm;
import user.userDashboard;


/**
 *
 * @author user
 */
public class loginForm extends javax.swing.JFrame {
    

    /**
     * Creates new form loginForm
     */
    public loginForm() {
        initComponents();
    }
    
    static String status;
    static String type;
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        
        try{
           String query = "SELECT * FROM tbl_registeruser WHERE u_username = '" + username + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                
                
                String hashedPass = resultSet.getString("u_password");
                String rehashedPass = passwordHasher.hashPassword(password);

                if(hashedPass.equals(rehashedPass)){
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                Session sess = Session.getInstance();
                sess.setUid(resultSet.getInt("u_id"));
                sess.setFname(resultSet.getString("u_fname"));
                sess.setLname(resultSet.getString("u_lname"));
                sess.setEmail(resultSet.getString("u_email"));
                sess.setUsername(resultSet.getString("u_username"));
                sess.setType(resultSet.getString("u_type"));
                sess.setStatus(resultSet.getString("u_status"));
                return true;
            
            }else{
                return false;
                }
               
            }else{
                return false;
            }
        }catch (SQLException | NoSuchAlgorithmException ex) {
            return false;
            
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Toregistration = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        fp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Black_and_Gold_Luxury_Company_Logo-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -30, 200, 420));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/69d07f5b4e21ac19a3bdebbbdd6d2cc1-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 100, 570, 320));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0-a6ad2abf8f86dededec628bccb9a6a7a3e564e0b55357047e360e02d4576b9ed-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 330));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 420));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Password :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 70, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Username :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 70, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Login Form");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 310, 60));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 100, 40));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 100, 40));

        Toregistration.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Toregistration.setForeground(new java.awt.Color(204, 204, 255));
        Toregistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Toregistration.setText("Don't have an accont? Click here to Register!");
        Toregistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ToregistrationMouseClicked(evt);
            }
        });
        jPanel1.add(Toregistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 270, 20));

        user.setBackground(new java.awt.Color(51, 0, 102));
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 290, 40));

        pass.setBackground(new java.awt.Color(51, 0, 102));
        pass.setForeground(new java.awt.Color(204, 204, 255));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 290, 40));

        fp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fp.setForeground(new java.awt.Color(204, 204, 255));
        fp.setText("Forgot Password?");
        fp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fpMouseClicked(evt);
            }
        });
        jPanel1.add(fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, 20));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 380, 420));

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //changed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String username = user.getText();
    String password = new String(pass.getPassword()); // Corrected for JPasswordField

    if (loginAcc(username, password)) {
        try (Connection conn = (Connection) new dbConnector().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_registeruser WHERE u_username=?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("u_status");
                String type = rs.getString("u_type");
                int userId = rs.getInt("u_id"); // Get user ID

                if (!"Active".equals(status)) {
                    JOptionPane.showMessageDialog(null, "Inactive Account, Contact the Admin!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Successfully!");

                    // ✅ Insert login log using dbConnector
                    dbConnector db = new dbConnector();
                    db.insertLog(userId, "Login", "User logged in successfully");

                    // ✅ Open dashboard based on user type
                    if ("Admin".equals(type)) {
                        adminDashboard ads = new adminDashboard();
                        ads.setVisible(true);
                    } else if ("User".equals(type)) {
                        userDashboard udb = new userDashboard();
                        udb.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No Account Type found, Contact the Admin!");
                        return;
                    }

                    this.dispose(); // Close login form
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid Account");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ToregistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToregistrationMouseClicked

        registerForm rfm = new registerForm();
        rfm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ToregistrationMouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed
       
    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void fpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fpMouseClicked
       String email = JOptionPane.showInputDialog(null, "Enter your registered email:", "Forgot Password", JOptionPane.QUESTION_MESSAGE);
    
    if (email != null && !email.trim().isEmpty()) {
        try {
            // Establish database connection
            dbConnector db = new dbConnector();
            Connection conn = (Connection) db.getConnection();
            
            // Check if email exists in the user table
            String query = "SELECT * FROM tbl_registeruser WHERE u_email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String resetToken = generateResetToken();
                
                // Store reset token in database
                String insertQuery = "INSERT INTO password_resets (email, token) VALUES (?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, email);
                insertStmt.setString(2, resetToken);
                insertStmt.executeUpdate();
                insertStmt.close();

                // ✅ Log password reset request (since insertLog is already in your code)
                insertLog(rs.getInt("u_id"), "Password Reset Request", "User requested a password reset");

                JOptionPane.showMessageDialog(null, "A password reset token has been sent to your email: " + resetToken, "Password Reset", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Email not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// ✅ Generate Reset Token Method
private String generateResetToken() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder token = new StringBuilder();
    for (int i = 0; i < 10; i++) {
        int index = (int) (Math.random() * characters.length());
        token.append(characters.charAt(index));
    }
    return token.toString();

    }//GEN-LAST:event_fpMouseClicked

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Toregistration;
    private javax.swing.JLabel fp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    private void insertLog(int aInt, String password_Reset_Request, String user_requested_a_password_reset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
