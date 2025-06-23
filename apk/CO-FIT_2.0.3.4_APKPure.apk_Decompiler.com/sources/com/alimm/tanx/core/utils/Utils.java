package com.alimm.tanx.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils implements NotConfused {
    public static String formatTimeInMillis(long j, String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return new SimpleDateFormat(str).format(instance.getTime());
    }
}
