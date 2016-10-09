package com.intelife.videomis.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public enum Format {
        DEFAULT_YMDHMS("yyyy-MM-dd HH:mm:ss"),
        DEFAULT_YMDHM("yyyy-MM-dd HH:mm"),
        DEFAULT_YMD("yyyy-MM-dd"),
        DEFAULT_YM("yyyy-MM"),
        YMDHMS("yyyyMMdd HHmmss"),
        YMD("yyyyMMdd"),
        YM("yyyyMM"),
        YMDHMS_1("yyyy/MM/dd HH:mm:ss"),
        YMD_1("yyyy/MM/dd"),
        YM_1("yyyy/MM");
        private String pattern;

        private String getPattern() {
            return this.pattern;
        }

        private Format(String pattern) {
            this.pattern = pattern;
        }
    }

    public static boolean isNull(Date date) {
        return date == null;
    }

    public static String toString(Date date) {
        return toString(date, Format.DEFAULT_YMDHMS);
    }

    public static String toString(Date date, Format format) {
        if (isNull(date)) {
            return null;
        }

        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(format.getPattern()));
    }

    public static Date getNow() {
        return new Date();
    }

    public static String getNowString() {
        return getNowString(Format.DEFAULT_YMDHMS);
    }

    public static String getNowString(Format format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format.getPattern()));
    }

    public static Date getDate(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return null;
        }

        Date date = null;
        for (Format format : Format.values()) {
            date = getDate(str, format);
            if (date != null) {
                break;
            }
        }

        return date;
    }

    public static Date getDate(String str, Format format) {
        if (StringUtil.isNullOrEmpty(str) || StringUtil.isNullOrEmpty(format.getPattern())) {
            return null;
        }

        try {
            SimpleDateFormat df = new SimpleDateFormat(format.getPattern());
            return df.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getDate(long date) {
        return Date.from(Instant.ofEpochMilli(date));
    }

    public static Date minusYear(int years) {
        return Date.from(LocalDateTime.now().minusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date minusYear(Date date, int years) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).minusYears(years)
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date plusYear(int years) {
        return Date.from(LocalDateTime.now().plusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date plusYear(Date date, int years) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusYears(years)
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date minusMonths(int months) {
        return Date.from(LocalDateTime.now().minusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date minusMonths(Date date, int months) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).minusMonths(months)
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date plusMonths(int months) {
        return Date.from(LocalDateTime.now().plusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date plusMonths(Date date, int months) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusMonths(months)
                .atZone(ZoneId.systemDefault()).toInstant());
    }
}
