package com.baidu.mapapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.baidu.mapsdkplatform.comapi.util.i;
import com.baidu.platform.comapi.util.SysOSUtil;

@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    private Context f5765a;

    public b(Context context) {
        this.f5765a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (network == null) {
            return;
        }
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        if (network != null && networkCapabilities != null) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                boolean hasTransport = networkCapabilities.hasTransport(1);
                boolean hasTransport2 = networkCapabilities.hasTransport(0);
                boolean hasTransport3 = networkCapabilities.hasTransport(3);
                boolean hasTransport4 = networkCapabilities.hasTransport(6);
                boolean hasTransport5 = networkCapabilities.hasTransport(4);
                boolean hasTransport6 = networkCapabilities.hasTransport(5);
                if (hasTransport) {
                    str = "WIFI";
                } else if (hasTransport2) {
                    str = "CELLULAR";
                } else if (hasTransport3) {
                    str = "ETHERNET";
                } else if (hasTransport4) {
                    str = "LoWPAN";
                } else if (hasTransport5) {
                    str = "VPN";
                } else if (hasTransport6) {
                    str = "WifiAware";
                } else {
                    str = "mobile";
                }
                String h = i.h();
                if (h != null && !h.equals(str)) {
                    i.a(str);
                    Context context = this.f5765a;
                    if (context != null) {
                        NetworkUtil.updateNetworkProxy(context);
                    }
                }
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        if (network == null) {
            return;
        }
        super.onLost(network);
        SysOSUtil.getInstance().updateNetType("mobile");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        SysOSUtil.getInstance().updateNetType("mobile");
    }
}
