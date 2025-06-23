package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.facebook.login.widget.ToolTipPopup;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class o1 implements i3 {
    public static volatile o1 e;

    /* renamed from: a, reason: collision with root package name */
    public m3 f10143a;
    public a2 b = a2.a();
    public s1 c = new s1();
    public ExecutorService d;

    /* loaded from: classes8.dex */
    public class a implements Callable<m1> {

        /* renamed from: a, reason: collision with root package name */
        public DownloadHandler f10144a;

        public a(DownloadHandler downloadHandler) {
            this.f10144a = downloadHandler;
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x0232 A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:3:0x0021, B:5:0x0027, B:6:0x002e, B:8:0x0037, B:10:0x0062, B:13:0x0069, B:14:0x006d, B:17:0x0099, B:19:0x00b0, B:20:0x00b5, B:22:0x00bb, B:24:0x00e7, B:25:0x00eb, B:27:0x00f1, B:30:0x0107, B:32:0x011f, B:34:0x0126, B:39:0x0133, B:44:0x0161, B:46:0x016e, B:49:0x019c, B:50:0x01a0, B:52:0x01a6, B:55:0x01b2, B:57:0x01c0, B:58:0x01c3, B:60:0x01e7, B:63:0x021e, B:65:0x0232, B:72:0x01ef, B:74:0x01f4, B:77:0x01fa, B:79:0x0214, B:80:0x025a, B:83:0x0268, B:85:0x026c, B:87:0x0272), top: B:2:0x0021 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x022f A[SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.baidu.tts.m1 call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 746
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.o1.a.call():java.lang.Object");
        }
    }

    public static o1 b() {
        if (e == null) {
            synchronized (o1.class) {
                try {
                    if (e == null) {
                        e = new o1();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    @Override // com.baidu.tts.i3
    public synchronized TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.i3
    public synchronized void destroy() {
    }

    @Override // com.baidu.tts.i3
    public synchronized void pause() {
        s1 s1Var = this.c;
        synchronized (s1Var) {
            s1Var.g();
        }
    }

    @Override // com.baidu.tts.i3
    public synchronized void resume() {
        this.c.resume();
    }

    @Override // com.baidu.tts.i3
    public synchronized void start() {
        synchronized (this) {
            if (this.d == null) {
                this.d = Executors.newSingleThreadExecutor();
            }
        }
        s1 s1Var = this.c;
        synchronized (s1Var) {
            s1Var.c.start();
        }
    }

    @Override // com.baidu.tts.i3
    public synchronized void stop() {
        try {
            LoggerProxy.d("Downloader", "enter stop");
            for (d2 d2Var : this.b.f10031a.f10079a.values()) {
                d2Var.g.clear();
                d2Var.c();
            }
            ExecutorService executorService = this.d;
            if (executorService != null) {
                if (!executorService.isShutdown()) {
                    this.d.shutdownNow();
                    s1 s1Var = this.c;
                    synchronized (s1Var) {
                        s1Var.j();
                    }
                    LoggerProxy.d("Downloader", "after engine stop");
                }
                try {
                    LoggerProxy.d("Downloader", "before awaitTermination");
                    LoggerProxy.d("Downloader", "after awaitTermination isTermination=" + this.d.awaitTermination(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS));
                } catch (InterruptedException unused) {
                }
                this.d = null;
            }
            LoggerProxy.d("Downloader", "end stop");
        } catch (Throwable th) {
            throw th;
        }
    }
}
