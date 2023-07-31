package csd.architecture.onionapi.abstractions.users;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordHelper {
    public static String hash(String password, String salt){
        if(password == null || salt == null)
            return null;

        String sha256hex = Hashing.sha256()
                .hashString(password + salt, StandardCharsets.UTF_8)
                .toString();
        return Base64.getEncoder().encodeToString(sha256hex.getBytes());
    }
}
