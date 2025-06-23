package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public abstract class ag {
    private static final String Code = "LogTool";

    public static void Code(Context context, int i, String str) {
        if (i < 4) {
            i = 4;
        }
        if (TextUtils.isEmpty(str)) {
            str = av.Code(context);
            if (TextUtils.isEmpty(str)) {
                fb.I(Code, "enable log failed, due to root path is null");
                return;
            }
        }
        fb.Code(i, str, "HiAd");
    }
}
