package com.utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DataUtils {
    //日期转字符串
    public static String Date2String(Date date, String pattern){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        String format=simpleDateFormat.format(date);
        return format;
    }
    //字符串转日期
    public static Date String2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }
}
