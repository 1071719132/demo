package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
        return format.format(now);
    }

    public static List<String> getMonthDay(String date) {
        List<String> list = getMonthFullDay(date);
        List<String> listDay = new ArrayList<>();
        for (String date1 : list) {
            listDay.add(date1.substring(0, 8) + date1.substring(8, 10));
        }
        return listDay;
    }
    private static List<String> getMonthFullDay(String date) {
        List<String> fullDayList = new ArrayList<String>();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = 1;
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count - 1); ) {
            if (sdf.format(cal.getTime()).equals(getLastDay(year, month))) {
                break;
            }
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(sdf.format(cal.getTime()));
        }
        return fullDayList;
    }

    private static String getLastDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(cal.getTime());
    }
}
