package util;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/7/20.
 */
public class EncryptDecrypt {
    public static String doMD5Format(String str) {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        byte[] mds = digest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : mds) {
            sb.append(String.format("%02x",b));
        }
        return  sb.toString();
    }
    public static String doMD5Array(String str) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        byte[] mds = digest.digest();
        char[] strs = new char[32];
        int i = 0;
        for (byte b : mds) {
            strs[i++] = hexDigits[b >>> 4 & 0xf];
            strs[i++] = hexDigits[b & 0xf];
        }
        return new String(strs);
    }
}
