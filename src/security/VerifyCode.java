package security;

import javax.swing.*;
import java.awt.*;

public class VerifyCode extends JFrame {

    private final String sentCode;
    private final String userEmail;
    private JTextField txtCode;
    private int attempts = 0;

    public VerifyCode(String sentCode, String userEmail) {
        this.sentCode = sentCode;
        this.userEmail = userEmail;

        setTitle("Verify Code");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel lblInstruction = new JLabel("Enter the code sent to your email:");
        lblInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtCode = new JTextField();
        txtCode.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JButton btnVerify = new JButton("Verify");
        btnVerify.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVerify.addActionListener(e -> verifyCode());

        panel.add(lblInstruction);
        panel.add(Box.createVerticalStrut(10));
        panel.add(txtCode);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnVerify);

        add(panel);
    }

    private void verifyCode() {
        String enteredCode = txtCode.getText().trim();
        attempts++;

        if (enteredCode.equals(sentCode)) {
            JOptionPane.showMessageDialog(this, "Verification successful.");
            new ChangePassword(userEmail).setVisible(true);
            dispose();
        } else {
            if (attempts >= 3) {
                JOptionPane.showMessageDialog(this, "Too many failed attempts. Try again later.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect verification code! Attempt " + attempts + "/3");
            }
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
       SwingUtilities.invokeLater(() -> new VerifyCode("123456", "user@example.com").setVisible(true));
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

