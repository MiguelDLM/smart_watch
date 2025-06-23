package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.sma.smartv3.util.xoIox;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class bh {
    private static final SimpleDateFormat aRi;
    private static final SimpleDateFormat aRj;
    private static final SimpleDateFormat aRk;
    private static final SimpleDateFormat aRl;
    private static final SimpleDateFormat aRm;
    private static final SimpleDateFormat aRn;
    private static final SimpleDateFormat aRo;

    static {
        Locale locale = Locale.US;
        aRi = new SimpleDateFormat(xoIox.f24719xoXoI, locale);
        aRj = new SimpleDateFormat("yyyy/MM/dd", locale);
        aRk = new SimpleDateFormat(DateFormatUtils.MM_DD2, locale);
        aRl = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD5, locale);
        aRm = new SimpleDateFormat("HH:mm", locale);
        aRn = new SimpleDateFormat(DateFormatUtils.MM_DD, locale);
        aRo = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean gZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches(".*\\.kpg.*");
        }
        return false;
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
