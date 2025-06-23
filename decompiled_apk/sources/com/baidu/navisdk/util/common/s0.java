package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.wifi.WifiManager;

/* loaded from: classes8.dex */
public class s0 {
    public static int a(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            try {
                return wifiManager.getWifiState();
            } catch (Throwable th) {
                if (g.COMMON.c()) {
                    g.COMMON.c("WifiUtils", "getWifiState: " + th.getMessage());
                }
                g gVar = g.COMMON;
                if (gVar.b()) {
                    gVar.a("WifiUtils", th);
                }
            }
        }
        return 4;
    }

    public static boolean b(Context context) {
        int a2 = a(context);
        if (a2 != 3 && a2 != 2) {
            return false;
        }
        return true;
    }
}
