package com.baidu.tts;

import com.baidu.tts.d1;

/* loaded from: classes8.dex */
public class m0 extends k0 {
    public m0(p0 p0Var) {
        super(p0Var);
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a(x4 x4Var) {
        a();
        if (this.f10117a.d != this) {
            this.f10117a.a(x4Var);
        }
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void destroy() {
        this.f10117a.k();
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.g;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void start() {
        p0 p0Var = this.f10117a;
        p0Var.getClass();
        p0Var.e = new d1(200, "bdtts-PlayExecutorPoolThread", new d1.a());
        p0 p0Var2 = this.f10117a;
        p0Var2.d = p0Var2.i;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a() {
        p0 p0Var = this.f10117a;
        p0Var.getClass();
        p0Var.e = new d1(200, "bdtts-PlayExecutorPoolThread", new d1.a());
        t0 t0Var = (t0) this.f10117a.f;
        t0Var.getClass();
        try {
            if (t0Var.b != null) {
                t0Var.b.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        p0 p0Var2 = this.f10117a;
        p0Var2.d = p0Var2.i;
    }
}
