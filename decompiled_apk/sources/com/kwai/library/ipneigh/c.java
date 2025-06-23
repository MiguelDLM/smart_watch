package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: classes11.dex */
public final class c {
    private static d b(Context context, boolean z, boolean z2) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String ev = b.ev(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z) {
                str = "";
            } else {
                str = a.hy("timeout 5 ip neigh show " + ev);
            }
            if (z || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.i(ev, false);
            }
            return new d(b.hA(str), !TextUtils.isEmpty(r3), str);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d dK(Context context) {
        return y(context, false);
    }

    private static d y(Context context, boolean z) {
        return b(context, false, false);
    }
}
