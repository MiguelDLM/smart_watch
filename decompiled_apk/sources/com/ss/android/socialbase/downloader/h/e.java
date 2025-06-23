package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: classes13.dex */
public final class e implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private volatile Handler f26307a = new Handler(a.f26308a, this);

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Looper f26308a;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f26308a = handlerThread.getLooper();
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        long a();
    }

    public static Looper a() {
        return a.f26308a;
    }

    public void b() {
        Handler handler = this.f26307a;
        if (handler == null) {
            return;
        }
        this.f26307a = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 0) {
            try {
                b bVar = (b) message.obj;
                long a2 = bVar.a();
                if (a2 > 0) {
                    a(bVar, a2);
                    return true;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return true;
    }

    public void a(b bVar, long j) {
        Handler handler = this.f26307a;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bVar;
        handler.sendMessageDelayed(obtain, j);
    }
}
