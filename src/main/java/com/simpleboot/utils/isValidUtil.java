package com.simpleboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isValidUtil {


    public static boolean checkEmail(String email){

        String s = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(s);
        Matcher matcher = p.matcher(email);
        return !matcher.matches();
    }

}
