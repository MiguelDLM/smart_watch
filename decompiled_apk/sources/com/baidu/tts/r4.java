package com.baidu.tts;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;

/* loaded from: classes8.dex */
public class r4 extends a5<r4> {
    public t2 c;
    public int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public e0 f10162a = new e0();
    public d0.b b = new d0.b();

    public void b() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Network activeNetwork;
        g4 a2 = g4.a();
        boolean z = false;
        a2.c = false;
        a2.f10097a = 0;
        a2.b = 0;
        Context c = e3.e().c();
        if (c != null && (activeNetworkInfo = (connectivityManager = (ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                LoggerProxy.d(g4.d, "updateNetworkStatus networkCapabilities = " + networkCapabilities);
                if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                    z = true;
                }
                a2.c = z;
            } else {
                a2.c = activeNetworkInfo.isConnected();
            }
            if (a2.c) {
                a2.f10097a = activeNetworkInfo.getType();
                a2.b = activeNetworkInfo.getSubtype();
            }
            LoggerProxy.d(g4.d, "updateNetworkStatus mIsConnected = " + a2.c + " , mNetworkType = " + a2.f10097a + " , mNetworkSubtype = " + a2.b);
        }
        this.d = g4.a().b();
    }

    public String c() {
        String str;
        String str2;
        e0 e0Var = this.f10162a;
        if (e0Var == null || (str = e0Var.g) == null) {
            str = null;
        }
        d0.b bVar = this.b;
        if (bVar != null && (str2 = bVar.f) != null) {
            return str2;
        }
        return str;
    }
}
