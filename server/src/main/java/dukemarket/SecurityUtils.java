package dukemarket;

import dukemarket.auth.CustomersDetails;
import org.apache.commons.codec.binary.Hex;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * This file created by Maxim S. Ivanov
 */
public class SecurityUtils {
    public static String currentUser(){
        CustomersDetails customersDetails = (CustomersDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customersDetails.getKey();
    }

    public static String hash(String password){
        if (!StringUtils.isEmpty(password)) {
            try {
                final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(password.getBytes(Charset.forName("UTF8")));
                final byte[] resultByte = messageDigest.digest();
                return new String(Hex.encodeHex(resultByte));

//                byte[] passwordBytes = password.getBytes("UTF-8");
//                byte[] bytes = MessageDigest.getInstance("MD5").digest(passwordBytes);
//                return new String(bytes, "UTF-8");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Unexpected password");
        }
    }
}
