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


/**
 *
 * @author user
 */
public class bookings extends javax.swing.JFrame {
    
    private int selectedEventId = -1;

    
    public bookings() {
        initComponents();
        loadEventsToTable();
        loadBookingsToTable();   
 }

     Color navcolor = new Color(0,51,204);
    Color hovercolor = new Color(255,153,153);
    
    dbConnector db = new dbConnector();
Connection conn = db.getConnection();

    
    private void addTableMouseListener() {
        tableforEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tableforEvents.getSelectedRow();
                if (selectedRow >= 0) {
                    // Assuming first column is event ID
                    Object eventIdObj = tableforEvents.getValueAt(selectedRow, 0);
                    if (eventIdObj != null) {
                        int selectedEventId = Integer.parseInt(eventIdObj.toString());
                        System.out.println("Selected Event ID: " + selectedEventId);
                        // You can store selectedEventId in a class field if needed
                    }
                }
            }
        });
    }
    
  private void loadEventsToTable() {
    String[] columns = {"ID", "Event Name", "Event Type", "Venue", "Amount", "Packages"};
    DefaultTableModel model = new DefaultTableModel(null, columns);

      try (Connection conn = db.getConnection();
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM events");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("event_name"),
                rs.getString("event_type"),
                rs.getString("venue"),
                rs.getDouble("amount"),
                rs.getString("packages")
            };
            model.addRow(row);
        }

        tableforEvents.setModel(model);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading events: " + ex.getMessage());
    }
}


   
  
   
  private void loadBookingsToTable() {
    String[] columns = {"ID", "Customer Name", "Event Name", "Event Type", "Amount"};
    DefaultTableModel model = new DefaultTableModel(null, columns);

    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();

    String sql = "SELECT * FROM bookings";

    try (PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("user_name"),
                rs.getString("event_name"),
                rs.getString("event_type"),  // Changed from getDouble to getString
                rs.getDouble("amount")
            };
            model.addRow(row);
        }

        tableforBookings.setModel(model);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading bookings: " + ex.getMessage());
    }
}
  
    private void loadEvents() {
    String query = "SELECT * FROM events ORDER BY created_at DESC"; // or whatever order you want

    // Create instance of dbConnector
    dbConnector db = new dbConnector();

    try (Connection conn = db.getConnection()) {
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            return;
        }

        try (PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            // Use a DefaultTableModel to populate the JTable
            DefaultTableModel model = (DefaultTableModel) tableforEvents.getModel();
            model.setRowCount(0);  // Clear existing rows

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),  // or event_id or your PK column
                    rs.getInt("u_id"),
                    rs.getString("event_name"),
                    rs.getString("event_type"),
                    rs.getString("venue"),
                    rs.getDouble("amount"),
                    rs.getString("packages"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                };
                model.addRow(row);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading events: " + e.getMessage());
        e.printStackTrace();
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
        aot = new javax.swing.JPanel();
        attorg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p = new javax.swing.JPanel();
        evnts = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l = new javax.swing.JPanel();
        logs = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        books = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t = new javax.swing.JPanel();
        sett = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        s = new javax.swing.JPanel();
        out = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        acc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        eventNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        eventTypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        venueTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eventIDTextField = new javax.swing.JTextField();
        edit = new javax.swing.JPanel();
        editEvent = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        packageTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AmountTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        Print = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        deleteEvents = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableforEvents = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableforBookings = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        aot.add(attorg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/useradmindash.png"))); // NOI18N
        aot.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(aot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 40));

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
        p.add(evnts, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eventsadmindash.png"))); // NOI18N
        p.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 40));

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
        l.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 120, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logs.png"))); // NOI18N
        l.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

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
        books.setText("BOOKINGS");
        books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksMouseClicked(evt);
            }
        });
        g.add(books, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 120, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        g.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 40));

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

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        t.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, 40));

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
        s.add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 11, 140, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        s.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 190, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-account-100.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 100));

        acc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc.setForeground(new java.awt.Color(255, 255, 255));
        acc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc.setText("ORGANIZER");
        jPanel2.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        jLabel11.setText("Event Name :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 80, 30));

        eventNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(eventNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 220, 30));

        jLabel12.setText("Event Type :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 80, 30));

        eventTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ocassions", "Entertainment" }));
        jPanel1.add(eventTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 220, 30));

        jLabel10.setText("Event Venue :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 80, 30));
        jPanel1.add(venueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 220, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Event ID :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, 30));

        eventIDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eventIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventIDTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(eventIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 70, 30));

        edit.setBackground(new java.awt.Color(0, 51, 204));
        edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editEvent.setForeground(new java.awt.Color(255, 255, 255));
        editEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editEvent.setText("EDIT");
        editEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editEventMouseClicked(evt);
            }
        });
        edit.add(editEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 64, 24));

        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 70, 30));

        add.setBackground(new java.awt.Color(0, 51, 204));
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ADD");
        add.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 10));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 70, 30));

        jLabel17.setText("Packages :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 90, 30));
        jPanel1.add(packageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 230, 100));

        jLabel18.setText("Amount :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 80, 30));
        jPanel1.add(AmountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 220, 30));

        jPanel8.setBackground(new java.awt.Color(0, 51, 204));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Print.setText("PRINT");
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
        });
        jPanel8.add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 80, 30));

        delete.setBackground(new java.awt.Color(0, 51, 204));
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteEvents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteEvents.setForeground(new java.awt.Color(255, 255, 255));
        deleteEvents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteEvents.setText("DELETE");
        deleteEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteEventsMouseClicked(evt);
            }
        });
        delete.add(deleteEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 62, 24));

        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 70, 30));

        jPanel10.setBackground(new java.awt.Color(0, 51, 204));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("DELETE");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 10));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 70, 30));

        tableforEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Event Name ", "Event Type ", "Venue", "Amount", "Packages"
            }
        ));
        tableforEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableforEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableforEvents);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, 280));

        tableforBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableforBookings);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 240, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void attorgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseEntered
       
    }//GEN-LAST:event_attorgMouseEntered

    private void attorgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseExited
       
    }//GEN-LAST:event_attorgMouseExited

    private void attorgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attorgMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_attorgMouseClicked

    private void aotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseEntered
        aot.setBackground(hovercolor);
    }//GEN-LAST:event_aotMouseEntered

    private void aotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseExited
        aot.setBackground(navcolor);
    }//GEN-LAST:event_aotMouseExited

    private void aotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aotMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aotMouseClicked

    private void evntsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseClicked
        eventFormAdmin efa = new eventFormAdmin();
        efa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evntsMouseClicked

    private void evntsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseEntered
       
    }//GEN-LAST:event_evntsMouseEntered

    private void evntsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseExited
       
    }//GEN-LAST:event_evntsMouseExited

    private void pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseEntered
        p.setBackground(hovercolor);
    }//GEN-LAST:event_pMouseEntered

    private void pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseExited
        p.setBackground(navcolor);
    }//GEN-LAST:event_pMouseExited

    private void pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseClicked

    }//GEN-LAST:event_pMouseClicked

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        Logs lg = new Logs();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void logsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseEntered
        
    }//GEN-LAST:event_logsMouseEntered

    private void logsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseExited
       
    }//GEN-LAST:event_logsMouseExited

    private void lMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseEntered
        l.setBackground(hovercolor);
    }//GEN-LAST:event_lMouseEntered

    private void lMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseExited
        l.setBackground(navcolor);
    }//GEN-LAST:event_lMouseExited

    private void lMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseClicked
        Logs lg = new Logs();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lMouseClicked

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered
        
    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
       
    }//GEN-LAST:event_booksMouseExited

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_booksMouseClicked

    private void gMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseEntered
        g.setBackground(hovercolor);
    }//GEN-LAST:event_gMouseEntered

    private void gMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseExited
        g.setBackground(navcolor);
    }//GEN-LAST:event_gMouseExited

    private void gMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseClicked
       bookings bk = new bookings();
        bk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gMouseClicked

    private void settMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseEntered
        
    }//GEN-LAST:event_settMouseEntered

    private void settMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseExited
       
    }//GEN-LAST:event_settMouseExited

    private void tMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseEntered
       t.setBackground(hovercolor);
    }//GEN-LAST:event_tMouseEntered

    private void tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseExited
        t.setBackground(navcolor);
    }//GEN-LAST:event_tMouseExited

    private void tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseClicked
       settingsOrg so = new settingsOrg();
        so.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tMouseClicked

    private void outMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outMouseEntered
        
    }//GEN-LAST:event_outMouseEntered

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

    private void eventNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventNameTextFieldActionPerformed

    private void eventIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventIDTextFieldActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
                              
    // Get data from input fields
    String eventName = eventNameTextField.getText();
    String eventType = eventTypeComboBox.getSelectedItem().toString();
    String venue = venueTextField.getText();
    String amountText = AmountTextField.getText();
    String packages = packageTextField.getText();

    // Basic input validation
    if (eventName.isEmpty() || eventType.isEmpty() || venue.isEmpty() || amountText.isEmpty() || packages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        return;
    }

    try {
        double amount = Double.parseDouble(amountText); // validate amount is numeric

        // Assuming you have the logged-in user's ID somewhere accessible
        int userId = 1; // Replace with actual logged-in user's ID

        String sql = "INSERT INTO events (u_id, event_name, event_type, venue, amount, packages, created_at, updated_at) "
                   + "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";

        // Create an instance of dbConnector
        dbConnector db = new dbConnector();

        try (Connection conn = db.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return;
            }

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                // Set parameters - order matters!
                pst.setInt(1, userId);
                pst.setString(2, eventName);
                pst.setString(3, eventType);
                pst.setString(4, venue);
                pst.setDouble(5, amount);
                pst.setString(6, packages);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Event added successfully!");
                    clearFields(); // reset form after success
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add event.");
                }
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Amount must be a valid number.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        e.printStackTrace();
    }
}

// Add this method in your class, outside the above method
private void clearFields() {
    eventNameTextField.setText("");
    eventTypeComboBox.setSelectedIndex(0);
    venueTextField.setText("");
    AmountTextField.setText("");
    packageTextField.setText("");

    



    }//GEN-LAST:event_addMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
       
    }//GEN-LAST:event_editMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
   
    }//GEN-LAST:event_deleteMouseClicked

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseClicked
    int selectedRow = tableforBookings.getSelectedRow(); // Make sure bookingsTable is your JTable name

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a booking to print.");
        return;
    }

    // Assuming the booking ID is in column 0
    int bookingId = Integer.parseInt(tableforBookings.getValueAt(selectedRow, 0).toString());

    // Open the receiptPrint JFrame with bookingId
    receiptPrint receipt = new receiptPrint(bookingId);
    receipt.setVisible(true);
    
    }//GEN-LAST:event_PrintMouseClicked

    private void editEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editEventMouseClicked
        // Get data from input fields (ensure all these components are declared)
    String eventName = eventNameTextField.getText();
    String eventType = eventTypeComboBox.getSelectedItem().toString();
    String venue = venueTextField.getText();
    String amountText = AmountTextField.getText();
    String packages = packageTextField.getText();

    // Basic input validation
    if (eventName.isEmpty() || eventType.isEmpty() || venue.isEmpty() || amountText.isEmpty() || packages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        return;
    }

    try {
        double amount = Double.parseDouble(amountText); // validate amount is numeric

        if (selectedEventId == -1) {
            JOptionPane.showMessageDialog(null, "Please select an event to edit.");
            return;
        }

        String sql = "UPDATE events SET event_name = ?, event_type = ?, venue = ?, amount = ?, packages = ? WHERE id = ?";
       dbConnector db = new dbConnector();
       Connection conn = db.getConnection();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, eventName);
        pst.setString(2, eventType);
        pst.setString(3, venue);
        pst.setDouble(4, amount);
        pst.setString(5, packages);
        pst.setInt(6, selectedEventId); // make sure this is set when a row is clicked

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Event updated successfully!");
            clearFields(); // Optional: reset form
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update event.");
        }

        pst.close();
        conn.close();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Amount must be a valid number.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
    }//GEN-LAST:event_editEventMouseClicked

    private void deleteEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteEventsMouseClicked
         int selectedRow = tableforEvents.getSelectedRow();

    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(null, "Please select an event to delete.");
        return;
    }

    // Get the event ID from the first column
    Object eventIdObj = tableforEvents.getValueAt(selectedRow, 0);
    if (eventIdObj == null) {
        JOptionPane.showMessageDialog(null, "Selected event ID not found.");
        return;
    }

    int eventId = Integer.parseInt(eventIdObj.toString());

    int confirm = JOptionPane.showConfirmDialog(
        null,
        "Are you sure you want to delete this event?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Create dbConnector instance
            dbConnector db = new dbConnector();
            Connection conn = db.getConnection(); // Assuming this method returns a valid connection

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return;
            }

            String sql = "DELETE FROM events WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, eventId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Event deleted successfully.");
                loadEvents();       // Refresh table
                clearFields();      // Clear input fields
                selectedEventId = -1; // Reset selection
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete event.");
            }

            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting event: " + e.getMessage());
            e.printStackTrace();
        }
    }

    }//GEN-LAST:event_deleteEventsMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
    if (sess.getUid() == 0) {
        // If uid == 0, it means the user is not logged in
        JOptionPane.showMessageDialog(null, "No account, Login First!");
        new loginForm().setVisible(true);
        this.dispose();
    }
    acc.setText("" + sess.getFname());
    }//GEN-LAST:event_formWindowActivated

    private void tableforEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableforEventsMouseClicked
       
       
    int selectedRow = tableforEvents.getSelectedRow();

    if (selectedRow >= 0) {
        selectedEventId = Integer.parseInt(tableforEvents.getValueAt(selectedRow, 0).toString());
        eventNameTextField.setText(tableforEvents.getValueAt(selectedRow, 1).toString());
        eventTypeComboBox.setSelectedItem(tableforEvents.getValueAt(selectedRow, 2).toString());
        venueTextField.setText(tableforEvents.getValueAt(selectedRow, 3).toString());
        AmountTextField.setText(tableforEvents.getValueAt(selectedRow, 4).toString());
        packageTextField.setText(tableforEvents.getValueAt(selectedRow, 5).toString());

        System.out.println("Selected Event ID: " + selectedEventId); // for debug
    }


    }//GEN-LAST:event_tableforEventsMouseClicked

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
            java.util.logging.Logger.getLogger(bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTextField;
    private javax.swing.JLabel Print;
    private javax.swing.JLabel acc;
    private javax.swing.JPanel add;
    private javax.swing.JPanel aot;
    private javax.swing.JLabel attorg;
    private javax.swing.JLabel books;
    private javax.swing.JPanel delete;
    private javax.swing.JLabel deleteEvents;
    private javax.swing.JPanel edit;
    private javax.swing.JLabel editEvent;
    private javax.swing.JTextField eventIDTextField;
    private javax.swing.JTextField eventNameTextField;
    private javax.swing.JComboBox<String> eventTypeComboBox;
    private javax.swing.JLabel evnts;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel l;
    private javax.swing.JLabel logs;
    private javax.swing.JLabel out;
    private javax.swing.JPanel p;
    private javax.swing.JTextField packageTextField;
    private javax.swing.JPanel s;
    private javax.swing.JLabel sett;
    private javax.swing.JPanel t;
    private javax.swing.JTable tableforBookings;
    private javax.swing.JTable tableforEvents;
    private javax.swing.JTextField venueTextField;
    // End of variables declaration//GEN-END:variables

    private settingsOrg settingsOrg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}