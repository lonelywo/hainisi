package com.renma.hainisi.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
    /**
     * 32位MD5加密方法
     * 16位小写加密只需getMd5Value("xxx").substring(8, 24);即可
     *
     * @param
     * @return
     */
    public static String getMd5Value(String tempString) {
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(tempString.toString().getBytes("UTF-8"));
            StringBuilder hex = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) {
                if ((b & 0xFF) < 0x10) hex.append("0");
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
