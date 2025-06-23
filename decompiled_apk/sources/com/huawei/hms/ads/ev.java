package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* loaded from: classes10.dex */
public class ev {
    private static final String Code = "LinkedAdStatusHandler";
    private static final int I = 0;
    private static final byte[] V = new byte[0];
    private static ev Z;
    private Context B;
    private BroadcastReceiver C;

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (ew.Code.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra(ew.I, false);
                    int intExtra = intent.getIntExtra(ew.Z, 0);
                    fb.V(ev.Code, "LinkedAdBroadcastReceiver playProgress " + intExtra);
                    et etVar = new et();
                    etVar.V(booleanExtra);
                    etVar.Code(intExtra);
                    eu.Code(etVar);
                }
            } catch (Throwable th) {
                fb.I(ev.Code, "LinkedAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    private ev(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    private static synchronized ev V(Context context) {
        ev evVar;
        synchronized (ev.class) {
            synchronized (V) {
                try {
                    if (Z == null) {
                        Z = new ev(context);
                    }
                    evVar = Z;
                } finally {
                }
            }
        }
        return evVar;
    }

    public static ev Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ev.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fb.V(ev.Code, "unregisterPpsReceiver");
                        ev.this.B.unregisterReceiver(ev.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.B, com.huawei.openalliance.ad.constant.bm.I);
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        fb.Code(Code, "registerPpsReceiver ");
        if (this.C != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ev.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter(ew.Code);
                intentFilter.addAction(ew.V);
                ev.this.C = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.w.B(ev.this.B)) {
                    ev.this.B.registerReceiver(ev.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    com.huawei.openalliance.ad.msgnotify.b.Code(ev.this.B, com.huawei.openalliance.ad.constant.bm.I, new NotifyCallback() { // from class: com.huawei.hms.ads.ev.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (ev.this.C != null) {
                                ev.this.C.onReceive(ev.this.B, intent);
                            }
                        }
                    });
                }
                fb.V(ev.Code, "registerPpsReceiver");
            }
        });
    }
}
