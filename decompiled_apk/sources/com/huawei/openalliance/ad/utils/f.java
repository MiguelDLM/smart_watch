package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class f {
    private static final String Code = "AgdsUtil";

    public static boolean Code(Context context) {
        if (context == null) {
            fb.I(Code, "context is null");
            return false;
        }
        if (!w.B(context) || w.F(context)) {
            return V(context);
        }
        fb.V(Code, "isUsingHmsAdsService and kitVersion unsupport AGDSService");
        return false;
    }

    public static boolean V(Context context) {
        return g.I(context, com.huawei.openalliance.ad.constant.x.Y) >= 140101105;
    }
}
