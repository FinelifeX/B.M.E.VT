package helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Bulat Murtazin on 19.12.2017 -> 23:13
 * KPFU ITIS 11-601
 **/


public class PasswordHasher {

    public static String getHashedPassword(String password, byte [] salt) {
        String hashed = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt);
            byte [] bytes = messageDigest.digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte singleByte: bytes) {
                builder.append(Integer.toString((singleByte & 0xff) + 0x100, 16).substring(1));
            }
            hashed = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed;
    }

    public static byte [] getSalt() {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte [] salt = new byte[16];
            random.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte [16];
        }
    }
}
