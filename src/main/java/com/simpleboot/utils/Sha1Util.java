package com.simpleboot.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1Util {


    public static String inputPassFormPass(String inputPass){
        MessageDigest sha1 = null;
        byte[] bytes = inputPass.getBytes(StandardCharsets.UTF_8);
        try {
            sha1 = MessageDigest.getInstance("SHA1");
            sha1.update(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] digest = sha1.digest();
        String result = byteArrayToHexString(digest);
        return result.toUpperCase();
    }

    private static String byteArrayToHexString(byte[] bytes){

        StringBuilder string = new StringBuilder();
        for (byte aByte : bytes) {
            String temp = Integer.toHexString(aByte&0xff);
            if (temp.length() == 1){
                string.append(0);
            }
            string.append(temp);
        }
        return String.valueOf(string);
    }
}
