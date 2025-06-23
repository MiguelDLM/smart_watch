package com.baidu.tts;

import com.baidu.tts.aop.ttslistener.TtsListener;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public b f10090a;

    public void a(TtsListener ttsListener) {
        f fVar = (f) this.f10090a;
        fVar.c = ttsListener;
        v vVar = fVar.f10083a;
        if (fVar.d == null) {
            fVar.d = new c(fVar);
        }
        vVar.a(fVar.d);
        l0 l0Var = fVar.b;
        if (fVar.e == null) {
            fVar.e = new d(fVar);
        }
        l0Var.a(fVar.e);
    }
}
