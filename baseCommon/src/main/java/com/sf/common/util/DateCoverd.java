/**
 * @Title: DateCoverd.java
 * @Package com.pb.common.util
 * @Des: 日期常用类
 * @author maohaitao
 * @date 2015年4月14日 下午12:16:06
 * @version V1.0
 */
package com.sf.common.util;

import com.sf.common.log.LogService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author maohaitao
 * @ClassName: DateCoverd
 * @Des: 日期常用类
 * @date 2015年4月14日 下午12:16:06
 */
public class DateCoverd {
    public static final String FORMART_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMART_DDMMYYYY = "dd/MM/yyyy";
    public static final String FORMART_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String SQL_FORMART_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh24:mi:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMART_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public DateCoverd() {
    }

    public static DateFormat getDateFormart() {
        return getDateFormart("yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(String date) {
        DateFormat df = getDateFormart();
        Date da = null;
        try {
            da = df.parse(date);
        } catch (ParseException var4) {
            LogService.error("日期转换错误", var4);
        }

        return da;
    }

    public static Date toDate(String date, String format) {
        DateFormat df = getDateFormart(format);
        Date da = null;

        try {
            da = df.parse(date);
        } catch (ParseException var5) {
            LogService.error("日期转换错误", var5);
        }

        return da;
    }

    public static DateFormat getDateFormart(String format) {
        SimpleDateFormat df = null;
        if (format != null && !format.trim().equals("")) {
            df = new SimpleDateFormat(format);
        } else {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        return df;
    }

    public static String toString(Date dt, String sFmt) {
        if (dt == null) {
            return "";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(sFmt);
            String sRet = formatter.format(dt).toString();
            return sRet;
        }
    }

    public static Date addYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(1, calendar.get(1) + years);
        date = calendar.getTime();
        return date;
    }

    public static Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, calendar.get(2) + months);
        date = calendar.getTime();
        return date;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) + days);
        date = calendar.getTime();
        return date;
    }

    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, calendar.get(11) + hours);
        date = calendar.getTime();
        return date;
    }

    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, calendar.get(12) + minute);
        date = calendar.getTime();
        return date;
    }

    public static String toString(Date dt) {
        return toString(dt, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDayWithFormat(Date date, String format) {
        Date today = toDate(toString(date, format), format);
        return today;
    }

    public static void main(String[] args) {
        Date date = new Date();
        Date today = toDate(toString(date, "yyyy-MM-dd"), "yyyy-MM-dd");
        System.out.println(date.getTime());
        System.out.println(today.getTime());
    }
}
