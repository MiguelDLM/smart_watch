package com.huawei.openalliance.ad.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes10.dex */
public class s {
    private Handler Code;

    public s(Handler handler) {
        this.Code = handler;
    }

    public void Code(Runnable runnable) {
        Code(runnable, null, 0L);
    }

    public void Code(Runnable runnable, long j) {
        Code(runnable, null, j);
    }

    public void Code(Runnable runnable, String str) {
        Code(runnable, str, 0L);
    }

    public void Code(Runnable runnable, String str, long j) {
        if (this.Code == null || runnable == null) {
            return;
        }
        if (j < 0) {
            j = 0;
        }
        bd bdVar = new bd(runnable);
        if (j == 0 && Code()) {
            bdVar.run();
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() + j;
        if (Build.VERSION.SDK_INT >= 22) {
            try {
                Message obtain = Message.obtain(this.Code, bdVar);
                obtain.setAsynchronous(true);
                obtain.obj = str;
                this.Code.sendMessageAtTime(obtain, uptimeMillis);
                return;
            } catch (Throwable unused) {
            }
        }
        this.Code.postAtTime(bdVar, str, uptimeMillis);
    }

    public void Code(String str) {
        Handler handler = this.Code;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }

    private boolean Code() {
        Looper looper;
        Handler handler = this.Code;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        return Thread.currentThread() == looper.getThread();
    }
}
