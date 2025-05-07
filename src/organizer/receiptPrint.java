package organizer;

import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class receiptPrint extends JFrame {

    private JPanel panel;

    public receiptPrint(int bookingId) {
        setTitle("Receipt");
        setSize(400, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        try {
            dbConnector db = new dbConnector();
            Connection con = db.connect;

            // SQL query to retrieve booking and user info
            String query =
                "SELECT b.event_name, b.event_type, b.amount, " +
                "u.u_fname, u.u_lname, u.u_email " +
                "FROM bookings b " +
                "JOIN tbl_registeruser u ON b.id = u.u_id " +
                "WHERE b.id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Fonts
                Font titleFont = new Font("Monospaced", Font.BOLD, 18);
                Font normalFont = new Font("Monospaced", Font.PLAIN, 13);
                Font boldFont = new Font("Monospaced", Font.BOLD, 13);

                // Title - DRAYENZ EVENT MANAGEMENT
                JLabel title = new JLabel("DRAYENZ EVENT MANAGEMENT", SwingConstants.CENTER);
                title.setFont(titleFont);
                title.setBounds(0, 20, 400, 30);
                panel.add(title);

                // Quote - Centered under the title
                JLabel quote = new JLabel("\"Your Event, Our Passion\"", SwingConstants.CENTER);
                quote.setFont(new Font("Monospaced", Font.ITALIC, 14));
                quote.setBounds(0, 50, 400, 20);
                panel.add(quote);

                // Receipt ID
                JLabel receiptId = new JLabel("Receipt #: " + bookingId);
                receiptId.setFont(normalFont);
                receiptId.setBounds(20, 80, 300, 20);
                panel.add(receiptId);

                // Divider
                JLabel divider1 = new JLabel("----------------------------------------");
                divider1.setFont(normalFont);
                divider1.setBounds(20, 100, 360, 20);
                panel.add(divider1);

                // Headers
                JLabel headers = new JLabel("QTY   DESCRIPTION         PRICE   AMOUNT");
                headers.setFont(boldFont);
                headers.setBounds(20, 120, 360, 20);
                panel.add(headers);

                // Item Line
                int qty = 1;
                String desc = rs.getString("event_name");
                double price = rs.getDouble("amount");
                double total = price;

                JLabel itemLine = new JLabel(String.format("%-5s %-18s %6.2f %8.2f", qty, desc, price, total));
                itemLine.setFont(normalFont);
                itemLine.setBounds(20, 140, 360, 20);
                panel.add(itemLine);

                // Divider
                JLabel divider2 = new JLabel("----------------------------------------");
                divider2.setFont(normalFont);
                divider2.setBounds(20, 170, 360, 20);
                panel.add(divider2);

                // Subtotal and Tax
                double subtotal = total / 1.05;
                double tax = total - subtotal;

                JLabel subtotalLabel = new JLabel(String.format("Subtotal:%32.2f", subtotal));
                subtotalLabel.setFont(normalFont);
                subtotalLabel.setBounds(20, 200, 360, 20);
                panel.add(subtotalLabel);

                JLabel taxLabel = new JLabel(String.format("Sales Tax (5%%):%25.2f", tax));
                taxLabel.setFont(normalFont);
                taxLabel.setBounds(20, 220, 360, 20);
                panel.add(taxLabel);

                JLabel totalLabel = new JLabel(String.format("TOTAL:%35.2f", total));
                totalLabel.setFont(boldFont);
                totalLabel.setBounds(20, 250, 360, 25);
                panel.add(totalLabel);

                // Divider
                JLabel divider3 = new JLabel("----------------------------------------");
                divider3.setFont(normalFont);
                divider3.setBounds(20, 280, 360, 20);
                panel.add(divider3);

                // User Info
                String fullName = rs.getString("u_fname") + " " + rs.getString("u_lname");
                String email = rs.getString("u_email");

                JLabel userLabel = new JLabel("Billed To:");
                userLabel.setFont(boldFont);
                userLabel.setBounds(20, 310, 360, 20);
                panel.add(userLabel);

                JLabel nameLabel = new JLabel("Name: " + fullName);
                nameLabel.setFont(normalFont);
                nameLabel.setBounds(20, 330, 360, 20);
                panel.add(nameLabel);

                JLabel emailLabel = new JLabel("Email: " + email);
                emailLabel.setFont(normalFont);
                emailLabel.setBounds(20, 350, 360, 20);
                panel.add(emailLabel);

                // Footer
                JLabel footer = new JLabel("Thank you for choosing Drayenz!", SwingConstants.CENTER);
                footer.setFont(normalFont);
                footer.setBounds(20, 380, 360, 30);
                panel.add(footer);

                JLabel contact = new JLabel("support@eventapp.com", SwingConstants.CENTER);
                contact.setFont(normalFont);
                contact.setBounds(20, 410, 360, 20);
                panel.add(contact);

                // Print Button - Positioned at the bottom-right corner
                JButton printButton = new JButton("Print");
                printButton.setBounds(280, 450, 100, 30);
                printButton.addActionListener(e -> printReceipt());
                panel.add(printButton);

            } else {
                JOptionPane.showMessageDialog(this, "Booking ID not found.");
                dispose();
                return;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading receipt: " + e.getMessage());
        }

        add(panel);
        setVisible(true);
    }

    // Method to print the receipt
    private void printReceipt() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable((Graphics g, PageFormat pf, int pageIndex) -> {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            // Set up the graphics object
            g.translate((int) pf.getImageableX(), (int) pf.getImageableY());
            panel.paint(g); // Print the panel contents

            return PAGE_EXISTS;
        });

        // Show print dialog and print if user agrees
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error printing receipt: " + e.getMessage());
            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new receiptPrint(1));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
