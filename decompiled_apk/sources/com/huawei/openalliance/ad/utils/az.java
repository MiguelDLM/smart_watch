package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public abstract class az {
    private static final String Code = "SwUt";

    public static Integer Code(String str, int i) {
        return Code(str, i, 0);
    }

    private static Integer V(String str, int i) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(i, i + 1)));
            } catch (RuntimeException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("getSwh ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("getSwh ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static Integer Code(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || i2 < 0) {
            return null;
        }
        String[] split = str.split(HelpFormatter.DEFAULT_OPT_PREFIX);
        if (split.length < i2 + 1) {
            return null;
        }
        return V(split[i2], i);
    }
}
