package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.f0;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import javax.net.ssl.SSLException;

/* loaded from: classes8.dex */
public class y3 {
    public static final String l = "y3";
    public static volatile int m;

    /* renamed from: a, reason: collision with root package name */
    public z3 f10203a;
    public x3 d;
    public int e;
    public volatile TimerTask h;
    public String j;
    public j4 b = null;
    public Timer c = new Timer();
    public volatile boolean f = false;
    public int g = 0;
    public volatile long i = 0;
    public volatile boolean k = false;

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - y3.this.i;
            LoggerProxy.i(y3.l, "Channel[" + y3.this.e + "], connect timeout, cost " + currentTimeMillis + "ms");
            y3.this.a(new SocketTimeoutException("MonitorResponseTimeout"), 0);
            cancel();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LoggerProxy.i(y3.l, "Channel[" + y3.this.e + "], read timeout.");
            y3.this.a(new SocketTimeoutException("ReadTimeout"), 0);
            cancel();
        }
    }

    public y3(z3 z3Var, String str) {
        this.d = null;
        this.e = 0;
        this.h = null;
        this.f10203a = z3Var;
        this.e = a();
        this.h = new a();
        this.d = new x3(this.f10203a);
        this.j = str;
    }

    public final int a() {
        int i;
        synchronized (y3.class) {
            int i2 = m;
            m++;
            m %= 15;
            i = i2 + 1;
        }
        return i;
    }

    public TtsError a(boolean z) {
        TtsError a2;
        String str = l;
        LoggerProxy.d(str, "Channel[" + this.e + "], will close");
        if (this.f && z) {
            this.b.a(this.d.a(14, this.e, new byte[0]));
        }
        this.k = true;
        j4 j4Var = this.b;
        j4Var.getClass();
        p4 a3 = p4.a();
        WeakReference<j4> weakReference = j4Var.b;
        a3.getClass();
        LoggerProxy.d("WsConnectionService", "detachConnection ");
        j4 b2 = a3.b(a3.f10150a);
        synchronized (a3) {
            try {
                if (b2 == weakReference.get()) {
                    a3.f10150a.b();
                    a3.b.remove(a3.f10150a);
                    StringBuilder sb = new StringBuilder();
                    sb.append("bridge ");
                    b2.getClass();
                    sb.append("idx " + b2.d + ", sn " + b2.f);
                    sb.append("detached.");
                    LoggerProxy.d("WsConnectionService", sb.toString());
                    a2 = null;
                } else {
                    a2 = c3.a().a(x2.L);
                }
            } finally {
            }
        }
        this.h.cancel();
        this.c.cancel();
        LoggerProxy.d(str, "Channel[" + this.e + "], closed");
        return a2;
    }

    public void a(Throwable th, int i) {
        y3 y3Var;
        LoggerProxy.d(l, "Channel[" + this.e + "], onError = " + th + "code= " + i + " mConnected = " + this.f);
        j4 j4Var = this.b;
        j4Var.getClass();
        String str = j4.h;
        StringBuilder sb = new StringBuilder();
        sb.append("bridge[");
        sb.append(j4Var.d);
        sb.append("] need no more data.");
        LoggerProxy.d(str, sb.toString());
        j4Var.g = false;
        f0.b bVar = (f0.b) this.f10203a;
        bVar.getClass();
        String str2 = f0.d;
        LoggerProxy.i(str2, "onError " + th.toString());
        y4 y4Var = bVar.f10085a;
        j4 j4Var2 = bVar.c.b;
        y4Var.a("url", j4Var2 != null ? j4Var2.e : null);
        if (bVar.l != 0) {
            bVar.f10085a.a(TtsStatsUploadBag.KEY_HTTP_STATUS_CODE, Integer.valueOf(i));
            bVar.l = i;
        }
        if (th instanceof ExecutionException) {
            th.printStackTrace();
            bVar.a(x2.q, th.getCause());
        } else {
            if (th instanceof SocketTimeoutException) {
                LoggerProxy.d(str2, "receive exception");
                bVar.a(x2.r, th);
                if (th.toString().indexOf("MonitorResponseTimeout") != -1) {
                    LoggerProxy.d(str2, "The timer is forced to shutdown");
                    y3 y3Var2 = bVar.c;
                    if (y3Var2 != null) {
                        y3Var2.a(true);
                        ((f0.b) y3Var2.f10203a).b();
                    }
                }
            } else if (th instanceof UnknownHostException) {
                bVar.a(x2.u, th);
            } else if (th instanceof SSLException) {
                bVar.a(x2.v, th);
            } else if (th instanceof ConnectException) {
                bVar.a(x2.w, th);
            } else if (th instanceof SocketException) {
                LoggerProxy.d(str2, "SocketException");
                th.printStackTrace();
                if (!bVar.i) {
                    if (bVar.j && (y3Var = bVar.c) != null) {
                        y3Var.a(false);
                        bVar.j = false;
                    } else {
                        bVar.a(x2.x, th);
                        int indexOf = th.toString().indexOf("Socket closed");
                        int indexOf2 = th.toString().indexOf("Socket is closed");
                        if (indexOf != -1 || indexOf2 != -1) {
                            bVar.c();
                        }
                    }
                }
            } else {
                bVar.a(x2.I, th);
            }
            this.h.cancel();
            this.c.cancel();
        }
        bVar.c();
        this.h.cancel();
        this.c.cancel();
    }

    public final void a(int i) {
        this.h.cancel();
        if (this.k) {
            return;
        }
        this.h = new b();
        if (this.h != null) {
            try {
                LoggerProxy.d(l, "Channel[" + this.e + "], new timer after " + i);
                this.c.schedule(this.h, (long) i);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
