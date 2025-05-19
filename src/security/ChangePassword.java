package security;

import javax.swing.*;
import java.awt.*;

public class ChangePassword extends JFrame {

    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;
    private String userEmail;

    public ChangePassword() {
        setTitle("Change Password");
        setSize(500, 320);
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

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(33, 150, 243));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblAppTitle = new JLabel("DRAYENZ EVENT MANAGEMENT");
        lblAppTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAppTitle.setForeground(Color.WHITE);
        headerPanel.add(lblAppTitle, BorderLayout.WEST);
        add(headerPanel, BorderLayout.NORTH);

        // Center Panel
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

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(4, 1, 0, 10));
        fieldPanel.setBackground(Color.WHITE);

        JLabel lblNewPass = new JLabel("New Password:");
        lblNewPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNewPass.setForeground(darkBlue);

        txtNewPassword = new JPasswordField();
        txtNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNewPassword.setPreferredSize(new Dimension(250, 35));

        JLabel lblConfirmPass = new JLabel("Confirm Password:");
        lblConfirmPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblConfirmPass.setForeground(darkBlue);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtConfirmPassword.setPreferredSize(new Dimension(250, 35));

        fieldPanel.add(lblNewPass);
        fieldPanel.add(txtNewPassword);
        fieldPanel.add(lblConfirmPass);
        fieldPanel.add(txtConfirmPassword);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        JButton btnChange = new JButton("Update Password");
        btnChange.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnChange.setBackground(darkBlue);
        btnChange.setForeground(Color.WHITE);
        btnChange.setFocusPainted(false);
        btnChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnChange.setPreferredSize(new Dimension(180, 40));
        btnChange.addActionListener(e -> changePassword());

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

        // TODO: Update password in database using userEmail
        JOptionPane.showMessageDialog(this, "Password successfully changed.");
        dispose();
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
