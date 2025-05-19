/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organizer;

import config.Session;
import config.dbConnector;
import eventapp.loginForm;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class adminDashboard extends javax.swing.JFrame {

    /** Creates new form adminDasboard */
    public adminDashboard() {
        initComponents();
         displayData();
         loadTotalUsers();
         loadTotalEvents();
         loadTotalBookings();
    }
    
    Color navcolor = new Color(0,51,204);
    Color hovercolor = new Color(255,153,153);

  public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        ResultSet rs = dbc.getData("SELECT *FROM bookings");
        tableBookings.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading bookings: " + e.getMessage());
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
            totalUser.setText(String.valueOf(totalUsers)); // Update the label with the total users
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading total users: " + e.getMessage());
        e.printStackTrace();
    }
}
    
     private void loadTotalEvents() {
    try {
        dbConnector dbc = new dbConnector();
        Connection conn = (Connection) dbc.getConnection();
        String sql = "SELECT COUNT(*) AS total_events FROM events"; // COUNT query to get the total number of users
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int totalUsers = rs.getInt("total_events"); // Get the count of users
            events.setText(String.valueOf(totalUsers)); // Update the label with the total users
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading total users: " + e.getMessage());
        e.printStackTrace();
    }
}

   
     private void loadTotalBookings() {
    try {
        dbConnector dbc = new dbConnector();
        Connection conn = (Connection) dbc.getConnection();
        String sql = "SELECT COUNT(*) AS total_booking FROM bookings"; // COUNT query to get the total number of users
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int totalUsers = rs.getInt("total_booking"); // Get the count of users
            Bookings.setText(String.valueOf(totalUsers)); // Update the label with the total users
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        acc_name = new javax.swing.JLabel();
        aot = new javax.swing.JPanel();
        attorg = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        p = new javax.swing.JPanel();
        evnts = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        l = new javax.swing.JPanel();
        logs = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        s = new javax.swing.JPanel();
        out = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        books = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        t = new javax.swing.JPanel();
        sett = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        totalUser = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        events = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Bookings = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookings = new javax.swing.JTable();

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

        acc_name.setBackground(new java.awt.Color(255, 255, 255));
        acc_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc_name.setForeground(new java.awt.Color(255, 255, 255));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("ORGANIZER");
        jPanel3.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, -1));

        aot.setBackground(new java.awt.Color(0, 51, 204));
        aot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aotMouseExited(evt);
            }
        });
        aot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attorg.setBackground(new java.awt.Color(255, 255, 255));
        attorg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        attorg.setForeground(new java.awt.Color(255, 255, 255));
        attorg.setText("ATTENDEES");
        attorg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                attorgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                attorgMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attorgMouseClicked(evt);
            }
        });
        aot.add(attorg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/useradmindash.png"))); // NOI18N
        aot.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(aot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 170, 40));

        p.setBackground(new java.awt.Color(0, 51, 204));
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pMouseExited(evt);
            }
        });
        p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        evnts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        evnts.setForeground(new java.awt.Color(255, 255, 255));
        evnts.setText("EVENTS");
        evnts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evntsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evntsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evntsMouseExited(evt);
            }
        });
        p.add(evnts, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 40));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eventsadmindash.png"))); // NOI18N
        p.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 170, 40));

        l.setBackground(new java.awt.Color(0, 51, 204));
        l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lMouseExited(evt);
            }
        });
        l.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logs.setForeground(new java.awt.Color(255, 255, 255));
        logs.setText("LOGS");
        logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsMouseExited(evt);
            }
        });
        l.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -2, 120, 40));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logs.png"))); // NOI18N
        l.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 170, 40));

        s.setBackground(new java.awt.Color(0, 51, 204));
        s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sMouseExited(evt);
            }
        });
        s.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        out.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        out.setForeground(new java.awt.Color(255, 255, 255));
        out.setText("LOGOUT");
        out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outMouseEntered(evt);
            }
        });
        s.add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 9, 120, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        s.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 170, 40));

        g.setBackground(new java.awt.Color(0, 51, 204));
        g.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gMouseExited(evt);
            }
        });
        g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        books.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        books.setForeground(new java.awt.Color(255, 255, 255));
        books.setText("BOOKING");
        books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksMouseExited(evt);
            }
        });
        g.add(books, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 120, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        g.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 170, 40));

        t.setBackground(new java.awt.Color(0, 51, 204));
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tMouseExited(evt);
            }
        });
        t.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sett.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sett.setForeground(new java.awt.Color(255, 255, 255));
        sett.setText("SETTING");
        sett.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settMouseExited(evt);
            }
        });
        t.add(sett, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 120, 20));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        t.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel3.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 170, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-account-100.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 470));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome to Drayenz Event System!");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 450, 30));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalUser.setForeground(new java.awt.Color(0, 51, 153));
        totalUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUser.setText("0");
        jPanel2.add(totalUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 20, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total Users");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-users-50.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 50, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 180, 150));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        events.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        events.setForeground(new java.awt.Color(0, 51, 153));
        events.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        events.setText("0");
        jPanel4.add(events, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 50, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText(" Events");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 30, 140, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-pending-48.png"))); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 50, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 180, 150));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bookings.png"))); // NOI18N
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 50, 50));

        Bookings.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Bookings.setForeground(new java.awt.Color(0, 51, 153));
        Bookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bookings.setText("0");
        jPanel5.add(Bookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 50, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Bookings");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 180, 150));

        tableBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "event_name", "event_type", "amount"
            }
        ));
        jScrollPane1.setViewportView(tableBookings);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 560, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
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
    acc_name.setText("" + sess.getFname());
    }//GEN-LAST:event_formWindowActivated

    private void sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sMouseClicked
    int userId = Session.getInstance().getUid();

if (userId != 0) {
    dbConnector db = new dbConnector();
    db.insertLog(userId, "Logout", "User logged out successfully");
}

// Show confirmation dialog before logging out
int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
    // Proceed with logout actions if user clicked 'Yes'
    Session session = Session.getInstance();
    session.setUid(0);
    session.setFname(null);
    session.setLname(null);
    session.setEmail(null);
    session.setUsername(null);
    session.setStatus(null);
    session.setType(null);

    loginForm login = new loginForm();
    login.setVisible(true);
    this.dispose();
} else {
    // Optionally, you can add logic here if the user chooses 'No' (like keeping the user logged in)
    System.out.println("Logout cancelled.");
}
    }//GEN-LAST:event_sMouseClicked

    private void sMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sMouseEntered
        s.setBackground(hovercolor);
    }//GEN-LAST:event_sMouseEntered

    private void sMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sMouseExited
        s.setBackground(navcolor);
    }//GEN-LAST:event_sMouseExited

    private void gMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseClicked
        bookings bk = new bookings();
        bk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gMouseClicked

    private void gMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseEntered
        g.setBackground(hovercolor);
    }//GEN-LAST:event_gMouseEntered

    private void gMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseExited
        g.setBackground(navcolor);
    }//GEN-LAST:event_gMouseExited

    private void tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseClicked
      settingsOrg so = new settingsOrg();
        so.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tMouseClicked

    private void tMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseEntered
         t.setBackground(hovercolor);
    }//GEN-LAST:event_tMouseEntered

    private void tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseExited
        t.setBackground(navcolor);
    }//GEN-LAST:event_tMouseExited

    private void lMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseExited
       l.setBackground(navcolor);
    }//GEN-LAST:event_lMouseExited

    private void lMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseEntered
      l.setBackground(hovercolor);
    }//GEN-LAST:event_lMouseEntered

    private void lMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseClicked
       
    }//GEN-LAST:event_lMouseClicked

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
       Logs lg = new Logs();
       lg.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void attorgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseExited
        aot.setBackground(navcolor);
    }//GEN-LAST:event_attorgMouseExited

    private void attorgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseEntered
        aot.setBackground(hovercolor);
    }//GEN-LAST:event_attorgMouseEntered

    private void attorgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_attorgMouseClicked

    private void pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseExited

    }//GEN-LAST:event_pMouseExited

    private void pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseEntered

    }//GEN-LAST:event_pMouseEntered

    private void pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseClicked
        eventFormAdmin ef = new eventFormAdmin();
        ef.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pMouseClicked

    private void evntsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseExited
        p.setBackground(navcolor);
    }//GEN-LAST:event_evntsMouseExited

    private void evntsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseEntered
        p.setBackground(hovercolor);
    }//GEN-LAST:event_evntsMouseEntered

    private void evntsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseClicked
        eventFormAdmin ef = new eventFormAdmin();
        ef.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evntsMouseClicked

    private void aotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseExited

    }//GEN-LAST:event_aotMouseExited

    private void aotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseEntered

    }//GEN-LAST:event_aotMouseEntered

    private void aotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aotMouseClicked

    private void logsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseEntered
       l.setBackground(hovercolor);
    }//GEN-LAST:event_logsMouseEntered

    private void logsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseExited
       l.setBackground(navcolor);
    }//GEN-LAST:event_logsMouseExited

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered
        books.setBackground(hovercolor);
    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
        books.setBackground(navcolor);
    }//GEN-LAST:event_booksMouseExited

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
       bookings bk = new bookings();
       bk.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_booksMouseClicked

    private void settMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseEntered
       sett.setBackground(hovercolor);
    }//GEN-LAST:event_settMouseEntered

    private void settMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseExited
      out.setBackground(navcolor);
    }//GEN-LAST:event_settMouseExited

    private void outMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outMouseEntered
      out.setBackground(hovercolor);
    }//GEN-LAST:event_outMouseEntered

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bookings;
    private javax.swing.JLabel acc_name;
    private javax.swing.JPanel aot;
    private javax.swing.JLabel attorg;
    private javax.swing.JLabel books;
    private javax.swing.JLabel events;
    private javax.swing.JLabel evnts;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel l;
    private javax.swing.JLabel logs;
    private javax.swing.JLabel out;
    private javax.swing.JPanel p;
    private javax.swing.JPanel s;
    private javax.swing.JLabel sett;
    private javax.swing.JPanel t;
    private javax.swing.JTable tableBookings;
    private javax.swing.JLabel totalUser;
    // End of variables declaration//GEN-END:variables

   
   
}
