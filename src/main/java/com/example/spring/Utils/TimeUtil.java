package com.example.spring.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getNowTime()//给予当前时间的字符串形式
    {
        Date d=new Date();//当前时间
        SimpleDateFormat sbf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//转化成年月日 时分秒
        return sbf.format(d);
    }
}
