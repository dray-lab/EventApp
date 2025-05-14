package user;

import organizer.*;
import config.Session;
import config.dbConnector;
import eventapp.loginForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static javax.swing.text.html.HTML.Tag.SELECT;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class books extends javax.swing.JFrame {
   // running total of checkout amounts
private double totalAmount = 0.0;
// holds the running sum of amounts
private double runningTotal = 0.0;
    
    
    public books() {
        initComponents();
        displayEventData(); 
        initCheckoutTable();   // ← initialize the right‐hand table
        loadEventsToTable();
    }

    Color navcolor = new Color(0,51,204);
    Color hovercolor = new Color(255,153,153);
    
    private void initCheckoutTable() {
    String[] checkoutCols = { "Event Name", "Type", "Venue", "Amount", "Packages" };
    DefaultTableModel checkoutModel = new DefaultTableModel(null, checkoutCols);
    tableforCheckout.setModel(checkoutModel);
}
    
   private void insertEventToDatabase() {
    String name     = eventNameTextField.getText().trim();
    String type     = (String) eventTypeComboBox.getSelectedItem();
    String venue    = venueTextField.getText().trim();
    String amount   = AmountTextField.getText().trim();
    String packages = packageTextField.getText().trim();

    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();  // must be java.sql.Connection!

    // Check if event already exists
    String checkSQL = "SELECT COUNT(*) FROM events WHERE event_name = ?";
    try (PreparedStatement checkStmt = conn.prepareStatement(checkSQL)) {
        checkStmt.setString(1, name);
        ResultSet rs = checkStmt.executeQuery();
        
        if (rs.next() && rs.getInt(1) > 0) {
            // Event already exists, show message
            JOptionPane.showMessageDialog(this, "Event with this name already exists.");
            return;  // Exit the method without inserting the data
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "DB Error during checking: " + ex.getMessage());
        ex.printStackTrace();
        return;
    }

    // If no duplicate, insert the new event
    String sql = "INSERT INTO events (event_name, event_type, venue, amount, packages) "
               + "VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, name);
        pst.setString(2, type);
        pst.setString(3, venue);
        pst.setString(4, amount);
        pst.setString(5, packages);

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Event added successfully!");
            System.out.println("Event added successfully!");
            loadEventsToTable();  // Reload the events table
        } else {
            JOptionPane.showMessageDialog(this, "No event added.");
            System.out.println("No rows inserted.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "DB Error: " + ex.getMessage());
        ex.printStackTrace();  // Print the error stack to console for debugging
    }
}

private void loadEventsToTable() {
    String[] cols = { "ID", "Event Name", "Type", "Venue", "Amount", "Packages" };
    DefaultTableModel model = new DefaultTableModel(null, cols);
    
    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();

    String sql = "SELECT * FROM events";
    try (PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("event_name"),
                rs.getString("event_type"),
                rs.getString("venue"),
                rs.getString("amount"),
                rs.getString("packages")
            });
        }
        tableforEvents.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Failed to load events: " + ex.getMessage());
    }
}

private void addToCheckoutTable() {
    String name     = eventNameTextField.getText().trim();
    String type     = (String)eventTypeComboBox.getSelectedItem();
    String venue    = venueTextField.getText().trim();
    String amount   = AmountTextField.getText().trim();
    String packages = packageTextField.getText().trim();

    DefaultTableModel chk = (DefaultTableModel) tableforCheckout.getModel();

    // Prevent duplicates
    for (int i = 0; i < chk.getRowCount(); i++) {
        if (chk.getValueAt(i, 0).equals(name)) {
            JOptionPane.showMessageDialog(this, "This event is already in checkout.");
            return;
        }
    }

    // Add the row
    chk.addRow(new Object[]{ name, type, venue, amount, packages });

    try {
    double val = Double.parseDouble(amount);
    runningTotal += val;                                  // update the numeric total
    totalAmountField.setText(String.format("%.2f", runningTotal));  // push into the JTextField
} catch (NumberFormatException ex) {
    // handle bad number format if needed
}
}



    
    public void displayEventData() {
    try {
        dbConnector dbc = new dbConnector();
        ResultSet rs = dbc.getData("SELECT event_type, event_name, amount, venue FROM events");
        tableforEvents.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error loading event data: " + ex.getMessage());
    }
}
    
    public boolean eventDetailsToFields(String eventName) {
    dbConnector dbc = new dbConnector();

    try {
        String query = "SELECT * FROM events WHERE event_name = '" + eventName + "'";
        ResultSet rs = dbc.getData(query);

        if (rs.next()) {
            // Auto-fill form fields from the database
            eventIDTextField.setText(rs.getString("id"));
            eventNameTextField.setText(rs.getString("event_name"));
            eventTypeComboBox.setSelectedItem(rs.getString("event_type"));
            venueTextField.setText(rs.getString("venue"));
            AmountTextField.setText(rs.getString("amount"));
            packageTextField.setText(rs.getString("packages"));
            
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Event not found.");
            return false;
        }

    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex.getMessage());
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
        p = new javax.swing.JPanel();
        evnts = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        ac = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableforEvents = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        eventNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        eventTypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        venueTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eventIDTextField = new javax.swing.JTextField();
        edit = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        packageTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AmountTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableforCheckout = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JTextField();

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
        books.setText("RESERVATION");
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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        g.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel2.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

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

        jPanel2.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 40));

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

        jPanel2.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 190, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-account-100.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 100));

        ac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ac.setForeground(new java.awt.Color(255, 255, 255));
        ac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ac.setText("USER");
        jPanel2.add(ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        tableforEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableforEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableforEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableforEvents);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 380, 290));

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EDIT");
        edit.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 64, 24));

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

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CHECKOUT");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 80, 30));

        delete.setBackground(new java.awt.Color(0, 51, 204));
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DELETE");
        delete.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 62, 24));

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

        tableforCheckout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableforCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableforCheckoutMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableforCheckout);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 260, 290));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("TOTAL :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, -1, 30));

        totalAmountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalAmountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalAmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountFieldActionPerformed(evt);
            }
        });
        jPanel1.add(totalAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void evntsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseClicked
        eventFormAdmin efa = new eventFormAdmin();
        efa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evntsMouseClicked

    private void evntsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseEntered
        p.setBackground(hovercolor);
    }//GEN-LAST:event_evntsMouseEntered

    private void evntsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evntsMouseExited
        p.setBackground(navcolor);
    }//GEN-LAST:event_evntsMouseExited

    private void pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseEntered

    }//GEN-LAST:event_pMouseEntered

    private void pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseExited

    }//GEN-LAST:event_pMouseExited

    private void pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseClicked

    }//GEN-LAST:event_pMouseClicked

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered
        books.setBackground(hovercolor);
    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
        books.setBackground(navcolor);
    }//GEN-LAST:event_booksMouseExited

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
        attendeesForm atf = new attendeesForm();
        atf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_booksMouseClicked

    private void gMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_gMouseEntered

    private void gMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gMouseExited

    private void gMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gMouseClicked
       books bk = new books();
        bk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gMouseClicked

    private void settMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseEntered
        sett.setBackground(hovercolor);
    }//GEN-LAST:event_settMouseEntered

    private void settMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settMouseExited
        out.setBackground(navcolor);
    }//GEN-LAST:event_settMouseExited

    private void tMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tMouseEntered

    private void tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tMouseExited

    private void tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseClicked
       settings st = new settings();
       st.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_tMouseClicked

    private void outMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outMouseEntered
        out.setBackground(hovercolor);
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

    private void tableforEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableforEventsMouseClicked
    int i = tableforEvents.getSelectedRow();
    String selectedEventName = tableforEvents.getModel().getValueAt(i, 1).toString(); 
    eventDetailsToFields(selectedEventName); 
    }//GEN-LAST:event_tableforEventsMouseClicked

    private void eventNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventNameTextFieldActionPerformed

    private void eventIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventIDTextFieldActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
     insertEventToDatabase();  // save to DB
    loadEventsToTable();      // refresh left table
    addToCheckoutTable();     // append to right table
    }//GEN-LAST:event_addMouseClicked

    private void totalAmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountFieldActionPerformed

    private void tableforCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableforCheckoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableforCheckoutMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
       int selectedRow = tableforEvents.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        return;
    }

    // Get ID of selected event
    int id = Integer.parseInt(tableforEvents.getValueAt(selectedRow, 0).toString());

    // Get edited data from text fields
    String name = eventNameTextField.getText();
    String type = (String) eventTypeComboBox.getSelectedItem();
    String venue = venueTextField.getText();
    String amount = AmountTextField.getText();
    String packages = packageTextField.getText();

    // Update DB
    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();
    String sql = "UPDATE events SET event_name = ?, event_type = ?, venue = ?, amount = ?, packages = ? WHERE id = ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, name);
        pst.setString(2, type);
        pst.setString(3, venue);
        pst.setString(4, amount);
        pst.setString(5, packages);
        pst.setInt(6, id);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Event updated successfully!");
        loadEventsToTable(); // Reload the updated table
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Update failed: " + e.getMessage());
    }
    }//GEN-LAST:event_editMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int selectedRow = tableforEvents.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        return;
    }

    int id = Integer.parseInt(tableforEvents.getValueAt(selectedRow, 0).toString());

    int confirm = JOptionPane.showConfirmDialog(this, "Delete this event?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();
    
    String sql = "DELETE FROM events WHERE id=?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Event deleted.");
        loadEventsToTable();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Delete failed: " + e.getMessage());
    }
    }//GEN-LAST:event_deleteMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        DefaultTableModel model = (DefaultTableModel) tableforCheckout.getModel();

    dbConnector dbc = new dbConnector();
    Connection conn = (Connection) dbc.getConnection();

    for (int i = 0; i < model.getRowCount(); i++) {
        String eventName = (String) model.getValueAt(i, 0);
        String eventType = (String) model.getValueAt(i, 1);
        String amountStr = (String) model.getValueAt(i, 3);

        try {
            double amount = Double.parseDouble(amountStr);

            String sql = "INSERT INTO bookings (event_name, event_type, amount) VALUES (?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, eventName);
                pst.setString(2, eventType);
                pst.setDouble(3, amount);

                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount format: " + amountStr);
        }
    }

    JOptionPane.showMessageDialog(this, "Checkout completed and saved to bookings.");

    // Optional: clear the checkout table and total field
    model.setRowCount(0); // Clear table
    totalAmountField.setText("0.00"); // Reset amount field
    }//GEN-LAST:event_jLabel19MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
    if (sess.getUid() == 0) {
        // If uid == 0, it means the user is not logged in
        JOptionPane.showMessageDialog(null, "No account, Login First!");
        new loginForm().setVisible(true);
        this.dispose();
    }
    ac  .setText("" + sess.getFname());  
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTextField;
    private javax.swing.JLabel ac;
    private javax.swing.JPanel add;
    private javax.swing.JLabel books;
    private javax.swing.JPanel delete;
    private javax.swing.JPanel edit;
    private javax.swing.JTextField eventIDTextField;
    private javax.swing.JTextField eventNameTextField;
    private javax.swing.JComboBox<String> eventTypeComboBox;
    private javax.swing.JLabel evnts;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel out;
    private javax.swing.JPanel p;
    private javax.swing.JTextField packageTextField;
    private javax.swing.JPanel s;
    private javax.swing.JLabel sett;
    private javax.swing.JPanel t;
    private javax.swing.JTable tableforCheckout;
    private javax.swing.JTable tableforEvents;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JTextField venueTextField;
    // End of variables declaration//GEN-END:variables

    
}
