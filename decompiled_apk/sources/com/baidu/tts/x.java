package com.baidu.tts;

/* loaded from: classes8.dex */
public class x extends s {
    public x(u uVar) {
        super(uVar);
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void destroy() {
        this.f10163a.l();
        this.f10163a.k();
        u uVar = this.f10163a;
        uVar.e = uVar.g;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void resume() {
        this.f10163a.getClass();
        u uVar = this.f10163a;
        uVar.e = uVar.i;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void stop() {
        this.f10163a.l();
        u uVar = this.f10163a;
        uVar.e = uVar.h;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public void synthesize(y4 y4Var) {
        stop();
        if (this.f10163a.e != this) {
            this.f10163a.e.synthesize(y4Var);
        }
    }
}
