package com.jd.ad.sdk.jad_do;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class jad_jt {
    public static String jad_an() {
        String hostAddress;
        Matcher matcher;
        Pattern compile = Pattern.compile("(^10\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^172\\.(1[6-9]|2\\d|3[0-1])\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^192\\.168\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    return "";
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && (matcher = compile.matcher((hostAddress = nextElement2.getHostAddress()))) != null && matcher.matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while get ip: ");
            jad_an.append(e.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }

    public static String jad_bo(@NonNull Context context) {
        TelephonyManager telephonyManager;
        int simState;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (SecurityException e) {
            e.printStackTrace();
            telephonyManager = null;
        }
        if (telephonyManager == null || (simState = telephonyManager.getSimState()) == 0 || simState == 1) {
            return "";
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return !TextUtils.isEmpty(networkOperatorName) ? networkOperatorName.contains("移动") ? "mobile" : networkOperatorName.contains("联通") ? "unicom" : networkOperatorName.contains("电信") ? "telecom" : "" : "";
    }

    public static boolean jad_an(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
    
        if (r2 != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:11:0x0038, B:15:0x0075, B:42:0x006c), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int jad_an(android.content.Context r9, int r10) {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L99
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r3 = androidx.core.app.IXxxXO.oIX0oI(r9, r3)
            if (r3 != 0) goto L99
            java.lang.String r3 = "phone"
            java.lang.Object r9 = r9.getSystemService(r3)
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9
            r3 = 24
            r4 = -1
            if (r2 < r3) goto L22
            int r2 = xI0oxI00.oIX0oI.oIX0oI()
            goto L23
        L22:
            r2 = -1
        L23:
            if (r2 != r4) goto L27
            goto L87
        L27:
            java.lang.Class[] r3 = new java.lang.Class[r1]
            java.lang.Class r4 = java.lang.Integer.TYPE
            r3[r0] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r2
            java.lang.reflect.Method r2 = com.jd.ad.sdk.jad_do.jad_iv.jad_an
            r2 = 0
            boolean r5 = com.jd.ad.sdk.jad_do.jad_iv.jad_an()     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L72
            java.lang.reflect.Method r5 = com.jd.ad.sdk.jad_do.jad_iv.jad_an     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = "android.telephony.TelephonyManager"
            r6[r0] = r7     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r5 = r5.invoke(r2, r6)     // Catch: java.lang.Throwable -> L63
            java.lang.Class r5 = (java.lang.Class) r5     // Catch: java.lang.Throwable -> L63
            java.lang.reflect.Method r6 = com.jd.ad.sdk.jad_do.jad_iv.jad_bo     // Catch: java.lang.Throwable -> L63
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = "getServiceStateForSubscriber"
            r7[r0] = r8     // Catch: java.lang.Throwable -> L68
            r7[r1] = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r6.invoke(r5, r7)     // Catch: java.lang.Throwable -> L63
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L63
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L61
            goto L73
        L61:
            r1 = move-exception
            goto L6c
        L63:
            r1 = move-exception
        L64:
            r0 = r2
            goto L6c
        L66:
            r1 = r0
            goto L64
        L68:
            r0 = move-exception
            goto L66
        L6a:
            r0 = move-exception
            goto L66
        L6c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L70
            goto L73
        L70:
            r0 = move-exception
            goto L7a
        L72:
            r0 = r2
        L73:
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r0.invoke(r9, r4)     // Catch: java.lang.Throwable -> L70
            goto L7e
        L7a:
            r0.printStackTrace()
        L7d:
            r0 = r2
        L7e:
            boolean r1 = r0 instanceof android.telephony.ServiceState
            if (r1 == 0) goto L85
            r2 = r0
            android.telephony.ServiceState r2 = (android.telephony.ServiceState) r2
        L85:
            if (r2 != 0) goto L8b
        L87:
            android.telephony.ServiceState r2 = xI0oxI00.II0xO0.oIX0oI(r9)
        L8b:
            if (r2 == 0) goto L99
            java.lang.String r9 = r2.toString()
            boolean r9 = jad_an(r9)
            if (r9 == 0) goto L99
            r10 = 8
        L99:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_do.jad_jt.jad_an(android.content.Context, int):int");
    }

    @SuppressLint({"MissingPermission"})
    public static int jad_an(Context context) {
        ConnectivityManager connectivityManager;
        int i = 0;
        if (context == null || ContextCompat.checkSelfPermission(context, g.b) == -1) {
            return 0;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (SecurityException e) {
            e.printStackTrace();
            connectivityManager = null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                try {
                    if (Build.VERSION.SDK_INT < 30 || ContextCompat.checkSelfPermission(context, g.c) != -1) {
                        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        if (networkType != 20) {
                            switch (networkType) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    i = 5;
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    i = 6;
                                    break;
                                case 13:
                                    try {
                                        i = jad_an(context, 7);
                                        break;
                                    } catch (Throwable unused) {
                                    }
                                case 16:
                                case 17:
                                    i = 7;
                                    break;
                                default:
                                    i = 4;
                                    break;
                            }
                        } else {
                            i = 8;
                        }
                    }
                } catch (Throwable unused2) {
                }
                i = 1;
            } else if (type != 1) {
                if (type == 9) {
                    i = 2;
                }
                i = 1;
            } else {
                i = 3;
            }
        }
        return com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i != 0 ? i : 1);
    }
}
