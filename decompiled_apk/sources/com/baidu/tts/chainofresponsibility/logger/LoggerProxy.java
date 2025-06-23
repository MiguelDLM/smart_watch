package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.w0;
import com.baidu.tts.y0;
import com.baidu.tts.z0;
import java.util.List;

/* loaded from: classes8.dex */
public class LoggerProxy {

    /* renamed from: a, reason: collision with root package name */
    public static y0 f10050a;
    public static ILoggerUploadCallBack loggerUploadCallBack;

    static {
        if (y0.g == null) {
            synchronized (y0.class) {
                try {
                    if (y0.g == null) {
                        y0.g = new y0();
                    }
                } finally {
                }
            }
        }
        f10050a = y0.g;
    }

    public static void a(String str, String str2) {
        log(7, str, str2);
    }

    public static void addPrintString(String str) {
        List<String> list;
        z0 z0Var = f10050a.d;
        if (z0Var != null && (list = z0Var.f10207a) != null && !list.contains(str)) {
            z0Var.f10207a.add(str);
        }
    }

    public static void addPrintStrings(List<String> list) {
        List<String> list2;
        z0 z0Var = f10050a.d;
        if (z0Var != null && (list2 = z0Var.f10207a) != null) {
            list2.addAll(list);
        }
    }

    public static void addUnPrintString(String str) {
        List<String> list;
        z0 z0Var = f10050a.d;
        if (z0Var != null && (list = z0Var.b) != null && !list.contains(str)) {
            z0Var.b.add(str);
        }
    }

    public static void clearHandler() {
        List<w0> list = f10050a.f10199a;
        if (list != null) {
            list.clear();
        }
    }

    public static void clearSpecifyStrings() {
        z0 z0Var = f10050a.d;
        if (z0Var != null) {
            List<String> list = z0Var.f10207a;
            if (list != null) {
                list.clear();
            }
            List<String> list2 = z0Var.b;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public static void d(String str, String str2) {
        log(3, str, str2);
        ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
        if (iLoggerUploadCallBack != null) {
            iLoggerUploadCallBack.loggerUpload(3, str, str2);
        }
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
        ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
        if (iLoggerUploadCallBack != null) {
            iLoggerUploadCallBack.loggerUpload(6, str, str2);
        }
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
        ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
        if (iLoggerUploadCallBack != null) {
            iLoggerUploadCallBack.loggerUpload(4, str, str2);
        }
    }

    public static boolean isModeRelease() {
        y0.a aVar = f10050a.e;
        if (aVar != null && aVar != y0.a.RELEASE) {
            return false;
        }
        return true;
    }

    public static void log(int i, String str, String str2) {
        try {
            f10050a.a(i, str, str2);
        } catch (Exception e) {
            Log.e("LoggerProxy", "log exception=" + e.toString());
        }
    }

    public static boolean needPrint(int i) {
        if (!f10050a.f && !Log.isLoggable("TTSLOG", i)) {
            return false;
        }
        return true;
    }

    public static void printable(boolean z) {
        f10050a.f = z;
        EmbeddedSynthesizerEngine.bdTTSSetNativeLogLevel(6);
    }

    public static void saveNativeLogFile(String str) {
        if (!str.isEmpty()) {
            EmbeddedSynthesizerEngine.bdTTSSetLogFilePath(str);
        }
    }

    public static void setBaseTag(String str) {
        z0 z0Var = f10050a.d;
        if (z0Var != null) {
            z0Var.c = str;
        }
    }

    public static void setLoggerListener(ILoggerUploadCallBack iLoggerUploadCallBack) {
        loggerUploadCallBack = iLoggerUploadCallBack;
    }

    public static void setModeDevelop() {
        f10050a.e = y0.a.DEVELOP;
    }

    public static void setModeRelease() {
        f10050a.e = y0.a.RELEASE;
    }

    public static void setNativeLogLevel(int i) {
        if (i < 7 && i > 0) {
            EmbeddedSynthesizerEngine.bdTTSSetNativeLogLevel(i);
        }
    }

    public static void v(String str, String str2) {
        log(2, str, str2);
        ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
        if (iLoggerUploadCallBack != null) {
            iLoggerUploadCallBack.loggerUpload(2, str, str2);
        }
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
        ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
        if (iLoggerUploadCallBack != null) {
            iLoggerUploadCallBack.loggerUpload(5, str, str2);
        }
    }
}
