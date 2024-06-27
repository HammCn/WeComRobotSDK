package cn.hamm.wecom.robot.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <h1>图片工具</h1>
 *
 * @author Hamm.cn
 */
public class ImageUtil {
    /**
     * <h2>获取图片MD5</h2>
     *
     * @param input 输入流
     * @return MD5
     */
    public static String getImageMd5(InputStream input) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[8192];
        int read;
        while ((read = input.read(buffer)) != -1) {
            md.update(buffer, 0, read);
        }
        byte[] digest = md.digest();
        return bytesToHex(digest);
    }

    /**
     * <h2>字节数组转十六进制</h2>
     *
     * @param bytes 字节数组
     * @return 十六进制
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
