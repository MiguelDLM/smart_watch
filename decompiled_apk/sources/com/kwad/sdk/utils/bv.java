package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class bv {
    private static boolean aSn = false;
    private static final List<a> aSo = new ArrayList();

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String aSp;
        public String aSq;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "level", this.level);
            t.putValue(jSONObject, "ssid", this.aSp);
            t.putValue(jSONObject, "bssid", this.aSq);
            return jSONObject;
        }
    }

    public static boolean dx(Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) != -1) {
                return false;
            }
            return true;
        }
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) != -1 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != -1) {
            return false;
        }
        return true;
    }

    public static List<a> o(Context context, int i) {
        if (av.Nc()) {
            return new ArrayList();
        }
        if (!aSn && ServiceProvider.Lx().canReadNearbyWifiList()) {
            List<a> list = aSo;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(32L)) {
                    return list;
                }
                try {
                } catch (Exception e) {
                    aSn = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
                if (dx(context)) {
                    return list;
                }
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.aSp = scanResult.SSID;
                        aVar.aSq = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aSo.add(0, aVar);
                        } else {
                            aSo.add(aVar);
                        }
                        List<a> list2 = aSo;
                        if (list2.size() >= i) {
                            return list2;
                        }
                    }
                }
                return aSo;
            }
        }
        return aSo;
    }
}
