package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.fb;
import com.huawei.hms.analytics.HiAnalytics;

/* loaded from: classes10.dex */
public class a {
    private static final String Code = "AaidUtil";

    public static String Code(final Context context) {
        if (!Code()) {
            return "";
        }
        final aq Code2 = aq.Code(context);
        String D = Code2.D();
        if (TextUtils.isEmpty(D)) {
            h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Task aaid = HiAnalytics.getInstance(context).getAAID();
                        if (aaid != null) {
                            Code2.I((String) aaid.getResult());
                        }
                    } catch (Throwable th) {
                        fb.I(a.Code, "error getAgcAaid: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
        return D;
    }

    public static boolean Code() {
        return ar.B(com.huawei.openalliance.ad.constant.x.bT);
    }
}
