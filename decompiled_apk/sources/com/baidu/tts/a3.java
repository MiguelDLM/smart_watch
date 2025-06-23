package com.baidu.tts;

import XXO0.oIX0oI;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes8.dex */
public class a3 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public String f10032a;
    public int b;

    public a3(String str) {
        this.f10032a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        this.b++;
        String str = this.f10032a + oIX0oI.I0Io.f4096II0xO0 + this.b + oIX0oI.I0Io.f4095I0Io;
        thread.setName(str);
        LoggerProxy.d("NameThreadFactory", "threadName=" + str);
        return thread;
    }
}
