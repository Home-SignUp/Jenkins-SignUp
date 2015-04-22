//package com.addrbook.backend.domain;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.TimeZone;
//
///**
//* Created by alexandr on 21.04.15.
//*/
//public class Tmp {
//
//    private static final String     sdftPattern = "HH:mm:ss";
//    private static final String     sdfdPattern = "yyyy-MM-dd";
//    private static final String    sdftsPattern = "yyyy-MM-dd HH:mm:ss.";
//    private static final String sdftsSysPattern = "yyyy-MM-dd HH:mm:ss.SSS";
//    static SimpleDateFormat                sdfd = new SimpleDateFormat(sdfdPattern);
//    static SimpleDateFormat                sdft = new SimpleDateFormat(sdftPattern);
//    static SimpleDateFormat               sdfts = new SimpleDateFormat(sdftsPattern);
//    static SimpleDateFormat            sdftsSys = new SimpleDateFormat(sdftsSysPattern);
//
//    private static Calendar          today = new GregorianCalendar();
//    private static Calendar        tempCal = new GregorianCalendar();
//    private static Calendar tempCalDefault = new GregorianCalendar();
//    private static Calendar     tempCalGMT = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
//    private static Date           tempDate = new Date();
//    private static Date        currentDate;
//
//    private static DateFormat    temp2Date = new SimpleDateFormat(sdfdPattern);
//
//
//    public static void main(String[] args) {
//
////        System.out.println("Calendar = '" + today + "'");
////        System.out.println("Date = '" + tempDate + "'");
////        System.out.println("getDateString = '" + getDateString(tempDate, today) + "'");
//        System.out.println("temp2Date = '" + temp2Date.format(tempDate) + "'");
//    }
//
////    public static String getDateString(Date date, Calendar calendar) {
////        synchronized (sdfd) {
////            sdfd.setCalendar(calendar == null ? tempCalDefault : calendar);
////            return sdfd.format(date);
////        }
////    }
//
//}
