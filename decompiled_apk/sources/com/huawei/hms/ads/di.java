package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* loaded from: classes10.dex */
public class di {
    private static di I;
    private static final byte[] V = new byte[0];
    private BroadcastReceiver B;
    private Context Z;

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED".equals(intent.getAction())) {
                    ed.Code(context).B(intent.getStringExtra("splash_interact_close_expiretime"));
                }
            } catch (Throwable th) {
                fb.I("SplashAdInteractConfigHandler", "SplashAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
            di.I.V();
        }
    }

    private di(Context context) {
        if (context != null) {
            this.Z = context.getApplicationContext();
        }
    }

    private static synchronized di V(Context context) {
        di diVar;
        synchronized (di.class) {
            synchronized (V) {
                try {
                    if (I == null) {
                        I = new di(context);
                    }
                    diVar = I;
                } finally {
                }
            }
        }
        return diVar;
    }

    public static di Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.di.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fb.V("SplashAdInteractConfigHandler", "unregisterPpsReceiver");
                        di.this.Z.unregisterReceiver(di.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        fb.Code("SplashAdInteractConfigHandler", "registerPpsReceiver ");
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.di.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED");
                di.this.B = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.w.B(di.this.Z)) {
                    di.this.Z.registerReceiver(di.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    com.huawei.openalliance.ad.msgnotify.b.Code(di.this.Z, com.huawei.openalliance.ad.constant.bm.Z, new NotifyCallback() { // from class: com.huawei.hms.ads.di.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (di.this.B != null) {
                                di.this.B.onReceive(di.this.Z, intent);
                            }
                        }
                    });
                }
                fb.V("SplashAdInteractConfigHandler", "registerPpsReceiver");
            }
        });
    }
}
