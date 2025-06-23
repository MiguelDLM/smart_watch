package com.baidu.navisdk.ui.routeguide.heatmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.ui.routeguide.heatmonitor.e;
import com.facebook.appevents.integrity.IntegrityManager;

/* loaded from: classes8.dex */
public class RGHMHeatStrategy {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.heatmonitor.i.a f8609a;
    private final e b;
    private final BatteryReceiver c = new BatteryReceiver();

    /* loaded from: classes8.dex */
    public class BatteryReceiver extends BroadcastReceiver {
        private BatteryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RGHMHeatStrategy.this.a(intent);
        }
    }

    public RGHMHeatStrategy(e eVar, com.baidu.navisdk.ui.routeguide.heatmonitor.i.a aVar) {
        this.f8609a = aVar;
        this.b = eVar;
    }

    public void b(Context context) {
        context.unregisterReceiver(this.c);
    }

    public void a(Context context) {
        a(context.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        int a2;
        com.baidu.navisdk.ui.routeguide.heatmonitor.i.a aVar;
        if (intent == null || (a2 = a(intent.getIntExtra("temperature", 0) / 10, intent.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0))) == -1 || (aVar = this.f8609a) == null) {
            return;
        }
        aVar.a(a2);
    }

    private int a(int i, int i2) {
        if (this.b == null) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 1; i4 <= 3 && a(i, i2, this.b.a().get(Integer.valueOf(i4))); i4++) {
            i3 = i4;
        }
        return i3;
    }

    private boolean a(int i, int i2, e.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = aVar.b() == -1 || i >= aVar.b();
        if (aVar.a() == -1 || i2 == aVar.a()) {
            return z;
        }
        return false;
    }
}
