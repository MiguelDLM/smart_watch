package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.s1;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class u1 extends q1 {
    public u1(s1 s1Var) {
        super(s1Var);
    }

    @Override // com.baidu.tts.q1
    public v1 a(t1 t1Var) {
        Future<Void> future;
        s1 s1Var = this.f10151a;
        s1Var.getClass();
        s1.a aVar = new s1.a(t1Var);
        b2 b2Var = t1Var.f10169a;
        b2Var.getClass();
        LoggerProxy.d("FsFileInfoFlyweight", "queueForDownload fileId=" + b2Var.f + "--filestate=" + b2Var.d);
        b2Var.d = 4;
        LoggerProxy.d("DownloadEngine", "before submit");
        try {
            future = s1Var.h.submit(aVar);
        } catch (Exception e) {
            LoggerProxy.d("DownloadEngine", "submit exception");
            TtsError a2 = c3.a().a(x2.Q0);
            a2.setThrowable(e);
            t1Var.a(a2);
            future = null;
        }
        v1 v1Var = new v1();
        v1Var.f10180a = future;
        v1Var.b = aVar;
        return v1Var;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void destroy() {
        stop();
        if (this.f10151a.c != this) {
            s1 s1Var = this.f10151a;
            synchronized (s1Var) {
                s1Var.f();
            }
        }
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void pause() {
        s1 s1Var = this.f10151a;
        s1Var.c = s1Var.g;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void stop() {
        this.f10151a.k();
        s1 s1Var = this.f10151a;
        s1Var.c = s1Var.e;
    }
}
