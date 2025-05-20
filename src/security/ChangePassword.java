package security;

import config.dbConnector;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class ChangePassword extends JFrame {

    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;
    private String userEmail;

    public ChangePassword() {
        setTitle("Change Password");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        initUI();
    }

    public ChangePassword(String userEmail) {
        this(); // Call default constructor
        this.userEmail = userEmail;
    }

    private void initUI() {
        Color darkBlue = new Color(13, 71, 161);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(33, 150, 243));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblAppTitle = new JLabel("DRAYENZ EVENT MANAGEMENT");
        lblAppTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAppTitle.setForeground(Color.WHITE);
        headerPanel.add(lblAppTitle, BorderLayout.WEST);
        add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel lblHeading = new JLabel("Change your Password");
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblHeading.setForeground(darkBlue);
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Please enter your new password below.");
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSub.setForeground(new Color(100, 181, 246));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel fieldPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        fieldPanel.setBackground(Color.WHITE);

        JLabel lblNewPass = new JLabel("New Password:");
        lblNewPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNewPass.setForeground(darkBlue);
        txtNewPassword = new JPasswordField();

        JLabel lblConfirmPass = new JLabel("Confirm Password:");
        lblConfirmPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblConfirmPass.setForeground(darkBlue);
        txtConfirmPassword = new JPasswordField();

        fieldPanel.add(lblNewPass);
        fieldPanel.add(txtNewPassword);
        fieldPanel.add(lblConfirmPass);
        fieldPanel.add(txtConfirmPassword);

        JButton btnChange = new JButton("Update Password");
        btnChange.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnChange.setBackground(darkBlue);
        btnChange.setForeground(Color.WHITE);
        btnChange.setFocusPainted(false);
        btnChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnChange.setPreferredSize(new Dimension(180, 40));
        btnChange.addActionListener(e -> changePassword());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnChange);

        centerPanel.add(lblHeading);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(lblSub);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(fieldPanel);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(buttonPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void changePassword() {
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        if (newPassword.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters.");
            return;
        }

        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        updatePasswordInDatabase(userEmail, hashedPassword);
        insertLog(userEmail, "Password Change", "Password changed successfully");

        JOptionPane.showMessageDialog(this, "Password successfully changed.");
        dispose();
    }

    private void updatePasswordInDatabase(String userEmail, String hashedPassword) {
        String sql = "UPDATE tbl_registeruser SET u_password = ? WHERE u_email = ?";
        try (Connection conn = new dbConnector().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hashedPassword);
            stmt.setString(2, userEmail);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating password. Please try again.");
        }
    }

    private void insertLog(String userEmail, String action, String details) {
    String getUserIdSQL = "SELECT u_id FROM tbl_registeruser WHERE u_email = ?";
    String insertLogSQL = "INSERT INTO logs (u_id, actions, details, timestamp) VALUES (?, ?, ?, NOW())";

    try (Connection conn = new dbConnector().getConnection();
         PreparedStatement getIdStmt = conn.prepareStatement(getUserIdSQL)) {

        getIdStmt.setString(1, userEmail);
        ResultSet rs = getIdStmt.executeQuery();

        if (rs.next()) {
            int userId = rs.getInt("u_id");

            try (PreparedStatement insertStmt = conn.prepareStatement(insertLogSQL)) {
                insertStmt.setInt(1, userId);
                insertStmt.setString(2, action);
                insertStmt.setString(3, details);
                insertStmt.executeUpdate();
            }
        } else {
            System.err.println("User ID not found for email: " + userEmail);
            // Optionally, show a message or silently ignore
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         SwingUtilities.invokeLater(() -> new ChangePassword("user@example.com").setVisible(true));
    }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
