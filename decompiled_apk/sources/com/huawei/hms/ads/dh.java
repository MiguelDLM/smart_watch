package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;

/* loaded from: classes10.dex */
public class dh {
    private static dh V;
    private static final byte[] Z = new byte[0];
    private BroadcastReceiver B;
    private Context I;

    /* renamed from: com.huawei.hms.ads.dh$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED");
            dh.this.B = new a(null);
            if (com.huawei.openalliance.ad.utils.w.B(dh.this.I)) {
                dh.this.I.registerReceiver(dh.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.Code(dh.this.I, com.huawei.openalliance.ad.constant.bm.Code, new NotifyCallback() { // from class: com.huawei.hms.ads.dh.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.dh.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (dh.this.B != null) {
                                    dh.this.B.onReceive(dh.this.I, intent);
                                }
                            }
                        });
                    }
                });
            }
            fb.V("RewardAdStatusHandler", "registerPPSReceiver");
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        private boolean Code(int i, com.huawei.openalliance.ad.inter.listeners.h hVar) {
            if (hVar == null) {
                return false;
            }
            if (8 == i) {
                hVar.S();
                return true;
            }
            if (9 != i) {
                return false;
            }
            hVar.C();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            fb.V("RewardAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    com.huawei.openalliance.ad.inter.data.i Code = df.Code();
                    if (Code != null && (Code instanceof com.huawei.openalliance.ad.inter.data.q)) {
                        com.huawei.openalliance.ad.inter.data.q qVar = (com.huawei.openalliance.ad.inter.data.q) Code;
                        com.huawei.openalliance.ad.inter.listeners.g Z = qVar.Z();
                        com.huawei.openalliance.ad.inter.listeners.h I = qVar.I();
                        int intExtra = intent.getIntExtra("reward_ad_status", -1);
                        String stringExtra = intent.getStringExtra(com.huawei.openalliance.ad.constant.bb.e);
                        fb.V("RewardAdStatusHandler", "status:" + intExtra);
                        if (Code(intExtra, I)) {
                            return;
                        }
                        if (Z == null) {
                            fb.I("RewardAdStatusHandler", "there is no status listener");
                            return;
                        }
                        switch (intExtra) {
                            case 1:
                                Z.Code();
                                qVar.I(true);
                                return;
                            case 2:
                                Z.V();
                                return;
                            case 3:
                                Z.I();
                                return;
                            case 4:
                                Z.Z();
                                return;
                            case 5:
                                if (qVar.S()) {
                                    return;
                                }
                                Z.B();
                                qVar.V(true);
                                AdContentData n = qVar.n();
                                n.I(stringExtra);
                                jc.Code(context, n, qVar.J(), qVar.n_(), "");
                                return;
                            case 6:
                                Z.Code(intent.getIntExtra("reward_ad_error", -1), intent.getIntExtra("reward_ad_extra", -1));
                                return;
                            case 7:
                                if (dh.V != null) {
                                    dh.V.V();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    fb.I("RewardAdStatusHandler", "can not get reward");
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fb.Z("RewardAdStatusHandler", sb.toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    fb.Z("RewardAdStatusHandler", sb.toString());
                }
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private dh(Context context) {
        this.I = context.getApplicationContext();
    }

    private static dh V(Context context) {
        dh dhVar;
        synchronized (Z) {
            try {
                if (V == null) {
                    V = new dh(context);
                }
                dhVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dhVar;
    }

    public static dh Code(Context context) {
        return V(context);
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.dh.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fb.V("RewardAdStatusHandler", "unregisterPPSReceiver");
                        dh.this.I.unregisterReceiver(dh.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.I, com.huawei.openalliance.ad.constant.bm.Code);
    }

    public void Code() {
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bf.Code(new AnonymousClass1());
    }
}
