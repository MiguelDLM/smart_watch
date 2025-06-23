package com.huawei.openalliance.ad.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class ac extends BroadcastReceiver {
    private static final String Code = "KitPreloadReceiver";
    private static volatile ac V;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (com.huawei.openalliance.ad.constant.x.dh.equalsIgnoreCase(new SafeIntent(intent).getAction())) {
                fb.Code(Code, "onReceive kit preload");
                ab.Code(context.getApplicationContext());
            }
        } catch (Throwable th) {
            fb.I(Code, "onReceive Exception: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(final Context context) {
        h.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.1
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(com.huawei.openalliance.ad.constant.x.dh);
                    if (ac.V == null) {
                        ac unused = ac.V = new ac();
                    }
                    context.registerReceiver(ac.V, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                }
            }
        });
    }
}
