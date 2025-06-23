package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f26616a = true;
    public static List<o> b = new ArrayList();
    public static boolean c;
    private static w d;
    private static boolean e;

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.v;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (p.class) {
            if (e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(al.b, "[init] context of init() is null, check it.");
                return;
            }
            aa a2 = aa.a(context);
            if (a(a2)) {
                f26616a = false;
                return;
            }
            String e2 = a2.e();
            if (e2 == null) {
                Log.e(al.b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
            } else {
                a(context, e2, a2.D, buglyStrategy);
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (p.class) {
            if (e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(al.b, "[init] context is null, check it.");
                return;
            }
            if (str == null) {
                Log.e(al.b, "init arg 'crashReportAppID' should not be null!");
                return;
            }
            e = true;
            if (z) {
                c = true;
                al.c = true;
                al.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                al.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                al.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                al.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                al.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                al.b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            al.a(" crash report start initializing...", new Object[0]);
            al.b("[init] Bugly start initializing...", new Object[0]);
            al.a("[init] Bugly complete version: v%s", "4.1.9.3");
            Context a2 = ap.a(context);
            aa a3 = aa.a(a2);
            a3.o();
            ao.a(a2);
            d = w.a(a2, b);
            ai.a(a2);
            ac.a(a2, b);
            u a4 = u.a(a2);
            if (a(a3)) {
                f26616a = false;
                return;
            }
            a3.r = str;
            a3.b("APP_ID", str);
            al.a("[param] Set APP ID:%s", str);
            if (buglyStrategy != null) {
                String appVersion = buglyStrategy.getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    if (appVersion.length() > 100) {
                        String substring = appVersion.substring(0, 100);
                        al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                        appVersion = substring;
                    }
                    a3.o = appVersion;
                    al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                }
                try {
                    if (buglyStrategy.isReplaceOldChannel()) {
                        String appChannel = buglyStrategy.getAppChannel();
                        if (!TextUtils.isEmpty(appChannel)) {
                            if (appChannel.length() > 100) {
                                String substring2 = appChannel.substring(0, 100);
                                al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                appChannel = substring2;
                            }
                            d.a(556, "app_channel", appChannel.getBytes(), false);
                            a3.s = appChannel;
                        }
                    } else {
                        Map<String, byte[]> a5 = d.a(556, (v) null);
                        if (a5 != null && (bArr = a5.get("app_channel")) != null) {
                            a3.s = new String(bArr);
                        }
                    }
                    al.a("[param] Set App channel: %s", a3.s);
                } catch (Exception e2) {
                    if (c) {
                        e2.printStackTrace();
                    }
                }
                String appPackageName = buglyStrategy.getAppPackageName();
                if (!TextUtils.isEmpty(appPackageName)) {
                    if (appPackageName.length() > 100) {
                        String substring3 = appPackageName.substring(0, 100);
                        al.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                        appPackageName = substring3;
                    }
                    a3.c = appPackageName;
                    al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                }
                String deviceID = buglyStrategy.getDeviceID();
                if (deviceID != null) {
                    if (deviceID.length() > 100) {
                        String substring4 = deviceID.substring(0, 100);
                        al.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                        deviceID = substring4;
                    }
                    a3.a(deviceID);
                    al.a("[param] Set device ID: %s", deviceID);
                }
                String deviceModel = buglyStrategy.getDeviceModel();
                if (deviceModel != null) {
                    a3.b(deviceModel);
                    al.a("[param] Set device model: %s", deviceModel);
                }
                a3.f = buglyStrategy.isUploadProcess();
                ao.b = buglyStrategy.isBuglyLogUpload();
            }
            for (int i = 0; i < b.size(); i++) {
                try {
                    if (a4.b(b.get(i).id)) {
                        b.get(i).init(a2, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            s.a(a2, buglyStrategy);
            long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
            final ac a6 = ac.a();
            a6.c.a(new Thread() { // from class: com.tencent.bugly.proguard.ac.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        Map<String, byte[]> a7 = w.a().a(ac.f26526a, (v) null);
                        if (a7 != null) {
                            byte[] bArr2 = a7.get(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
                            byte[] bArr3 = a7.get("gateway");
                            if (bArr2 != null) {
                                aa.a(ac.this.h).d(new String(bArr2));
                            }
                            if (bArr3 != null) {
                                aa.a(ac.this.h).c(new String(bArr3));
                            }
                        }
                        ac.this.g = ac.d();
                        if (ac.this.g != null) {
                            if (ap.b(ac.i) || !ap.d(ac.i)) {
                                ac.this.g.q = StrategyBean.f26512a;
                                ac.this.g.r = StrategyBean.b;
                            } else {
                                ac.this.g.q = ac.i;
                                ac.this.g.r = ac.i;
                            }
                        }
                    } catch (Throwable th2) {
                        if (!al.a(th2)) {
                            th2.printStackTrace();
                        }
                    }
                    ac acVar = ac.this;
                    acVar.a(acVar.g, false);
                }
            }, appReportDelay);
            al.b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    public static synchronized void a(o oVar) {
        synchronized (p.class) {
            if (!b.contains(oVar)) {
                b.add(oVar);
            }
        }
    }
}
