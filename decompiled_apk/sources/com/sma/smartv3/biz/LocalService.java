package com.sma.smartv3.biz;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.szabh.smable3.component.BleConnector;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class LocalService extends Service {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public ServiceReceiver f20074XO;

    /* loaded from: classes12.dex */
    public final class ServiceReceiver extends BroadcastReceiver {
        public ServiceReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.oOoXoXO Context context, @OXOo.oOoXoXO Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null && action.hashCode() == -1513032534 && action.equals("android.intent.action.TIME_TICK")) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("LocalService -> is running, connector state is " + BleConnector.INSTANCE.isAvailable());
            }
        }
    }

    public final void II0xO0() {
        ServiceReceiver serviceReceiver = this.f20074XO;
        if (serviceReceiver != null) {
            unregisterReceiver(serviceReceiver);
            this.f20074XO = null;
        }
    }

    public final void oIX0oI() {
        if (this.f20074XO == null) {
            this.f20074XO = new ServiceReceiver();
        }
        ServiceReceiver serviceReceiver = this.f20074XO;
        if (serviceReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_TICK");
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            registerReceiver(serviceReceiver, intentFilter);
        }
    }

    @Override // android.app.Service
    @OXOo.oOoXoXO
    public IBinder onBind(@OXOo.oOoXoXO Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        oIX0oI();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SmaNotification.f20192Oxx0IOOO.oIX0oI().X0o0xo(this);
        II0xO0();
    }

    @Override // android.app.Service
    public int onStartCommand(@OXOo.oOoXoXO Intent intent, int i, int i2) {
        SmaNotification.f20192Oxx0IOOO.oIX0oI().Oxx0IOOO(this);
        return 1;
    }
}
