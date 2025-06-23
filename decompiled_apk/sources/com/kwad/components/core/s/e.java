package com.kwad.components.core.s;

import java.util.Locale;

/* loaded from: classes11.dex */
public final class e {
    public static String a(long j, boolean z) {
        double d;
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j <= 1) {
            return j + "B";
        }
        double d2 = j;
        int log = (int) (Math.log(d2) / Math.log(1024.0d));
        if (j > 1024) {
            d = d2 / Math.pow(1024.0d, log);
        } else {
            d = d2 / 1024.0d;
        }
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(d), strArr[log]);
    }
}
