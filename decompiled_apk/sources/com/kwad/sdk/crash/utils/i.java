package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes11.dex */
public final class i {
    private static SimpleDateFormat aJh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aE(long j) {
        if (j <= 0) {
            return "unknown";
        }
        return aJh.format(new Date(j));
    }
}
