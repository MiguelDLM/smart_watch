package com.kwad.sdk.utils;

import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class bm {
    public static String ai(long j) {
        if (j > 0 && j < 86400000) {
            try {
                long j2 = j / 1000;
                long j3 = j2 % 60;
                long j4 = (j2 / 60) % 60;
                long j5 = j2 / 3600;
                Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
                if (j5 > 0) {
                    return formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString();
                }
                return formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                return "";
            }
        }
        return "00:00";
    }
}
