package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.framework.message.bean.h;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class ChargeStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9307a = false;
    public static boolean b = false;
    private static ChargeStatusReceiver c = new ChargeStatusReceiver();

    private ChargeStatusReceiver() {
    }

    public static void a(Context context) {
        if (context != null && !f9307a) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            try {
                context.registerReceiver(c, intentFilter);
                f9307a = true;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context) {
        if (context != null && f9307a) {
            f9307a = false;
            try {
                context.unregisterReceiver(c);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BatteryStatusReceiver", "battery action:" + action);
        }
        if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
            b = true;
        } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            b = false;
        }
        com.baidu.navisdk.framework.message.a.a().a(new h(b, -1));
    }
}
