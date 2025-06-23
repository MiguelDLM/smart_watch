package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.d;
import com.baidu.navisdk.util.common.x;

/* loaded from: classes8.dex */
public class RingModeStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9313a = false;
    private static RingModeStatusReceiver b = new RingModeStatusReceiver();
    private static ContentObserver c = new b(new a("RMSR"));

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
        }
    }

    private RingModeStatusReceiver() {
    }

    public static void a(Context context) {
        LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver");
        if (context != null && !f9313a) {
            IntentFilter intentFilter = new IntentFilter("android.media.RINGER_MODE_CHANGED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            try {
                context.registerReceiver(b, intentFilter);
                f9313a = true;
            } catch (Exception e) {
                LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver cause :" + e.getCause());
                LogUtil.e("RingModeStatusReceiver", "initRingModeStatusReceiver crash :" + e.getMessage());
            }
            if (a0.l()) {
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("volume_panel_mute_enable"), true, c);
            }
        }
    }

    public static void b(Context context) {
        LogUtil.e("RingModeStatusReceiver", "uninitRingModeStatusReceiver");
        if (context != null && f9313a) {
            f9313a = false;
            try {
                context.unregisterReceiver(b);
            } catch (Exception e) {
                LogUtil.e("RingModeStatusReceiver", "uninitRingModeStatusReceiver crash :" + e.getMessage());
            }
            if (a0.l()) {
                context.getContentResolver().unregisterContentObserver(c);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        n n;
        boolean z;
        String action = intent.getAction();
        LogUtil.e("RingModeStatusReceiver", "action:" + action);
        if ("android.media.RINGER_MODE_CHANGED".equals(action) && (n = x.n()) != null) {
            if (d.c(context) <= 0) {
                z = true;
            } else {
                z = false;
            }
            n.a(z);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            LogUtil.e("RingModeStatusReceiver", "deliverSelfNotifications");
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            LogUtil.e("RingModeStatusReceiver", "onChange selfChange:" + z);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            LogUtil.e("RingModeStatusReceiver", "onChange selfChange:" + z + ", Uri:" + uri.toString());
            n n = x.n();
            if (n != null) {
                n.a(d.c(com.baidu.navisdk.framework.a.c().a()) <= 0);
            }
        }
    }
}
