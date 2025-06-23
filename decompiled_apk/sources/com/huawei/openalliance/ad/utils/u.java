package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class u {
    private static final String Code = "HarmonyUtils";
    private static final int V = 1048576;

    private static boolean Code(int i) {
        return (i & 1048576) != 0;
    }

    public static boolean Code(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean Code2 = Code(new p().Code(g.C(context.getApplicationContext(), str), context));
            fb.V(Code, "isHarmonyApp: %s", Boolean.valueOf(Code2));
            return Code2;
        } catch (Throwable unused) {
            fb.I(Code, "isHarmonyApp exception");
            return false;
        }
    }
}
