package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p0;

/* loaded from: classes8.dex */
public class q0 extends k0 {
    public q0(p0 p0Var) {
        super(p0Var);
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a(x4 x4Var) {
        p0 p0Var = this.f10117a;
        p0Var.e.execute(new p0.a(x4Var));
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void destroy() {
        this.f10117a.l();
        this.f10117a.k();
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.g;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void pause() {
        t0 t0Var = (t0) this.f10117a.f;
        t0Var.getClass();
        LoggerProxy.d("AudioTrackPlayer", "pause");
        try {
            t0Var.j = 0L;
            t0Var.g = true;
            if (t0Var.b != null) {
                t0Var.b.pause();
            }
            u0 u0Var = t0Var.i;
            if (u0Var != null) {
                u0Var.a();
                t0Var.i = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.j;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void stop() {
        this.f10117a.l();
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.h;
    }
}
