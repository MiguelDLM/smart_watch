package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;

/* loaded from: classes7.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a, reason: collision with root package name */
    private static NACommonMemCache f6149a = null;
    private static boolean b = false;
    private static String c = "";
    private static int d;

    public SysUpdateUtil() {
        f6149a = f.c();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init(String str) {
        if (f6149a != null) {
            if (TextUtils.isEmpty(str)) {
                str = SyncSysInfo.getPhoneInfoCache();
            }
            f6149a.a(str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateCuid(String str) {
        NACommonMemCache nACommonMemCache = f6149a;
        if (nACommonMemCache != null) {
            nACommonMemCache.a("cuid", str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkProxy(Context context) {
        NetworkInfo activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
            if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
                b = false;
                return;
            }
            if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                b = false;
                if (extraInfo != null) {
                    String lowerCase2 = extraInfo.toLowerCase();
                    if (!lowerCase2.startsWith("cmwap") && !lowerCase2.startsWith("uniwap") && !lowerCase2.startsWith("3gwap")) {
                        if (lowerCase2.startsWith("ctwap")) {
                            c = "10.0.0.200";
                            d = 80;
                            b = true;
                            return;
                        } else {
                            if (lowerCase2.startsWith("cmnet") || lowerCase2.startsWith("uninet") || lowerCase2.startsWith("ctnet") || lowerCase2.startsWith("3gnet")) {
                                b = false;
                                return;
                            }
                            return;
                        }
                    }
                    c = "10.0.0.172";
                    d = 80;
                    b = true;
                    return;
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if ("10.0.0.172".equals(defaultHost.trim())) {
                        c = "10.0.0.172";
                        d = defaultPort;
                        b = true;
                    } else if ("10.0.0.200".equals(defaultHost.trim())) {
                        c = "10.0.0.200";
                        d = 80;
                        b = true;
                    }
                }
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo(String str) {
        NACommonMemCache nACommonMemCache = f6149a;
        if (nACommonMemCache != null) {
            String b2 = nACommonMemCache.b("logstatistics");
            f6149a.a(str);
            f6149a.b("logstatistics", b2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateZid(String str) {
        NACommonMemCache nACommonMemCache = f6149a;
        if (nACommonMemCache != null) {
            nACommonMemCache.a("zid", str);
        }
    }
}
