package com.example.spring.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {
    // 使用正则表达式验证邮箱格式
    public static boolean isValidEmail(String email) {
        // 正则表达式用于匹配有效的邮箱格式
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
