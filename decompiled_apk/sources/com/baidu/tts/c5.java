package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.m;
import com.baidu.tts.o;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class c5 extends b5 {
    public c5(d5 d5Var) {
        super(d5Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void destroy() {
        ConcurrentMap<m, Future<m.a>> concurrentMap;
        ConcurrentMap<o, Future<o.a>> concurrentMap2;
        d5 d5Var = this.f10043a;
        ((f) d5Var.d.f10090a).destroy();
        j a2 = j.a();
        l3<o, o.a> l3Var = a2.f10111a;
        if (l3Var != null && (concurrentMap2 = l3Var.f10130a) != null) {
            concurrentMap2.clear();
        }
        l3<m, m.a> l3Var2 = a2.b;
        if (l3Var2 != null && (concurrentMap = l3Var2.f10130a) != null) {
            concurrentMap.clear();
        }
        e3.e().destroy();
        d5Var.f10073a = new z4();
        d5 d5Var2 = this.f10043a;
        d5Var2.e = d5Var2.f;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(u4 u4Var) {
        return ((f) this.f10043a.d.f10090a).f10083a.freeCustomResource(u4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(u4 u4Var) {
        return ((f) this.f10043a.d.f10090a).f10083a.loadCustomResource(u4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(v4 v4Var) {
        return ((f) this.f10043a.d.f10090a).f10083a.loadEnglishModel(v4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(w4 w4Var) {
        return ((f) this.f10043a.d.f10090a).f10083a.loadModel(w4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        return ((f) this.f10043a.d.f10090a).f10083a.loadSuitedModel(hashMap);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void pause() {
        ((f) this.f10043a.d.f10090a).pause();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void resume() {
        ((f) this.f10043a.d.f10090a).resume();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i, int i2) {
        d5 d5Var = this.f10043a;
        d5Var.getClass();
        try {
            return ((f) d5Var.d.f10090a).b.setAudioAttributes(i, i2);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i) {
        d5 d5Var = this.f10043a;
        d5Var.getClass();
        try {
            return ((f) d5Var.d.f10090a).b.setAudioSampleRate(i);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        d5 d5Var = this.f10043a;
        d5Var.getClass();
        try {
            return ((f) d5Var.d.f10090a).b.setAudioStreamType(i);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        return ((f) this.f10043a.d.f10090a).b.setStereoVolume(f, f2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(y4 y4Var) {
        f fVar = (f) this.f10043a.d.f10090a;
        fVar.b.a();
        fVar.f10083a.synthesize(y4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void start() {
        ((f) this.f10043a.d.f10090a).start();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void stop() {
        ((f) this.f10043a.d.f10090a).stop();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(y4 y4Var) {
        ((f) this.f10043a.d.f10090a).f10083a.synthesize(y4Var);
    }
}
