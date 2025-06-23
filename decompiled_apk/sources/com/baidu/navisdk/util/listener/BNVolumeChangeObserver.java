package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;
import com.huawei.openalliance.ad.constant.x;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class BNVolumeChangeObserver {

    /* renamed from: a, reason: collision with root package name */
    private Context f9304a;
    private BNVolumeBroadcastReceiver b;

    /* loaded from: classes8.dex */
    public static class BNVolumeBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f9305a;

        public BNVolumeBroadcastReceiver(a aVar) {
            this.f9305a = new WeakReference<>(aVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            if (x.cg.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (aVar = this.f9305a.get()) != null) {
                int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
                int intExtra2 = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNVolumeChangeObserver", "onReceive VOLUME_CHANGED_ACTION currVolume: " + intExtra + ",preVolume: " + intExtra2);
                }
                if (intExtra != -1 && intExtra2 != -1) {
                    aVar.a(intExtra, intExtra2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, int i2);
    }

    public void a(Context context, a aVar) {
        if (aVar == null || context == null) {
            return;
        }
        this.f9304a = context;
        this.b = new BNVolumeBroadcastReceiver(aVar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.cg);
        this.f9304a.registerReceiver(this.b, intentFilter);
    }

    public void a() {
        Context context;
        BNVolumeBroadcastReceiver bNVolumeBroadcastReceiver = this.b;
        if (bNVolumeBroadcastReceiver == null || (context = this.f9304a) == null) {
            return;
        }
        context.unregisterReceiver(bNVolumeBroadcastReceiver);
        this.b = null;
        this.f9304a = null;
    }
}
