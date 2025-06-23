package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p0;
import com.huawei.openalliance.ad.constant.aw;

/* loaded from: classes8.dex */
public class n0 extends k0 {
    public n0(p0 p0Var) {
        super(p0Var);
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a() {
        stop();
        if (this.f10117a.d != this) {
            this.f10117a.a();
        }
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void destroy() {
        this.f10117a.l();
        this.f10117a.k();
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.g;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void resume() {
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.i;
        t0 t0Var = (t0) this.f10117a.f;
        t0Var.getClass();
        LoggerProxy.d("AudioTrackPlayer", aw.ag);
        try {
            t0Var.g = false;
            if (t0Var.b != null) {
                t0Var.b.play();
            }
            t0Var.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.i3
    public void stop() {
        this.f10117a.l();
        p0 p0Var = this.f10117a;
        p0Var.d = p0Var.h;
    }

    @Override // com.baidu.tts.k0, com.baidu.tts.l0
    public void a(x4 x4Var) {
        p0 p0Var = this.f10117a;
        p0Var.e.execute(new p0.a(x4Var));
    }
}
