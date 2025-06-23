package com.baidu.tts;

import com.baidu.tts.u;

/* loaded from: classes8.dex */
public class y extends s {
    public y(u uVar) {
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
    public void pause() {
        this.f10163a.getClass();
        u uVar = this.f10163a;
        uVar.e = uVar.j;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public void stop() {
        this.f10163a.l();
        u uVar = this.f10163a;
        uVar.e = uVar.h;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public void synthesize(y4 y4Var) {
        u uVar = this.f10163a;
        uVar.f.submit(new u.a(y4Var));
    }
}
