package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class ab {
    private static final String Code = "KitDataUtil";

    public static void Code(final Context context) {
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ab.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.S(context, 1)) {
                    fb.Code(ab.Code, "prepare cached contentId");
                    com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.A, null, null, null);
                    ac.Code(context);
                }
            }
        });
    }
}
