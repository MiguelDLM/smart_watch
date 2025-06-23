package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.b;

/* loaded from: classes8.dex */
public class RGScreenStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9312a = "RGScreenStatusReceiver";
    private static Context c;
    private static RGScreenStatusReceiver b = new RGScreenStatusReceiver();
    private static boolean d = false;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        c = context;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.setPriority(Integer.MAX_VALUE);
        try {
            c.registerReceiver(b, intentFilter);
            d = true;
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            LogUtil.e(f9312a, "onReceive ACTION_SCREEN_ON");
            b.r().a("3.w.2", "1", null, null);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            LogUtil.e(f9312a, "onReceive ACTION_SCREEN_OFF");
            b.r().a("3.w.2", "2", null, null);
        } else if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            LogUtil.e(f9312a, "onReceive ACTION_USER_PRESENT");
            b.r().a("3.w.2", "3", null, null);
        }
    }

    public static void a() {
        try {
            Context context = c;
            if (context != null && d) {
                d = false;
                context.unregisterReceiver(b);
            }
            c = null;
        } catch (Exception unused) {
        }
    }
}
