package com.baidu.navisdk.util.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
class NaviStatItem$1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9356a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        float a2;
        boolean z;
        String str;
        boolean z2;
        if (intent != null) {
            if (intent.getIntExtra("status", 1) == 2) {
                z = this.f9356a.b;
                if (!z) {
                    this.f9356a.b = true;
                }
                str = l.c;
                StringBuilder sb = new StringBuilder();
                sb.append("startStat battery has charge  :");
                z2 = this.f9356a.b;
                sb.append(z2);
                LogUtil.e(str, sb.toString());
            }
            l lVar = this.f9356a;
            a2 = lVar.a(intent.getIntExtra("level", 0), intent.getIntExtra("scale", 100));
            lVar.f9377a = a2;
        }
    }
}
