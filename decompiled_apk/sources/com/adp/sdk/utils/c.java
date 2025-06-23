package com.adp.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public class c {
    public static String a() {
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }
}
