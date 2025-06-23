package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public abstract class s implements v {

    /* renamed from: a, reason: collision with root package name */
    public u f10163a;

    public s(u uVar) {
        this.f10163a = uVar;
    }

    @Override // com.baidu.tts.v
    public void a(p pVar) {
        u uVar = this.f10163a;
        if (uVar.d == null) {
            uVar.d = new ArrayList();
        }
        if (!uVar.d.contains(pVar)) {
            uVar.d.add(pVar);
        }
    }

    @Override // com.baidu.tts.i3
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.i3
    public void destroy() {
    }

    @Override // com.baidu.tts.v
    public int freeCustomResource(u4 u4Var) {
        return this.f10163a.c.a(u4Var);
    }

    @Override // com.baidu.tts.v
    public int loadCustomResource(u4 u4Var) {
        return this.f10163a.c.b(u4Var);
    }

    @Override // com.baidu.tts.v
    public int loadEnglishModel(v4 v4Var) {
        return this.f10163a.c.a(v4Var);
    }

    @Override // com.baidu.tts.v
    public int loadModel(w4 w4Var) {
        return this.f10163a.c.a(w4Var);
    }

    @Override // com.baidu.tts.v
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        return this.f10163a.c.a(hashMap);
    }

    @Override // com.baidu.tts.i3
    public void pause() {
    }

    @Override // com.baidu.tts.i3
    public void resume() {
    }

    @Override // com.baidu.tts.i3
    public void start() {
    }

    @Override // com.baidu.tts.i3
    public void stop() {
    }

    @Override // com.baidu.tts.v
    public abstract void synthesize(y4 y4Var);
}
