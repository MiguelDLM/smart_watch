package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class LogUtils implements NotConfused {
    private static final String LOG_TAG = "TanxAdSdk";
    private static List<String> tagCloseSwitchList;
    private static final String[] tagCloseSwitch = {"UtRequest", "TanxAdMonitor", "TanxAdMonitor-Cover"};
    private static volatile LogStatus logStatus = LogStatus.LOG_DEFAULT;

    /* renamed from: com.alimm.tanx.core.utils.LogUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] tanxc_do;

        static {
            int[] iArr = new int[LogStatus.values().length];
            tanxc_do = iArr;
            try {
                iArr[LogStatus.LOG_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tanxc_do[LogStatus.LOG_DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tanxc_do[LogStatus.LOG_ALL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
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
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
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
            if (!TanxCoreSdk.getConfig().isDebugMode()) {
                if (!Log.isLoggable(LOG_TAG, 2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("isDebug", getStackTraceMessage(e));
            return false;
        }
    }

    public static boolean isLogSwitch(String str, String str2) {
        try {
            int i = AnonymousClass1.tanxc_do[logStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return true;
                    }
                    return false;
                }
                if (tagCloseSwitchList == null) {
                    tagCloseSwitchList = Arrays.asList(tagCloseSwitch);
                }
                boolean contains = tagCloseSwitchList.contains(str);
                if (isDebug(str2) && !contains) {
                    return true;
                }
                return false;
            }
            if (str2.equals(e.TAG)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("isLogSwitch", getStackTraceMessage(e));
            return true;
        }
    }

    public static void setLogStatus(LogStatus logStatus2) {
        logStatus = logStatus2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0067. Please report as an issue. */
    public static void startPrint(String str, String str2, String str3) {
        String str4 = str2 + " [SDK Version:" + SdkConstant.getSdkVersion() + "]";
        int length = 2001 - str.length();
        str3.hashCode();
        char c = 65535;
        switch (str3.hashCode()) {
            case 100:
                if (str3.equals("d")) {
                    c = 0;
                    break;
                }
                break;
            case 101:
                if (str3.equals(e.TAG)) {
                    c = 1;
                    break;
                }
                break;
            case 105:
                if (str3.equals("i")) {
                    c = 2;
                    break;
                }
                break;
            case 118:
                if (str3.equals(t.c)) {
                    c = 3;
                    break;
                }
                break;
            case 119:
                if (str3.equals(IAdInterListener.AdReqParam.WIDTH)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                while (str4.length() > length) {
                    Log.d(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.d(str, str4);
                return;
            case 1:
                while (str4.length() > length) {
                    Log.e(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.e(str, str4);
                return;
            case 2:
                while (str4.length() > length) {
                    Log.i(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.i(str, str4);
                return;
            case 3:
                while (str4.length() > length) {
                    Log.v(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.v(str, str4);
                return;
            case 4:
                while (str4.length() > length) {
                    Log.w(str, str4.substring(0, length));
                    str4 = str4.substring(length);
                }
                Log.w(str, str4);
                return;
            default:
                return;
        }
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
