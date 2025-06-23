package com.baidu.navisdk.ui.routeguide.control.indoorpark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes8.dex */
public class BluetoothListenerReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private a f8548a;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z);
    }

    public BluetoothListenerReceiver(a aVar) {
        this.f8548a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (intExtra != 10) {
                if (intExtra == 12 && (aVar = this.f8548a) != null) {
                    aVar.a(true);
                    return;
                }
                return;
            }
            a aVar2 = this.f8548a;
            if (aVar2 != null) {
                aVar2.a(false);
            }
        }
    }
}
