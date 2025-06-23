package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.t0;

/* loaded from: classes8.dex */
public abstract class j0 extends h3 implements l0 {
    public h0 c;
    public volatile k0 d;

    @Override // com.baidu.tts.l0
    public void a(h0 h0Var) {
        this.d.f10117a.c = h0Var;
    }

    @Override // com.baidu.tts.h3
    public TtsError e() {
        return this.d.create();
    }

    @Override // com.baidu.tts.h3
    public void f() {
        this.d.destroy();
    }

    @Override // com.baidu.tts.h3
    public void g() {
        this.d.pause();
    }

    @Override // com.baidu.tts.h3
    public void h() {
        this.d.resume();
    }

    @Override // com.baidu.tts.h3
    public void i() {
        this.d.start();
    }

    @Override // com.baidu.tts.h3
    public void j() {
        this.d.stop();
    }

    @Override // com.baidu.tts.l0
    public int setAudioAttributes(int i, int i2) {
        return this.d.setAudioAttributes(i, i2);
    }

    @Override // com.baidu.tts.l0
    public int setAudioSampleRate(int i) {
        return this.d.f10117a.f.a(i);
    }

    @Override // com.baidu.tts.l0
    public int setAudioStreamType(int i) {
        return this.d.setAudioStreamType(i);
    }

    @Override // com.baidu.tts.l0
    public int setStereoVolume(float f, float f2) {
        t0 t0Var = (t0) this.d.f10117a.f;
        int stereoVolume = t0Var.b.setStereoVolume(f, f2);
        t0.a aVar = t0Var.c;
        aVar.g = f;
        aVar.h = f2;
        return stereoVolume;
    }

    @Override // com.baidu.tts.l0
    public void a() {
        this.d.a();
    }

    @Override // com.baidu.tts.l0
    public void a(x4 x4Var) {
        this.d.a(x4Var);
    }
}
