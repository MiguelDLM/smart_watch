package com.adp.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class c {
    public static String a() {
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }
}
