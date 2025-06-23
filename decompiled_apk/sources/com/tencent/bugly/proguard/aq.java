package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes13.dex */
public final class aq extends BroadcastReceiver {
    private static aq d;
    private Context b;
    private String c;
    private boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f26557a = new IntentFilter();

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ aq f26559XO;

        public oIX0oI(aq aqVar) {
            this.f26559XO = aqVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                al.a(aq.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                synchronized (this.f26559XO) {
                    aq.this.b.registerReceiver(aq.d, aq.this.f26557a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            try {
                if (d == null) {
                    d = new aq();
                }
                aqVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aqVar;
    }

    public final synchronized void b(Context context) {
        try {
            al.a(aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void a(String str) {
        try {
            if (!this.f26557a.hasAction(str)) {
                this.f26557a.addAction(str);
            }
            al.c("add action %s", str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(Context context) {
        this.b = context;
        ap.a(new oIX0oI(this));
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                String c = ab.c(this.b);
                al.c("is Connect BC ".concat(String.valueOf(c)), new Object[0]);
                al.a("network %s changed to %s", this.c, String.valueOf(c));
                if (c == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = c;
                long currentTimeMillis = System.currentTimeMillis();
                ac a2 = ac.a();
                ai a3 = ai.a();
                aa a4 = aa.a(context);
                if (a2 != null && a3 != null && a4 != null) {
                    if (!c.equals(str) && currentTimeMillis - a3.a(at.f26567a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at a5 = at.a();
                        if (a5 != null) {
                            a5.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
