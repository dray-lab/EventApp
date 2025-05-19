package security;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class ForgotPassword extends JFrame {

    private JTextField txtEmail;
    private JButton btnSendCode;
    private String userEmail;

    // Default constructor (normal usage)
    public ForgotPassword() {
        setTitle("Forgot Password");
        setSize(500, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel lblTitle = new JLabel("Forgot your Password", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(0, 0, 153));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextPane lblDesc = new JTextPane();
        lblDesc.setText("Don't worry - We've got you covered. Enter your email to reset your password.");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDesc.setForeground(new Color(0, 0, 102));
        lblDesc.setEditable(false);
        lblDesc.setFocusable(false);
        lblDesc.setOpaque(false);
        lblDesc.setBorder(null);
        lblDesc.setMaximumSize(new Dimension(400, 60));
        lblDesc.setAlignmentX(Component.CENTER_ALIGNMENT);

        StyledDocument doc = lblDesc.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.setBackground(Color.WHITE);
        emailPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailPanel.setMaximumSize(new Dimension(400, 60));

        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblEmail.setForeground(new Color(0, 51, 153));
        lblEmail.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        emailPanel.add(lblEmail);
        emailPanel.add(Box.createVerticalStrut(5));
        emailPanel.add(txtEmail);

        btnSendCode = new JButton("Send");
        btnSendCode.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSendCode.setBackground(new Color(0, 51, 204));
        btnSendCode.setForeground(Color.WHITE);
        btnSendCode.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSendCode.setFocusPainted(false);
        btnSendCode.addActionListener(e -> sendVerificationCode());

        panel.add(lblTitle);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblDesc);
        panel.add(Box.createVerticalStrut(20));
        panel.add(emailPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnSendCode);

        add(panel, BorderLayout.CENTER);
    }

    // Constructor for post-verification (prefill email)
    public ForgotPassword(String userEmail) {
        this(); // reuse UI setup from default constructor
        this.userEmail = userEmail;

        // Pre-fill the email field and optionally lock it
        txtEmail.setText(userEmail);
        txtEmail.setEditable(false); // lock email if you want
    }

    // Send email with verification code
    private void sendVerificationCode(String userEmail, String verificationCode) {
        final String senderEmail = "misadray3@gmail.com";  // Your Gmail
        final String senderPassword = "szphbqfzfyxudneh";   // App password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Your Verification Code");
            message.setText("Your verification code is: " + verificationCode);

            Transport.send(message);

            JOptionPane.showMessageDialog(this, "Verification code sent to your email.");
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to send email.");
        }
    }

    // When "Send" is clicked
    private void sendVerificationCode() {
        String userEmail = txtEmail.getText().trim();
        if (userEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email.");
            return;
        }

        // TODO: Check if email exists in database before sending

        String verificationCode = String.format("%06d", (int) (Math.random() * 1000000));
        sendVerificationCode(userEmail, verificationCode);

        // Open VerifyCode JFrame
        VerifyCode verifyFrame = new VerifyCode(verificationCode, userEmail);
        verifyFrame.setVisible(true);
        this.dispose();
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
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ForgotPassword().setVisible(true);
        });
    }

    private void initUI() {
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
