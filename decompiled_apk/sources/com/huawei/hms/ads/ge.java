package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public class ge {
    private static final String B = "NotificationActionManager";
    public static final String Code = "com.huawei.ads.notification.action.CLICK";
    public static final int I = 1;
    private static ge S = null;
    public static final String V = "com.huawei.ads.notification.action.DELETE";
    public static final String Z = "type";
    private Context D;
    private ed L;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends gd>> f17290a = new HashMap();
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.huawei.hms.ads.ge.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                fb.Code(ge.B, "intent or action maybe empty.");
            } else {
                fb.Code(ge.B, " action name:%s", intent.getAction());
                ge.this.Code(context, intent);
            }
        }
    };
    private static final byte[] C = new byte[0];
    private static final byte[] F = new byte[0];

    private ge(Context context) {
        this.D = context.getApplicationContext();
        this.L = ed.Code(context);
    }

    public static ge Code(Context context) {
        synchronized (C) {
            try {
                if (S == null) {
                    S = new ge(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return S;
    }

    private void V() {
        this.f17290a.put("com.huawei.ads.notification.action.CLICK1", fy.class);
        this.f17290a.put("com.huawei.ads.notification.action.DELETE1", ga.class);
    }

    public boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(B, "isPackageExist packageName is Empty.");
            return false;
        }
        synchronized (F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai == null) {
                    return false;
                }
                return ai.contains(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code() {
        String str;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(V);
            this.D.registerReceiver(this.b, intentFilter);
        } catch (IllegalStateException unused) {
            str = "init IllegalStateException";
            fb.I(B, str);
            V();
        } catch (Exception unused2) {
            str = "init Exception";
            fb.I(B, str);
            V();
        }
        V();
    }

    public void V(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(B, "remove packageName is Empty.");
            return;
        }
        synchronized (F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.remove(str);
                    ed.Code(this.D).Code(ai);
                }
            } finally {
            }
        }
    }

    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        String str2;
        try {
            int intExtra = intent.getIntExtra("type", 1);
            String str3 = intent.getAction() + intExtra;
            Class<? extends gd> cls = this.f17290a.get(str3);
            if (cls != null) {
                try {
                    cls.newInstance().Code(this.D, intent);
                } catch (InstantiationException unused) {
                    str2 = "InstantiationException can not instantiation notification Action";
                    fb.I(B, str2);
                } catch (Throwable unused2) {
                    str2 = "Throwable can not instantiation notification Action";
                    fb.I(B, str2);
                }
            } else {
                fb.V(B, "can not find action key:" + str3);
            }
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder();
            str = "actionReceiver.onReceive IllegalStateException:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fb.I(B, sb.toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "actionReceiver.onReceive Exception:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fb.I(B, sb.toString());
        }
    }

    public void Code(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(B, "add packageName is Empty.");
            return;
        }
        synchronized (F) {
            try {
                Set<String> ai = this.L.ai();
                if (ai != null) {
                    ai.add(str);
                    ed.Code(this.D).Code(ai);
                }
            } finally {
            }
        }
    }
}
