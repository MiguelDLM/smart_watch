package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.i;

/* loaded from: classes7.dex */
public class f extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6163a = "f";

    public void a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String h = i.h();
        if (h != null && !h.equals(currentNetMode)) {
            i.a(currentNetMode);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
