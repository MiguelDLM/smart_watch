package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class t1 {

    /* renamed from: a, reason: collision with root package name */
    public b2 f10169a;

    public void a(TtsError ttsError) {
        b2 b2Var = this.f10169a;
        b2Var.getClass();
        LoggerProxy.d("FsFileInfoFlyweight", "onDownloadFailure");
        b2Var.d = 8;
        b2Var.e = 8;
        a2 a2 = a2.a();
        a2.b.a(b2Var.f10041a, b2Var.e);
        CopyOnWriteArraySet<String> copyOnWriteArraySet = b2Var.h;
        if (copyOnWriteArraySet != null) {
            Iterator<String> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                d2 c = a2.c(next);
                c.getClass();
                LoggerProxy.d("ModelFlyweight", "onFileDownloadFailure");
                CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet2 = c.g;
                if (copyOnWriteArraySet2 != null) {
                    Iterator<DownloadHandler> it2 = copyOnWriteArraySet2.iterator();
                    while (it2.hasNext()) {
                        DownloadHandler next2 = it2.next();
                        next2.updateFinish(c, ttsError);
                        c.a(next2);
                    }
                }
                b2Var.h.remove(next);
            }
        }
    }
}
