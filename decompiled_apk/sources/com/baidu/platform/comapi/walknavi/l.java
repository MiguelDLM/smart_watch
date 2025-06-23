package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class l extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9828a;

    public l(b bVar) {
        this.f9828a = bVar;
    }

    private void a(Context context) {
        Context context2;
        Context context3;
        context2 = this.f9828a.B;
        int a2 = com.baidu.platform.comapi.wnplatform.p.l.a(context2);
        if (a2 != 0) {
            com.baidu.platform.comapi.walknavi.b.a.f9701a = a2;
            context3 = this.f9828a.B;
            com.baidu.platform.comapi.wnplatform.p.l.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.f9828a.D;
        handler.postDelayed(new m(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("state");
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
            b(context);
        }
    }
}
