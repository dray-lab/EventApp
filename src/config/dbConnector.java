package config;

import java.sql.*;

import javax.swing.JOptionPane;

public class dbConnector {

    public static Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Connection connect;

    // constructor to connect to our database
    public dbConnector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventapp", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Function to save data
    public int insertData(String sql) {
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return 0;
        }
    }

    // Function to update data
    public void updateData(String sql) {
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }

    // Insert Log Method
    public void insertLog(int userId, String action, String details) {
        String sql = "INSERT INTO logs (u_id, actions, details, timestamp) VALUES (?, ?, ?, NOW())";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null || conn.isClosed()) {
                throw new SQLException("Database connection is not established.");
            }

            stmt.setInt(1, userId);
            stmt.setString(2, action);
            stmt.setString(3, details);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get connection
    public Connection getConnection() {
        return connect;
    }

    // Get count of records from a specific table
    public int getCount(String tableName) {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error getting count: " + ex.getMessage());
        }
        return 0;
    }

    // Get count of active users
    public int getActiveUsersCount() {
        String sql = "SELECT COUNT(*) FROM tbl_registeruser WHERE u_status = 'Active'";
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error getting active users count: " + ex.getMessage());
        }
        return 0;
    }

    // Get count of pending users
    public int getActiveUsersCount2() {
        String sql = "SELECT COUNT(*) FROM tbl_registeruser WHERE u_status = 'Pending'";
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error getting pending users count: " + ex.getMessage());
        }
        return 0;
    }
}
