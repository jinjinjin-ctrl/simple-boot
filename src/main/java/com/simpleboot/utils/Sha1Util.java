package com.simpleboot.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha1Util {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String inputPassFormPass(String inputPass){
        return passwordEncoder.encode(inputPass);
    }

    public static boolean matchesPassword(String rowPassword, String inputPass){
        return passwordEncoder.matches(rowPassword,inputPass);
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
