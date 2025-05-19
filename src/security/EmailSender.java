package security;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static boolean sendEmail(List<String> toEmails, String code) {
        String fromEmail = "misadray3@gmail.com"; // your email
        String password = ""; // your app password (DO NOT hardcode in real apps)

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail, "Your App Name"));

            // Convert List to InternetAddress array
            InternetAddress[] addressArray = new InternetAddress[toEmails.size()];
            for (int i = 0; i < toEmails.size(); i++) {
                addressArray[i] = new InternetAddress(toEmails.get(i));
            }

            msg.setRecipients(Message.RecipientType.TO, addressArray);
            msg.setSubject("Password Reset Code");
            msg.setText("Your verification code is: " + code);

            Transport.send(msg);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
