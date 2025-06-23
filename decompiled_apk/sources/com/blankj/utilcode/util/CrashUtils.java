package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.UtilsBridge;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: classes8.dex */
public final class CrashUtils {
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final Thread.UncaughtExceptionHandler DEFAULT_UNCAUGHT_EXCEPTION_HANDLER = Thread.getDefaultUncaughtExceptionHandler();

    /* loaded from: classes8.dex */
    public static final class CrashInfo {
        private UtilsBridge.FileHead mFileHeadProvider;
        private Throwable mThrowable;

        public final void addExtraHead(Map<String, String> map) {
            this.mFileHeadProvider.append(map);
        }

        public final Throwable getThrowable() {
            return this.mThrowable;
        }

        public String toString() {
            return this.mFileHeadProvider.toString() + UtilsBridge.getFullStackTrace(this.mThrowable);
        }

        private CrashInfo(String str, Throwable th) {
            this.mThrowable = th;
            UtilsBridge.FileHead fileHead = new UtilsBridge.FileHead("Crash");
            this.mFileHeadProvider = fileHead;
            fileHead.addFirst("Time Of Crash", str);
        }

        public final void addExtraHead(String str, String str2) {
            this.mFileHeadProvider.append(str, str2);
        }
    }

    /* loaded from: classes8.dex */
    public interface OnCrashListener {
        void onCrash(CrashInfo crashInfo);
    }

    private CrashUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Thread.UncaughtExceptionHandler getUncaughtExceptionHandler(final String str, final OnCrashListener onCrashListener) {
        return new Thread.UncaughtExceptionHandler() { // from class: com.blankj.utilcode.util.CrashUtils.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
                if (thread != null) {
                    if (th != null) {
                        String format = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
                        CrashInfo crashInfo = new CrashInfo(format, th);
                        OnCrashListener onCrashListener2 = OnCrashListener.this;
                        if (onCrashListener2 != null) {
                            onCrashListener2.onCrash(crashInfo);
                        }
                        UtilsBridge.writeFileFromString(str + format + ".txt", crashInfo.toString(), true);
                        if (CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER != null) {
                            CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER.uncaughtException(thread, th);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("Argument 'e' of type Throwable (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
                throw new NullPointerException("Argument 't' of type Thread (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        };
    }

    @SuppressLint({"MissingPermission"})
    public static void init() {
        init("");
    }

    public static void init(@NonNull File file) {
        if (file != null) {
            init(file.getAbsolutePath(), (OnCrashListener) null);
            return;
        }
        throw new NullPointerException("Argument 'crashDir' of type File (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void init(String str) {
        init(str, (OnCrashListener) null);
    }

    public static void init(OnCrashListener onCrashListener) {
        init("", onCrashListener);
    }

    public static void init(@NonNull File file, OnCrashListener onCrashListener) {
        if (file != null) {
            init(file.getAbsolutePath(), onCrashListener);
            return;
        }
        throw new NullPointerException("Argument 'crashDir' of type File (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static void init(String str, OnCrashListener onCrashListener) {
        if (UtilsBridge.isSpace(str)) {
            if (UtilsBridge.isSDCardEnableByEnvironment() && Utils.getApp().getExternalFilesDir(null) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(Utils.getApp().getExternalFilesDir(null));
                String str2 = FILE_SEP;
                sb.append(str2);
                sb.append(com.sma.smartv3.initializer.IXxxXO.f20863oI0IIXIo);
                sb.append(str2);
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Utils.getApp().getFilesDir());
                String str3 = FILE_SEP;
                sb2.append(str3);
                sb2.append(com.sma.smartv3.initializer.IXxxXO.f20863oI0IIXIo);
                sb2.append(str3);
                str = sb2.toString();
            }
        } else {
            String str4 = FILE_SEP;
            if (!str.endsWith(str4)) {
                str = str + str4;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(getUncaughtExceptionHandler(str, onCrashListener));
    }
}
