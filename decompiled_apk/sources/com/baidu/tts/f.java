package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* loaded from: classes8.dex */
public class f implements b {

    /* renamed from: a, reason: collision with root package name */
    public v f10083a;
    public l0 b;
    public TtsListener c;
    public p d;
    public h0 e;
    public p f;

    public f(v vVar, l0 l0Var) {
        this.f10083a = vVar;
        this.b = l0Var;
    }

    public static boolean a(f fVar, x4 x4Var) {
        fVar.getClass();
        y4 y4Var = x4Var.i;
        if (y4Var == null) {
            return false;
        }
        return s2.SPEAK.equals(y4Var.d);
    }

    @Override // com.baidu.tts.i3
    public TtsError create() {
        TtsError create = this.f10083a.create();
        this.b.create();
        e eVar = new e(this);
        this.f = eVar;
        this.f10083a.a(eVar);
        return create;
    }

    @Override // com.baidu.tts.i3
    public void destroy() {
        LoggerProxy.d("TtsAdapter", "before engine destroy");
        this.f10083a.destroy();
        LoggerProxy.d("TtsAdapter", "after engine destroy");
        this.b.destroy();
        LoggerProxy.d("TtsAdapter", "after player destroy");
    }

    @Override // com.baidu.tts.i3
    public void pause() {
        this.f10083a.pause();
        this.b.pause();
    }

    @Override // com.baidu.tts.i3
    public void resume() {
        this.f10083a.resume();
        this.b.resume();
    }

    @Override // com.baidu.tts.i3
    public void start() {
        this.f10083a.start();
        this.b.start();
    }

    @Override // com.baidu.tts.i3
    public void stop() {
        LoggerProxy.d("TtsAdapter", "before engine stop");
        this.f10083a.stop();
        LoggerProxy.d("TtsAdapter", "after engine stop");
        this.b.stop();
        LoggerProxy.d("TtsAdapter", "after play stop");
    }
}
