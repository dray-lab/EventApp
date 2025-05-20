package config;

import org.mindrot.jbcrypt.BCrypt;

public class passwordHasher {
    // Hash a password using BCrypt
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verify a plaintext password against a hashed password
    public static boolean verifyPassword(String password, String hashed) {
        if (hashed == null || !hashed.startsWith("$2")) {
            // Not a BCrypt hash, handle accordingly or return false
            return false;
        }
        return BCrypt.checkpw(password, hashed);
    }
}
