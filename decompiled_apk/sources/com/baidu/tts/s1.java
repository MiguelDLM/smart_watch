package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.StringTool;
import com.facebook.login.widget.ToolTipPopup;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class s1 extends h3 {
    public volatile q1 c;
    public z1 d;
    public w1 e;
    public u1 f;
    public y1 g;
    public ThreadPoolExecutor h;
    public m3 i;

    /* loaded from: classes8.dex */
    public class a implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public t1 f10165a;

        public a(t1 t1Var) {
            this.f10165a = t1Var;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            String str;
            String str2;
            b2 b2Var = this.f10165a.f10169a;
            b2Var.d = 5;
            b2Var.e = 6;
            a2.a().b.a(b2Var.f10041a, b2Var.e);
            b2 b2Var2 = this.f10165a.f10169a;
            if (b2Var2 != null) {
                str = b2Var2.f;
            } else {
                str = null;
            }
            LoggerProxy.d("DownloadEngine", "DownloadWork start fileId=" + str);
            if (StringTool.isEmpty(str)) {
                TtsError a2 = c3.a().a(x2.f10190I0);
                a2.setCode(0);
                a2.setMessage("fileId is null");
                a2.setThrowable(null);
                this.f10165a.a(a2);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                ModelFileBags modelFileBags = s1.this.i.a(hashSet).get();
                if (modelFileBags != null) {
                    String url = modelFileBags.getUrl(0);
                    if (url != null) {
                        a4 a4Var = new a4();
                        a4Var.f10033a = false;
                        int i = (int) ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
                        if (i < 1000) {
                            i = 5000;
                        }
                        a4Var.b = i;
                        b2 b2Var3 = this.f10165a.f10169a;
                        if (b2Var3 != null) {
                            str2 = b2Var3.f10041a;
                        } else {
                            str2 = null;
                        }
                        r1 r1Var = new r1(this, FileTools.getFile(str2), this.f10165a, str);
                        LoggerProxy.d("DownloadEngine", "before get fileId=" + str);
                        a4Var.a(url, "", "GET", r1Var);
                    } else {
                        TtsError a3 = c3.a().a(x2.f10190I0);
                        a3.setCode(0);
                        a3.setMessage("url is null");
                        a3.setThrowable(null);
                        this.f10165a.a(a3);
                    }
                } else {
                    TtsError a4 = c3.a().a(x2.f10190I0);
                    a4.setCode(0);
                    a4.setMessage("urlbags is null");
                    a4.setThrowable(null);
                    this.f10165a.a(a4);
                }
            }
            LoggerProxy.d("DownloadEngine", "DownloadWork end");
            return null;
        }
    }

    public s1() {
        z1 z1Var = new z1(this);
        this.d = z1Var;
        this.e = new w1(this);
        this.f = new u1(this);
        this.g = new y1(this);
        this.c = z1Var;
        create();
    }

    public v1 a(t1 t1Var) {
        return this.c.a(t1Var);
    }

    @Override // com.baidu.tts.h3
    public boolean c() {
        if (this.c == this.g) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tts.h3
    public boolean d() {
        if (!Thread.currentThread().isInterrupted() && this.c != this.e) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tts.h3
    public TtsError e() {
        return this.c.create();
    }

    @Override // com.baidu.tts.h3
    public void f() {
        this.c.destroy();
    }

    @Override // com.baidu.tts.h3
    public void g() {
        this.c.pause();
    }

    @Override // com.baidu.tts.h3
    public void h() {
        this.c.resume();
    }

    @Override // com.baidu.tts.h3
    public void i() {
        this.c.start();
    }

    @Override // com.baidu.tts.h3
    public void j() {
        this.c.stop();
    }

    public void k() {
        LoggerProxy.d("DownloadEngine", "enter stop");
        ThreadPoolExecutor threadPoolExecutor = this.h;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.h.shutdownNow();
            }
            try {
                LoggerProxy.d("DownloadEngine", "before awaitTermination");
                LoggerProxy.d("DownloadEngine", "after awaitTermination isTermination=" + this.h.awaitTermination(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
            }
            this.h = null;
        }
        LoggerProxy.d("DownloadEngine", "end stop");
    }
}
