package util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liuziyang on 2017/7/20.
 */
public class EncryptDecrypt {
    public static String doMD5Format(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        byte[] mds = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : mds) {
            sb.append(String.format("%02x",b));
        }
        return  sb.toString();
    }
    public static String doMD5Array(String str) throws NoSuchAlgorithmException {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        byte[] mds = digest.digest();
        char[] mdstr = new char[32];
        int i = 0;
        for (byte b : mds) {
            mdstr[i++] = hexDigits[b >>> 4 & 0xf];
            mdstr[i++] = hexDigits[b & 0xf];
        }
        return new String(mdstr);
    }

    public static void main(String[] args) throws Exception{
        String salt = "{PONY}";
        System.out.println(doMD5Format("000000"+ salt));
        System.out.println(doMD5Array("000000"+ salt));
        System.out.println(URLEncoder.encode("jf2fkEAW5mYfbBQ6AHO+Bg==","UTF-8"));
        System.out.println(URLEncoder.encode("00000000000197","UTF-8"));
    }
}
