package com.baidu.navisdk.util.common;

import XXO0.oIX0oI;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes8.dex */
public class LogUtil {
    public static final boolean DEBUG = false;
    private static final String DEFAULT_TAG = "BaiduNavi";
    public static boolean LOGGABLE = false;
    public static boolean LOGWRITE = false;
    public static boolean OUT_LOGGABLE = false;
    private static final String TAG = "LogUtil";

    public static void autoCheck(String str, String str2) {
        e(TAG, "autoCheck--");
        if (LOGGABLE) {
            String str3 = "[auto_check]BN_AND[" + str + "]BN_AND" + str2;
            Log.e(SDKDebugFileUtil.AUTO_CHECK_LOG, str3);
            SDKDebugFileUtil.get(SDKDebugFileUtil.AUTO_CHECK_LOG).asyncAdd(str3);
        }
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
        if (LOGWRITE) {
            SDKDebugFileUtil.getInstance().addCoreLog("ALL: ", makeLogDetailInfoString(str, str2, getValidStackTrace()));
        }
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (LOGGABLE) {
            String makeLogDetailInfoString = makeLogDetailInfoString(str, str2, getValidStackTrace());
            Log.e(DEFAULT_TAG, makeLogDetailInfoString);
            SDKDebugFileUtil.get(SDKDebugFileUtil.FIX_ALL_LOG).asyncAdd(makeLogDetailInfoString);
            SDKDebugFileUtil.get(SDKDebugFileUtil.FIX_ALL_LOG).asyncAdd(getCallStack());
        }
    }

    public static String getCallStack() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length; i++) {
                stringBuffer.append("at " + stackTrace[i].getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTrace[i].getMethodName() + oIX0oI.I0Io.f4096II0xO0 + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ")\n");
            }
        }
        return stringBuffer.toString();
    }

    private static StackTraceElement getValidStackTrace() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = null;
        if (stackTrace == null) {
            return null;
        }
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement2 = stackTrace[i];
            if (stackTraceElement2.getFileName() == null || (!stackTraceElement2.getFileName().contains(TAG) && !stackTraceElement2.getFileName().contains("NavLogUtils.java"))) {
                stackTraceElement = stackTraceElement2;
                break;
            }
        }
        if (stackTraceElement == null) {
            return stackTrace[0];
        }
        return stackTraceElement;
    }

    private static String makeLogDetailInfoString(String str, String str2, StackTraceElement stackTraceElement) {
        return "[" + str + "]-" + stackTraceElement.getFileName() + oIX0oI.I0Io.f4096II0xO0 + stackTraceElement.getLineNumber() + "): " + str2;
    }

    public static void out(String str, String str2) {
        if (OUT_LOGGABLE) {
            String makeLogDetailInfoString = makeLogDetailInfoString(str, str2, getValidStackTrace());
            Log.e(DEFAULT_TAG, makeLogDetailInfoString);
            SDKDebugFileUtil.get(SDKDebugFileUtil.NORMAL_ALL_LOG).asyncAdd(makeLogDetailInfoString);
        }
    }

    public static void outPrintCallStack() {
        Throwable th;
        if (TextUtils.isEmpty("message")) {
            th = new Throwable();
        } else {
            th = new Throwable("message");
        }
        outPrintExceptionStack(th);
    }

    private static void outPrintExceptionStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        if (stackTrace != null) {
            sb.append("printCallStack --> ");
            sb.append(th.getMessage());
            sb.append("\n");
            sb.append("----------start----------");
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append("        at ");
                sb.append(stackTrace[i].getClassName());
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                sb.append(stackTrace[i].getMethodName());
                sb.append(oIX0oI.I0Io.f4096II0xO0);
                sb.append(stackTrace[i].getFileName());
                sb.append(":");
                sb.append(stackTrace[i].getLineNumber());
                sb.append(oIX0oI.I0Io.f4095I0Io);
                sb.append("\n");
            }
            sb.append("----------end-----------");
        }
        out("printCallStack", sb.toString());
    }

    public static void printCallStack() {
        printCallStack("");
    }

    public static void printException(String str, Throwable th) {
        e("printException", "start exception");
        e(str, th.toString());
        printExceptionStack(th);
    }

    private static void printExceptionStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        if (stackTrace != null) {
            sb.append("printCallStack --> ");
            sb.append(th.getMessage());
            sb.append("\n");
            sb.append("----------start----------");
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append("        at ");
                sb.append(stackTrace[i].getClassName());
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                sb.append(stackTrace[i].getMethodName());
                sb.append(oIX0oI.I0Io.f4096II0xO0);
                sb.append(stackTrace[i].getFileName());
                sb.append(":");
                sb.append(stackTrace[i].getLineNumber());
                sb.append(oIX0oI.I0Io.f4095I0Io);
                sb.append("\n");
            }
            sb.append("----------end-----------");
        }
        e("printCallStack", sb.toString());
    }

    public static <T> void printList(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable Collection<T> collection) {
        if (LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            if (collection == null) {
                sb.append(str3);
                sb.append(" is null!!!");
                sb.append("\n");
                sb.append("----------------------------------------------------------------------------");
                sb.append(str2);
                sb.append("----------------------------------------------------------------------------");
                sb.append("\n");
                e(str, sb.toString());
                return;
            }
            if (collection.isEmpty()) {
                sb.append(str3);
                sb.append(" is empty!!!");
                sb.append("\n");
                sb.append("----------------------------------------------------------------------------");
                sb.append(str2);
                sb.append("----------------------------------------------------------------------------");
                sb.append("\n");
                e(str, sb.toString());
                return;
            }
            sb.append(str3);
            sb.append(" size is ");
            sb.append(collection.size());
            sb.append("\n");
            sb.append(str3);
            sb.append(" is ⬇⬇⬇⬇⬇⬇⬇⬇⬇\n");
            int i = 0;
            for (T t : collection) {
                sb.append("        --> ");
                sb.append(str3);
                sb.append(": 第");
                sb.append(i);
                sb.append("个: ");
                sb.append(t);
                sb.append("\n");
                i++;
            }
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append("end");
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
        }
    }

    public static void printViewList(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable ArrayList<View> arrayList) {
        Object tag;
        if (LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append(str2);
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            if (arrayList == null) {
                sb.append(str3);
                sb.append(" is null!!!");
                sb.append("\n");
                sb.append("----------------------------------------------------------------------------");
                sb.append(str2);
                sb.append("----------------------------------------------------------------------------");
                sb.append("\n");
                e(str, sb.toString());
                return;
            }
            if (arrayList.isEmpty()) {
                sb.append(str3);
                sb.append(" is empty!!!");
                sb.append("\n");
                sb.append("----------------------------------------------------------------------------");
                sb.append(str2);
                sb.append("----------------------------------------------------------------------------");
                sb.append("\n");
                e(str, sb.toString());
                return;
            }
            sb.append(str3);
            sb.append(" size is ");
            sb.append(arrayList.size());
            sb.append("\n");
            sb.append(str3);
            sb.append(" is ⬇⬇⬇⬇⬇⬇⬇⬇⬇\n");
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("        --> ");
                sb.append(str3);
                sb.append(": 第");
                sb.append(i);
                sb.append("个: ");
                sb.append(arrayList.get(i));
                sb.append(", tag: ");
                if (arrayList.get(i) == null) {
                    tag = "null";
                } else {
                    tag = arrayList.get(i).getTag();
                }
                sb.append(tag);
                sb.append("\n");
            }
            sb.append("\n");
            sb.append("----------------------------------------------------------------------------");
            sb.append("end");
            sb.append("----------------------------------------------------------------------------");
            sb.append("\n");
            e(str, sb.toString());
        }
    }

    public static void setLoggable(boolean z) {
        LOGGABLE = z;
    }

    public static void printCallStack(String str) {
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            th = new Throwable();
        } else {
            th = new Throwable(str);
        }
        printExceptionStack(th);
    }

    public static String getCallStack(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName() != null && stackTrace[i].getClassName().contains(str)) {
                    stringBuffer.append("at " + stackTrace[i].getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTrace[i].getMethodName() + oIX0oI.I0Io.f4096II0xO0 + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ")\n");
                }
            }
        }
        return stringBuffer.toString();
    }
}
