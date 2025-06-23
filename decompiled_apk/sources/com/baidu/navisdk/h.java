package com.baidu.navisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.NetworkListenerV2;
import com.baidu.navisdk.util.listener.SDCardListener;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static NetworkListener f6858a = null;
    private static NetworkListenerV2 b = null;
    private static SDCardListener c = null;
    public static String d = "others";

    public static String a() {
        return a(true);
    }

    public static void b(int i) {
        com.baidu.navisdk.framework.b.h(i);
        x.a();
    }

    public static void c(int i) {
        if (j.d()) {
            com.baidu.navisdk.framework.b.i(i);
        } else {
            BNSettingManager.setDefaultRouteSort(i);
        }
    }

    public static void d(Context context) {
        c = new SDCardListener();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        if (context != null) {
            try {
                context.getApplicationContext().registerReceiver(c, intentFilter);
            } catch (Exception e) {
                LogUtil.printException("initSDCardListener", e);
            }
        }
    }

    public static void e(Context context) {
        a(1);
    }

    public static void f(Context context) {
        b(1);
    }

    public static String a(boolean z) {
        String g = com.baidu.navisdk.framework.b.g();
        return (TextUtils.isEmpty(g) && z) ? BNSettingManager.getPlateFromLocal() : g;
    }

    public static void e() {
        LogUtil.e("dingbin", "updateAppSource is " + d);
        if ("huawei".equals(d)) {
            com.baidu.navisdk.module.offscreen.a.g = true;
            d(1);
        } else if ("leshi".equals(d)) {
            com.baidu.navisdk.module.offscreen.a.g = true;
            d(2);
        } else {
            com.baidu.navisdk.module.offscreen.a.g = false;
            d(0);
        }
    }

    public static int b() {
        if (j.d()) {
            return com.baidu.navisdk.framework.b.r();
        }
        return BNSettingManager.getDefaultRouteSort();
    }

    public static void c(Context context) {
        f6858a = new NetworkListener(true);
        b = new NetworkListenerV2();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        if (context != null) {
            try {
                context.getApplicationContext().registerReceiver(f6858a, intentFilter, null, null);
                context.getApplicationContext().registerReceiver(b, intentFilter, null, null);
            } catch (Exception e) {
                LogUtil.printException("initNetworkListener", e);
            }
        }
    }

    public static void a(Context context, boolean z) {
        a(1, z);
    }

    public static void a(int i) {
        com.baidu.navisdk.framework.b.g(i);
        x.a();
    }

    public static void b(Context context) {
        if (j.d()) {
            d();
            d();
            c(context);
            d(context);
            com.baidu.navisdk.util.listener.a.b(context);
        }
    }

    public static void a(int i, boolean z) {
        com.baidu.navisdk.framework.b.a(i, z);
        x.a();
    }

    public static boolean a(String str) {
        o0.b().a(3001, null);
        return false;
    }

    private static void d() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        NetworkListener networkListener = f6858a;
        if (networkListener != null && a2 != null) {
            try {
                a2.unregisterReceiver(networkListener);
            } catch (Exception e) {
                LogUtil.printException("unRegister", e);
            }
            f6858a = null;
        }
        NetworkListenerV2 networkListenerV2 = b;
        if (networkListenerV2 != null && a2 != null) {
            try {
                a2.unregisterReceiver(networkListenerV2);
            } catch (Exception e2) {
                LogUtil.printException("unRegister", e2);
            }
            b = null;
        }
        SDCardListener sDCardListener = c;
        if (sDCardListener != null && a2 != null) {
            try {
                a2.unregisterReceiver(sDCardListener);
            } catch (Exception e3) {
                LogUtil.printException("unRegister2", e3);
            }
            c = null;
        }
        com.baidu.navisdk.util.listener.a.c();
    }

    public static void a(Context context) {
        if (!j.d()) {
            c(context);
            d(context);
            com.baidu.navisdk.util.listener.a.b(context);
        }
        JarUtils.setAsJar(context, false);
        if (j.d()) {
            a0.i(context);
        }
        if (j.d()) {
            return;
        }
        com.baidu.navisdk.util.statistic.r.s().n();
    }

    public static void b(boolean z) {
        if (!j.d()) {
            BNOfflineDataManager.getInstance().initDownloadInfo(z);
        } else {
            BNOfflineDataManager.getInstance().isProvinceDataDownload(0);
        }
    }

    public static int c() {
        return com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_rg_bg_a);
    }

    private static void d(int i) {
        g.a().b(i);
    }
}
