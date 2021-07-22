package com.example.demo.common;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-06-24 17:51
 */
public class DateTimeUtil {

    private static final String NORMAL_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    private static final String SLASH_TIME_FORMAT_STR = "yyyy/MM/dd HH:mm:ss";

    private static final String NORMAL_DATE_FORMAT_STR = "yyyy-MM-dd";

    public static String secondToTime(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds - hour * 3600) / 60;
        int second = seconds - hour * 3600 - minute * 60;
        String hourStr;
        String minuteStr;
        String  secondStr;
        if (hour < 10) {
            hourStr = "0" + hour;
        } else {
            hourStr = "" + hour;
        }
        if (minute < 10) {
            minuteStr = "0" + minute;
        } else {
            minuteStr = "" + minute;
        }
        if (second < 10) {
            secondStr = "0" + second;
        } else {
            secondStr = "" + second;
        }
        return hourStr + ":" + minuteStr + ":" + secondStr;
    }

    /**
     * 将时间按照传入的formatter转换成字符串
     * @param dateTime 时间
     * @param formatter 格式化字符串
     * @return 时间字符串
     */
    private static String dateTime2Str(DateTime dateTime, DateTimeFormatter formatter) {
        return dateTime.toString(formatter);
    }

    /**
     * 将时间转换成标准时间字符串
     * @param dateTime 时间
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String normalDateTime2Str(DateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(NORMAL_TIME_FORMAT_STR);
        return dateTime2Str(dateTime, formatter);
    }

    /**
     * 将字符串按照formatter格式转换成DateTime
     * @param dateTimeStr 时间字符串
     * @param formatter 时间格式
     * @return DateTime
     */
    private static DateTime str2DateTime(String dateTimeStr, DateTimeFormatter formatter) {
        return formatter.parseDateTime(dateTimeStr);
    }

    /**
     * 标准字符串转换成DateTime
     *      yyyy-MM-dd HH:mm:ss
     * @param dateTimeStr 时间字符串
     * @return DateTime
     */
    public static DateTime normalStr2DateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(NORMAL_TIME_FORMAT_STR);
        return str2DateTime(dateTimeStr, formatter);
    }

    public static DateTime dateTime2DateFormat(DateTime dateTime) {
        String nowDate = dateTime.toString(NORMAL_DATE_FORMAT_STR);
        return normalStr2DateTime(nowDate + " 00:00:00");
    }

    public static DateTime slashStr2DateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(SLASH_TIME_FORMAT_STR);
        return str2DateTime(dateTimeStr, formatter);
    }

}
