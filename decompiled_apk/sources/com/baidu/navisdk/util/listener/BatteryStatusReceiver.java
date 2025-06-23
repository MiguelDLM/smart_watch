package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class BatteryStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9306a = false;
    private static BatteryStatusReceiver b = new BatteryStatusReceiver();

    private BatteryStatusReceiver() {
    }

    public static void a(Context context) {
        if (context != null && !f9306a) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            try {
                context.registerReceiver(b, intentFilter);
                f9306a = true;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context) {
        if (context != null && f9306a) {
            f9306a = false;
            try {
                context.unregisterReceiver(b);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
            int i = intent.getExtras().getInt("level");
            int i2 = intent.getExtras().getInt("scale", 100);
            if (100 != i2 && i2 != 0) {
                int i3 = (i * 100) / i2;
            }
            LogUtil.e("BatteryStatusReceiver", "battery action:" + action + "status = " + intent.getIntExtra("status", 1));
        }
    }
}
