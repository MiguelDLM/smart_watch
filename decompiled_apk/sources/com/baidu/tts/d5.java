package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.t0;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class d5 implements ITts {
    public static final /* synthetic */ boolean h = true;

    /* renamed from: a, reason: collision with root package name */
    public z4 f10073a = new z4();
    public TtsListener b;
    public w2 c;
    public g d;
    public volatile b5 e;
    public e5 f;
    public c5 g;

    public d5() {
        e5 e5Var = new e5(this);
        this.f = e5Var;
        this.g = new c5(this);
        this.e = e5Var;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(w2 w2Var) {
        return this.e.auth(w2Var);
    }

    public int b() {
        if (this.b != null) {
            TtsError a2 = c3.a().a(x2.f10193x0);
            x4 x4Var = new x4();
            x4Var.j = a2;
            TtsListener ttsListener = this.b;
            if (ttsListener != null) {
                ttsListener.onError(x4Var);
                return -1;
            }
            return -1;
        }
        x2 x2Var = x2.f10193x0;
        throw new IllegalStateException("tts has not been initialized,invoke in a wrong state");
    }

    public TtsError c() {
        r4 r4Var;
        if (this.c == null) {
            this.c = w2.ONLINE;
        }
        if (this.f10073a == null) {
            this.f10073a = new z4();
        }
        e3.e().getClass();
        p2 p2Var = p2.OFFLINE;
        int ordinal = this.c.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    r4Var = null;
                } else {
                    p2Var = p2.MIX;
                    r4Var = this.f10073a.f10209a;
                }
            } else {
                r4Var = new r4();
                r4Var.b = this.f10073a.f10209a.b;
            }
        } else {
            p2Var = p2.ONLINE;
            r4Var = new r4();
            r4Var.f10162a = this.f10073a.f10209a.f10162a;
        }
        if (r4Var != null) {
            c0 c0Var = new c0(p2Var);
            u uVar = new u();
            uVar.e.f10163a.c = c0Var;
            uVar.e.f10163a.c.a((a0) r4Var);
            p0 p0Var = new p0();
            q4 q4Var = this.f10073a.b;
            p0 p0Var2 = p0Var.d.f10117a;
            p0Var2.getClass();
            t0.a aVar = q4Var.f10159a;
            t0 t0Var = (t0) p0Var2.f;
            t0Var.getClass();
            t0Var.c = aVar;
            g gVar = new g();
            this.d = gVar;
            gVar.f10090a = new f(uVar, p0Var);
            TtsListener ttsListener = this.b;
            if (ttsListener != null) {
                gVar.a(ttsListener);
            }
            return ((f) this.d.f10090a).create();
        }
        return c3.a().a(x2.f10193x0);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public TtsError create() {
        return this.e.create();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void destroy() {
        this.e.destroy();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(u4 u4Var) {
        return this.e.freeCustomResource(null);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public w2 getMode() {
        return this.e.f10043a.c;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.e.f10043a.b;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public z4 getTtsParams() {
        return this.e.f10043a.f10073a;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(u4 u4Var) {
        return this.e.loadCustomResource(u4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(v4 v4Var) {
        return this.e.loadEnglishModel(v4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(w4 w4Var) {
        return this.e.loadModel(w4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        return this.e.loadSuitedModel(hashMap);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void pause() {
        this.e.pause();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void resume() {
        this.e.resume();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i, int i2) {
        return this.e.setAudioAttributes(i, i2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i) {
        return this.e.setAudioSampleRate(i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        return this.e.setAudioStreamType(i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.e.f10043a.getClass();
        e3 e = e3.e();
        e.getClass();
        e.b = new WeakReference<>(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(w2 w2Var) {
        this.e.f10043a.c = w2Var;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(q2 q2Var, String str) {
        return this.e.setParam(q2Var, str);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        return this.e.setStereoVolume(f, f2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        d5 d5Var = this.e.f10043a;
        d5Var.getClass();
        if (ttsListener != null && ttsListener != d5Var.b) {
            d5Var.b = ttsListener;
            g gVar = d5Var.d;
            if (gVar != null) {
                gVar.a(ttsListener);
            }
        }
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(y4 y4Var) {
        this.e.speak(y4Var);
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void start() {
        this.e.start();
    }

    @Override // com.baidu.tts.aop.tts.ITts, com.baidu.tts.i3
    public void stop() {
        this.e.stop();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(y4 y4Var) {
        this.e.synthesize(y4Var);
    }
}
