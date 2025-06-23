package com.sma.smartv3.screen_lock;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.sma.smartv3.screen_lock.ScreenLockService$mReceiver$2;
import com.sma.smartv3.ui.sport.SportScreenLockActivity;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;

/* loaded from: classes12.dex */
public final class ScreenLockService extends Service {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final X0IIOO f21575XO = XIxXXX0x0.oIX0oI(new oIX0oI<ScreenLockService$mReceiver$2.AnonymousClass1>() { // from class: com.sma.smartv3.screen_lock.ScreenLockService$mReceiver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.sma.smartv3.screen_lock.ScreenLockService$mReceiver$2$1] */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final AnonymousClass1 invoke() {
            final ScreenLockService screenLockService = ScreenLockService.this;
            return new BroadcastReceiver() { // from class: com.sma.smartv3.screen_lock.ScreenLockService$mReceiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@OOXIXo Context context, @OOXIXo Intent intent) {
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(intent, "intent");
                    Object systemService = context.getSystemService("keyguard");
                    IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
                    KeyguardManager keyguardManager = (KeyguardManager) systemService;
                    if (OxI.x00IOx(intent.getAction(), "android.intent.action.SCREEN_OFF", false, 2, null)) {
                        Intent intent2 = new Intent(context, (Class<?>) SportScreenLockActivity.class);
                        intent2.addFlags(276824064);
                        ScreenLockService.this.startActivity(intent2);
                    } else if (OxI.x00IOx(intent.getAction(), "android.intent.action.USER_PRESENT", false, 2, null) && keyguardManager.isKeyguardSecure()) {
                        x0xO0oo.II0xO0(x0xO0oo.f24658xXOx, null, 2, null);
                    }
                }
            };
        }
    });

    public final ScreenLockService$mReceiver$2.AnonymousClass1 oIX0oI() {
        return (ScreenLockService$mReceiver$2.AnonymousClass1) this.f21575XO.getValue();
    }

    @Override // android.app.Service
    @oOoXoXO
    public IBinder onBind(@oOoXoXO Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(oIX0oI(), intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(oIX0oI());
    }
}
