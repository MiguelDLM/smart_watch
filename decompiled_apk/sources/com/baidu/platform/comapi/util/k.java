package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class k extends ConnectivityManager.NetworkCallback {
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
                }
                SysOSUtil.getInstance().updateNetType(str);
            }
            str = "mobile";
            SysOSUtil.getInstance().updateNetType(str);
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
