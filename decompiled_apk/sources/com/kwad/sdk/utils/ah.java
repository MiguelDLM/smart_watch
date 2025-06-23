package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* loaded from: classes11.dex */
public final class ah {
    private static int aQA;
    private static boolean aQB;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo cw(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int cx(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.c)) {
            try {
                NetworkInfo cw = cw(context);
                if (cw != null && cw.isConnected()) {
                    if (1 == cw.getType()) {
                        return 100;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                    if (telephonyManager != null) {
                        int n = n(context, telephonyManager.getNetworkType());
                        if (n != 20) {
                            switch (n) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return 3;
                                case 13:
                                    return 4;
                                default:
                                    return 0;
                            }
                        }
                        return 5;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ah.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean gM(@NonNull String str) {
        if (!str.contains("nrState=NOT_RESTRICTED") && !str.contains("nrState=CONNECTED")) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public static boolean gN(String str) {
        return s(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cw = cw(context);
            if (cw == null) {
                return -1;
            }
            return cw.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT >= 24) {
            defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            return defaultDataSubscriptionId;
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cw = cw(context);
            if (cw != null && cw.isConnected()) {
                if (cw.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cw = cw(context);
            if (cw != null) {
                if (cw.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo cw = cw(context);
            if (cw != null && cw.isConnected()) {
                if (1 != cw.getType()) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i) {
        ServiceState serviceState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return i;
                }
                int subId = getSubId();
                if (subId == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else if (context.getApplicationInfo().targetSdkVersion >= 29 && i2 >= 29) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    try {
                        serviceState = (ServiceState) s.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                    } catch (Throwable unused) {
                        serviceState = telephonyManager.getServiceState();
                    }
                }
                if (serviceState == null) {
                    return i;
                }
                if (au.MP()) {
                    Integer num = (Integer) s.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                    if (num != null) {
                        return num.intValue();
                    }
                    return i;
                }
                if (gM(serviceState.toString())) {
                    return 20;
                }
                return i;
            } catch (Exception unused2) {
                return i;
            }
        }
        return i;
    }

    @WorkerThread
    private static boolean s(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
