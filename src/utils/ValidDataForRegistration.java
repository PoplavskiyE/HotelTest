/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Женя
 */
public class ValidDataForRegistration {
//стоит ли делать методы static ????????????????

    public static final String regexPhone = "^((29|33|44|25)[1-9]\\d{6})$";//"^(29[1-9]\\d{6}|33[1-9]\\d{6}|44[1-9]\\d{6}|25[1-9]\\d{6})$";
    public static final String regexEmail = "^(\\w{4,})@(\\w+\\.)([a-z]{2,4})$";

    public static Boolean ValidEmail(String email) {
        Pattern p = Pattern.compile(regexEmail);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static Boolean ValidPhone(String testPhone) {
        Pattern p = Pattern.compile(regexPhone);
        String temp = testPhone.replaceAll("\\s", "");
        Matcher m = p.matcher(temp);
        return m.matches();
    }
}
