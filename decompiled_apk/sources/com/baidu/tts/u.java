package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.TtsStatsUpload;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class u extends q {
    public ExecutorService f;
    public z g;
    public w h;
    public y i;
    public x j;

    /* loaded from: classes8.dex */
    public class a implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public y4 f10174a;

        public a(y4 y4Var) {
            this.f10174a = y4Var;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            try {
                u uVar = u.this;
                y4 y4Var = this.f10174a;
                String str = y4Var.i;
                x4 x4Var = new x4();
                x4Var.i = y4Var;
                x4Var.d = str;
                if (uVar.b()) {
                    x4Var.f10198a = o2.SYN_START;
                    List<p> list = uVar.d;
                    if (list != null) {
                        for (p pVar : list) {
                            if (pVar != null) {
                                pVar.onSynthesizeStart(x4Var);
                            }
                        }
                    }
                }
                TtsError a2 = u.this.c.a(this.f10174a);
                if (a2 == null) {
                    LoggerProxy.d("EngineExecutor", "synthesize has finished successfully.");
                    return null;
                }
                u uVar2 = u.this;
                y4 y4Var2 = this.f10174a;
                String str2 = y4Var2.i;
                x4 x4Var2 = new x4();
                x4Var2.i = y4Var2;
                x4Var2.d = str2;
                x4Var2.j = a2;
                uVar2.b(x4Var2);
                return null;
            } catch (InterruptedException unused) {
                LoggerProxy.d("EngineExecutor", "synthesize interrupted!");
                return null;
            }
        }
    }

    public u() {
        z zVar = new z(this);
        this.g = zVar;
        this.h = new w(this);
        this.i = new y(this);
        this.j = new x(this);
        this.e = zVar;
    }

    public final void a(boolean z) {
        if (z) {
            d(null);
            return;
        }
        x4 x4Var = new x4();
        x4Var.j = c3.a().a(x2.B0);
        d(x4Var);
    }

    @Override // com.baidu.tts.h3
    public boolean c() {
        if (this.e == this.j) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tts.h3
    public boolean d() {
        if (!Thread.currentThread().isInterrupted() && this.e != this.h) {
            return false;
        }
        return true;
    }

    public void k() {
        if (p4.c != null) {
            synchronized (p4.class) {
                try {
                    if (p4.c != null) {
                        p4.c.b();
                        p4.c = null;
                    }
                } finally {
                }
            }
        }
        this.c.b();
        l1 a2 = l1.a();
        if (a2.m && !a2.j) {
            a2.j = true;
            a2.d.clear();
            a2.l.interrupt();
            try {
                LoggerProxy.i("StreamDecoder", "wait thread exit+++.");
                a2.k.acquire();
                LoggerProxy.i("StreamDecoder", "wait thread exit---");
            } catch (Exception e) {
                e.printStackTrace();
            }
            l1.n = null;
        }
        this.d = null;
    }

    public void l() {
        ExecutorService executorService = this.f;
        if (executorService != null) {
            if (!executorService.isShutdown()) {
                this.f.shutdownNow();
                TtsStatsUpload.getInstance().setOnlineDoneFlag(true);
            }
            try {
                LoggerProxy.d("EngineExecutor", "before awaitTermination");
                boolean awaitTermination = this.f.awaitTermination(10000L, TimeUnit.MILLISECONDS);
                LoggerProxy.d("EngineExecutor", "after awaitTermination isTermination=" + awaitTermination);
                l1 a2 = l1.a();
                a2.d.clear();
                synchronized (a2.g) {
                    a2.e = 0;
                    a2.f = true;
                }
                a2.l.interrupt();
                a(awaitTermination);
            } catch (InterruptedException unused) {
                a(false);
            }
            this.f = null;
        }
    }
}
