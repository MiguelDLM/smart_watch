package com.baidu.tts;

import java.util.concurrent.Executors;

/* loaded from: classes8.dex */
public class w extends s {
    public w(u uVar) {
        super(uVar);
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void destroy() {
        this.f10163a.k();
        u uVar = this.f10163a;
        uVar.e = uVar.g;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void start() {
        u uVar = this.f10163a;
        uVar.getClass();
        uVar.f = Executors.newSingleThreadExecutor(new a3("bdtts-EngineExecutorPoolThread"));
        u uVar2 = this.f10163a;
        uVar2.e = uVar2.i;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public void synthesize(y4 y4Var) {
        start();
        if (this.f10163a.e != this) {
            this.f10163a.e.synthesize(y4Var);
        }
    }
}
