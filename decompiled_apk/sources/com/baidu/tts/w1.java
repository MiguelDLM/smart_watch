package com.baidu.tts;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes8.dex */
public class w1 extends q1 {
    public w1(s1 s1Var) {
        super(s1Var);
    }

    @Override // com.baidu.tts.q1
    public v1 a(t1 t1Var) {
        start();
        if (this.f10151a.c != this) {
            return this.f10151a.a(t1Var);
        }
        return null;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void destroy() {
        s1 s1Var = this.f10151a;
        s1Var.c = s1Var.d;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void start() {
        s1 s1Var = this.f10151a;
        s1Var.getClass();
        s1Var.h = (ThreadPoolExecutor) Executors.newFixedThreadPool(3, new a3("bdtts-downloadPoolThread"));
        s1 s1Var2 = this.f10151a;
        s1Var2.c = s1Var2.f;
    }
}
