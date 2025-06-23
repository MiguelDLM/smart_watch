package com.baidu.tts;

/* loaded from: classes8.dex */
public class y1 extends q1 {
    public y1(s1 s1Var) {
        super(s1Var);
    }

    @Override // com.baidu.tts.q1
    public v1 a(t1 t1Var) {
        resume();
        if (this.f10151a.c != this) {
            return this.f10151a.a(t1Var);
        }
        return null;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void destroy() {
        stop();
        if (this.f10151a.c != this) {
            this.f10151a.destroy();
        }
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void resume() {
        s1 s1Var = this.f10151a;
        s1Var.c = s1Var.f;
    }

    @Override // com.baidu.tts.q1, com.baidu.tts.i3
    public void stop() {
        this.f10151a.k();
        s1 s1Var = this.f10151a;
        s1Var.c = s1Var.e;
    }
}
