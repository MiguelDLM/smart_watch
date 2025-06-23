package com.jd.ad.sdk.jad_an;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes10.dex */
public final class jad_bo {
    public static String jad_an = "";
    public static String jad_bo = "";

    public static String jad_an(Context context) {
        if (TextUtils.isEmpty(jad_bo)) {
            if (context == null) {
                com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "context is null");
                return "";
            }
            jad_bo = context.getPackageName();
        }
        return jad_bo;
    }
}
