package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class BatteryChargeReceiver extends BroadcastReceiver {
    static {
        new BatteryChargeReceiver();
    }

    private BatteryChargeReceiver() {
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
