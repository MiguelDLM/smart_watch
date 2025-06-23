package com.baidu.mshield.x6.recv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mshield.b.a.d;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.a.b;
import com.baidu.mshield.x6.d.i;
import com.baidu.mshield.x6.e.a.c;
import com.baidu.mshield.x6.e.f;

/* loaded from: classes7.dex */
public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6450a = true;

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (EngineImpl.isUnload || !intent.getPackage().equals(context.getPackageName())) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("com.baidu.mshield.x6.alarm.work.finger")) {
                try {
                    i.a(context).a(1, false);
                    com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_FINGER");
                    com.baidu.mshield.x6.e.a.a(context);
                } catch (Throwable th) {
                    f.a(th);
                }
            } else if (action.equals("com.baidu.mshield.x6.alarm.work.zid")) {
                new b(context).d(false);
                i.a(context).a(1);
                com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_ZID");
                com.baidu.mshield.x6.e.a.b(context);
            }
        } catch (Throwable th2) {
            f.a(th2);
        }
    }

    public static synchronized void b(Context context, Intent intent) {
        synchronized (MyReceiver.class) {
            if (EngineImpl.isUnload) {
                return;
            }
            try {
                if (d.b(context)) {
                    if (!new b(context).h() && !i.b) {
                        i.a(context).a(5);
                    }
                    i.a(context).a(1, false);
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
    }

    public static void c(Context context, Intent intent) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            i.a(context).a();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void d(Context context, Intent intent) {
        if (!EngineImpl.isUnload && intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                action.hashCode();
                if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (!action.equals("android.intent.action.SIM_STATE_CHANGED")) {
                        a(context, intent);
                        return;
                    } else {
                        c(context, intent);
                        return;
                    }
                }
                if (!f6450a) {
                    b(context, intent);
                } else {
                    f6450a = false;
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.a().a(new a(this, context, intent));
    }
}
