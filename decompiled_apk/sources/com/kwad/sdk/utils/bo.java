package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* loaded from: classes11.dex */
public final class bo {
    private static final Handler aSe = new Handler(Looper.getMainLooper());
    private static long le = 400;

    public static void a(Runnable runnable, Object obj, long j) {
        Handler handler = aSe;
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = null;
        handler.sendMessageDelayed(obtain, j);
    }

    public static void b(Runnable runnable) {
        aSe.postAtFrontOfQueue(runnable);
    }

    public static void c(Runnable runnable) {
        aSe.removeCallbacks(runnable);
    }

    public static boolean hk(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains(" ") && URLUtil.isNetworkUrl(str)) {
            return false;
        }
        return true;
    }

    public static void postOnUiThread(Runnable runnable) {
        aSe.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aSe.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        aSe.postDelayed(runnable, j);
    }

    public static String t(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (TextUtils.isEmpty(stackTraceString)) {
                return th.toString();
            }
            return stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j) {
        VibrationEffect createOneShot;
        if (vibrator != null) {
            try {
                if (an.aq(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        createOneShot = VibrationEffect.createOneShot(j, -1);
                        vibrator.vibrate(createOneShot);
                    } else {
                        vibrator.vibrate(j);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || an.aq(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, le);
    }
}
