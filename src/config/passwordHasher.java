package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class passwordHasher {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    // ✅ Add this method to verify passwords
    public static boolean verifyPassword(String enteredPassword, String storedHashedPassword) throws NoSuchAlgorithmException {
        return hashPassword(enteredPassword).equals(storedHashedPassword);
    }

    public static boolean checkPassword(String password, String storedHashedPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}