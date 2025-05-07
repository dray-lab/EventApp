/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.dbConnector;
import eventapp.loginForm;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import organizer.bookings;

/**
 *
 * @author user
 */
public class userDashboard extends javax.swing.JFrame {

    /**
     * Creates new form userDashboard
     */
    public userDashboard() {
        initComponents();
        loadEventsToTable();
        loadTotalUsers();
    }
    
    Color navcolor = new Color(51,0,102);
    Color hovercolor = new Color(153,153,255);

    
    private void loadEventsToTable() {
    try {
        dbConnector dbc = new dbConnector();
        Connection conn = (Connection) dbc.getConnection();
        String sql = "SELECT * FROM events";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Set table column names
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {
            "ID", "Event Type", "Event Name", "Amount", "Venue", "Packages"
        });

        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getInt("id"),
                rs.getString("event_type"),
                rs.getString("event_name"),
                rs.getDouble("amount"),
                rs.getString("venue"),
                rs.getString("packages")
            });
        }

        evetsTable.setModel(model);

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading events: " + e.getMessage());
        e.printStackTrace();
    }
}
    
    private void loadTotalUsers() {
    try {
        dbConnector dbc = new dbConnector();
        Connection conn = (Connection) dbc.getConnection();
        String sql = "SELECT COUNT(*) AS total_users FROM tbl_registeruser"; // COUNT query to get the total number of users
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int totalUsers = rs.getInt("total_users"); // Get the count of users
            jLabel13.setText(String.valueOf(totalUsers)); // Update the label with the total users
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading total users: " + e.getMessage());
        e.printStackTrace();
    }
}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ev = new javax.swing.JPanel();
        events = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        account = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sett = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        acct_name1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        evetsTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lo.setBackground(new java.awt.Color(0, 51, 204));
        lo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loMouseExited(evt);
            }
        });
        lo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOGOUT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        lo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        lo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(lo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 160, 40));

        ev.setBackground(new java.awt.Color(0, 51, 204));
        ev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evMouseExited(evt);
            }
        });
        ev.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        events.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        events.setForeground(new java.awt.Color(255, 255, 255));
        events.setText("EVENTS");
        events.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventsMouseClicked(evt);
            }
        });
        ev.add(events, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eventsadmindash.png"))); // NOI18N
        ev.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(ev, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 40));

        account.setBackground(new java.awt.Color(0, 51, 204));
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountMouseExited(evt);
            }
        });
        account.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RESERVATION");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        account.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        account.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 170, 40));

        sett.setBackground(new java.awt.Color(0, 51, 204));
        sett.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settMouseExited(evt);
            }
        });
        sett.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SETTINGS");
        sett.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        sett.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(sett, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, 40));

        acct_name1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acct_name1.setForeground(new java.awt.Color(255, 255, 255));
        acct_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acct_name1.setText("USER");
        jPanel3.add(acct_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 170, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-account-100.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 90));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 470));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Total Users");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 100, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("0");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 20, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("0");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 20, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Reservation");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 140, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Welcome to Drayenz Event System!");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 450, 30));

        evetsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(evetsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 570, 210));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bookings.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 60, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-users-50.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 60, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgforadmin.jpg"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 180, 150));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgforadmin.jpg"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 180, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
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
    if (sess.getUid() == 0) {
        // If uid == 0, it means the user is not logged in
        JOptionPane.showMessageDialog(null, "No account, Login First!");
        new loginForm().setVisible(true);
        this.dispose();
    }
    acct_name1.setText("" + sess.getFname());                            
    }//GEN-LAST:event_formWindowActivated

    private void settMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseExited
        sett.setBackground(navcolor);
    }//GEN-LAST:event_settMouseExited

    private void settMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseEntered
        sett.setBackground(hovercolor);
    }//GEN-LAST:event_settMouseEntered

    private void settMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseClicked
       settings st = new settings();
       st.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_settMouseClicked

    private void accountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseExited
        account.setBackground(navcolor);
    }//GEN-LAST:event_accountMouseExited

    private void accountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseEntered
        account.setBackground(hovercolor);
    }//GEN-LAST:event_accountMouseEntered

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
       books bs = new books();
       bs.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_accountMouseClicked

    private void evMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evMouseExited
        ev.setBackground(navcolor);
    }//GEN-LAST:event_evMouseExited

    private void evMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evMouseEntered
        ev.setBackground(hovercolor);

    }//GEN-LAST:event_evMouseEntered

    private void loMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseExited
        lo.setBackground(navcolor);
    }//GEN-LAST:event_loMouseExited

    private void loMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseEntered
        lo.setBackground(hovercolor);
    }//GEN-LAST:event_loMouseEntered

    private void loMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseClicked
        int userId = Session.getInstance().getUid();

        dbConnector db = new dbConnector();
        db.insertLog(userId, "Logout", "User logged out successfully");

        Session.getInstance().setUid(0);
        Session.getInstance().setFname(null);
        Session.getInstance().setLname(null);
        Session.getInstance().setEmail(null);
        Session.getInstance().setUsername(null);
        Session.getInstance().setStatus(null);
        Session.getInstance().setType(null);

        loginForm login = new loginForm();
        login.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_loMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loginForm lf = new loginForm();
        JOptionPane.showMessageDialog(null, "Logged-out!");
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       books bs = new books();
       bs.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void eventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventsMouseClicked
         eventFormuser evf = new eventFormuser();
        evf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_eventsMouseClicked

    private void evMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evMouseClicked
       eventFormuser evf = new eventFormuser();
        evf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evMouseClicked

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
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel account;
    private javax.swing.JLabel acct_name1;
    private javax.swing.JPanel ev;
    private javax.swing.JLabel events;
    private javax.swing.JTable evetsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lo;
    private javax.swing.JPanel sett;
    // End of variables declaration//GEN-END:variables
}
