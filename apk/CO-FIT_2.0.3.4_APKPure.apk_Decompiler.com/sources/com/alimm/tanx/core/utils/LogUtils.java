package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.TanxCoreSdk;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class LogUtils implements NotConfused {
    private static final String LOG_TAG = "TanxAdSdk";
    private static volatile LogStatus logStatus = LogStatus.LOG_DEFAULT;
    private static final String[] tagCloseSwitch = {"UtRequest", "TanxAdMonitor", "TanxAdMonitor-Cover"};
    private static List<String> tagCloseSwitchList;

    /* renamed from: com.alimm.tanx.core.utils.LogUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] tanxc_do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alimm.tanx.core.utils.LogStatus[] r0 = com.alimm.tanx.core.utils.LogStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                tanxc_do = r0
                com.alimm.tanx.core.utils.LogStatus r1 = com.alimm.tanx.core.utils.LogStatus.LOG_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = tanxc_do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alimm.tanx.core.utils.LogStatus r1 = com.alimm.tanx.core.utils.LogStatus.LOG_DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = tanxc_do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alimm.tanx.core.utils.LogStatus r1 = com.alimm.tanx.core.utils.LogStatus.LOG_ALL_CLOSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.LogUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static void d(String str, String str2) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
        }
    }

    public static void d2print(String str, String str2) {
        startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
    }

    public static void e(String str, String str2) {
        e(str, str2, "");
    }

    private static String getLogString(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static String getStackTraceMessage(Throwable th) {
        if (th == null) {
            return "本次throwable为null";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.toString();
    }

    public static void i(String str, String str2) {
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "i");
        }
    }

    public static boolean isDebug(String str) {
        try {
            str.hashCode();
            if (TanxCoreSdk.getConfig().isDebugMode() || Log.isLoggable(LOG_TAG, 2)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("isDebug", getStackTraceMessage(e));
            return false;
        }
    }

    public static boolean isLogSwitch(String str, String str2) {
        try {
            int i = AnonymousClass1.tanxc_do[logStatus.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (tagCloseSwitchList == null) {
                        tagCloseSwitchList = Arrays.asList(tagCloseSwitch);
                    }
                    boolean contains = tagCloseSwitchList.contains(str);
                    if (!isDebug(str2) || contains) {
                        return false;
                    }
                    return true;
                } else if (i != 3) {
                    return true;
                } else {
                    return false;
                }
            } else if (str2.equals(e.TAG)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e("isLogSwitch", getStackTraceMessage(e));
            return true;
        }
    }

    public static void setLogStatus(LogStatus logStatus2) {
        logStatus = logStatus2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (r5.length() <= r0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        android.util.Log.w(r4, r5.substring(0, r0));
        r5 = r5.substring(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        android.util.Log.w(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r5.length() <= r0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        android.util.Log.v(r4, r5.substring(0, r0));
        r5 = r5.substring(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        android.util.Log.v(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (r5.length() <= r0) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        android.util.Log.i(r4, r5.substring(0, r0));
        r5 = r5.substring(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        android.util.Log.i(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b2, code lost:
        if (r5.length() <= r0) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        android.util.Log.e(r4, r5.substring(0, r0));
        r5 = r5.substring(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c0, code lost:
        android.util.Log.e(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        if (r5.length() <= r0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        android.util.Log.d(r4, r5.substring(0, r0));
        r5 = r5.substring(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        android.util.Log.d(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startPrint(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = " [SDK Version:"
            r0.append(r5)
            java.lang.String r5 = com.alimm.tanx.core.SdkConstant.getSdkVersion()
            r0.append(r5)
            java.lang.String r5 = "]"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            int r0 = r4.length()
            int r0 = 2001 - r0
            r6.hashCode()
            r1 = 0
            r2 = -1
            int r3 = r6.hashCode()
            switch(r3) {
                case 100: goto L_0x005d;
                case 101: goto L_0x0052;
                case 105: goto L_0x0047;
                case 118: goto L_0x003c;
                case 119: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x0067
        L_0x0030:
            java.lang.String r3 = "w"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x003a
            goto L_0x0067
        L_0x003a:
            r2 = 4
            goto L_0x0067
        L_0x003c:
            java.lang.String r3 = "v"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0045
            goto L_0x0067
        L_0x0045:
            r2 = 3
            goto L_0x0067
        L_0x0047:
            java.lang.String r3 = "i"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0050
            goto L_0x0067
        L_0x0050:
            r2 = 2
            goto L_0x0067
        L_0x0052:
            java.lang.String r3 = "e"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x005b
            goto L_0x0067
        L_0x005b:
            r2 = 1
            goto L_0x0067
        L_0x005d:
            java.lang.String r3 = "d"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r2 = 0
        L_0x0067:
            switch(r2) {
                case 0: goto L_0x00c4;
                case 1: goto L_0x00ae;
                case 2: goto L_0x0098;
                case 3: goto L_0x0082;
                case 4: goto L_0x006c;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x00d9
        L_0x006c:
            int r6 = r5.length()
            if (r6 <= r0) goto L_0x007e
            java.lang.String r6 = r5.substring(r1, r0)
            android.util.Log.w(r4, r6)
            java.lang.String r5 = r5.substring(r0)
            goto L_0x006c
        L_0x007e:
            android.util.Log.w(r4, r5)
            goto L_0x00d9
        L_0x0082:
            int r6 = r5.length()
            if (r6 <= r0) goto L_0x0094
            java.lang.String r6 = r5.substring(r1, r0)
            android.util.Log.v(r4, r6)
            java.lang.String r5 = r5.substring(r0)
            goto L_0x0082
        L_0x0094:
            android.util.Log.v(r4, r5)
            goto L_0x00d9
        L_0x0098:
            int r6 = r5.length()
            if (r6 <= r0) goto L_0x00aa
            java.lang.String r6 = r5.substring(r1, r0)
            android.util.Log.i(r4, r6)
            java.lang.String r5 = r5.substring(r0)
            goto L_0x0098
        L_0x00aa:
            android.util.Log.i(r4, r5)
            goto L_0x00d9
        L_0x00ae:
            int r6 = r5.length()
            if (r6 <= r0) goto L_0x00c0
            java.lang.String r6 = r5.substring(r1, r0)
            android.util.Log.e(r4, r6)
            java.lang.String r5 = r5.substring(r0)
            goto L_0x00ae
        L_0x00c0:
            android.util.Log.e(r4, r5)
            goto L_0x00d9
        L_0x00c4:
            int r6 = r5.length()
            if (r6 <= r0) goto L_0x00d6
            java.lang.String r6 = r5.substring(r1, r0)
            android.util.Log.d(r4, r6)
            java.lang.String r5 = r5.substring(r0)
            goto L_0x00c4
        L_0x00d6:
            android.util.Log.d(r4, r5)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.utils.LogUtils.startPrint(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void v(String str, String str2) {
        if (isLogSwitch(str, t.c)) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, t.c);
        }
    }

    public static void w(String str, String... strArr) {
        if (isLogSwitch(str, IAdInterListener.AdReqParam.WIDTH)) {
            startPrint(LOG_TAG, getLogString(str, strArr), IAdInterListener.AdReqParam.WIDTH);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, e.TAG);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2 + getStackTraceMessage(th), "d");
        }
    }

    public static void i(String str, String... strArr) {
        if (isLogSwitch(str, "i")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "i");
        }
    }

    public static void e(Exception exc) {
        e("", exc);
    }

    public static void d(String str, String... strArr) {
        if (isLogSwitch(str, "d")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "d");
        }
    }

    public static void e(String str, Exception exc) {
        e(str, exc, "");
    }

    public static void e(String str, Exception exc, String str2) {
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + getStackTraceMessage(exc), e.TAG);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isLogSwitch(str, e.TAG)) {
            startPrint(LOG_TAG, "[" + str + "] " + (str2 + getStackTraceMessage(th)), e.TAG);
        }
    }
}
