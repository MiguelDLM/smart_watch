package com.huawei.openalliance.ad.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes10.dex */
public class ah {
    public static final int Code = 1024;
    public static final String I = "******";
    public static final String V = "UTF-8";

    public static SimpleDateFormat Code(String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH);
        } catch (Throwable unused) {
            return new SimpleDateFormat(str);
        }
    }
}
