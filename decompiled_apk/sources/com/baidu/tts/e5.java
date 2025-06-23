package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.t0;
import com.baidu.tts.x2;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class e5 extends b5 {
    public e5(d5 d5Var) {
        super(d5Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public TtsError create() {
        TtsError c = this.f10043a.c();
        if (c != null) {
            x2 errorEnum = c.getErrorEnum();
            if (errorEnum != null) {
                if (x2.a.MIX_ERROR.equals(errorEnum.f10194a)) {
                    d5 d5Var = this.f10043a;
                    d5Var.e = d5Var.g;
                }
            }
        } else {
            d5 d5Var2 = this.f10043a;
            d5Var2.e = d5Var2.g;
        }
        return c;
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void destroy() {
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(u4 u4Var) {
        this.f10043a.b();
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(u4 u4Var) {
        this.f10043a.b();
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(v4 v4Var) {
        this.f10043a.b();
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(w4 w4Var) {
        this.f10043a.b();
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        this.f10043a.b();
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void pause() {
        this.f10043a.b();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void resume() {
        this.f10043a.b();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i, int i2) {
        t0.a aVar = this.f10043a.getTtsParams().b.f10159a;
        aVar.i = i;
        aVar.j = i2;
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i) {
        this.f10043a.getTtsParams().b.f10159a.c = i;
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        this.f10043a.getTtsParams().b.f10159a.f10167a = i;
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        t0.a aVar = this.f10043a.getTtsParams().b.f10159a;
        aVar.g = f;
        aVar.h = f2;
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(y4 y4Var) {
        this.f10043a.b();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void start() {
        this.f10043a.b();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void stop() {
        this.f10043a.b();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(y4 y4Var) {
        this.f10043a.b();
    }
}
