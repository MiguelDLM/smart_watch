package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class q extends h3 implements v {
    public a0 c;
    public List<p> d = new ArrayList();
    public volatile s e;

    @Override // com.baidu.tts.v
    public void a(p pVar) {
        this.e.a(pVar);
    }

    public void b(x4 x4Var) {
        x4Var.f10198a = o2.SYN_ERROR;
        List<p> list = this.d;
        if (list != null) {
            for (p pVar : list) {
                if (pVar != null) {
                    pVar.onError(x4Var);
                }
            }
        }
    }

    public void c(x4 x4Var) {
        if (b()) {
            if (x4Var == null) {
                x4Var = new x4();
            }
            x4Var.f10198a = o2.SYN_FINISH;
            List<p> list = this.d;
            if (list != null) {
                for (p pVar : list) {
                    if (pVar != null) {
                        pVar.onSynthesizeFinished(x4Var);
                    }
                }
            }
        }
    }

    public void d(x4 x4Var) {
        if (x4Var == null) {
            x4Var = new x4();
        }
        x4Var.f10198a = o2.SYN_STOP;
        List<p> list = this.d;
        if (list != null) {
            for (p pVar : list) {
                if (pVar != null) {
                    pVar.a(x4Var);
                }
            }
        }
    }

    @Override // com.baidu.tts.h3
    public TtsError e() {
        return this.e.create();
    }

    @Override // com.baidu.tts.h3
    public void f() {
        this.e.destroy();
    }

    @Override // com.baidu.tts.v
    public int freeCustomResource(u4 u4Var) {
        return this.e.freeCustomResource(u4Var);
    }

    @Override // com.baidu.tts.h3
    public void g() {
        this.e.pause();
    }

    @Override // com.baidu.tts.h3
    public void h() {
        this.e.resume();
    }

    @Override // com.baidu.tts.h3
    public void i() {
        this.e.start();
    }

    @Override // com.baidu.tts.h3
    public void j() {
        this.e.stop();
    }

    @Override // com.baidu.tts.v
    public int loadCustomResource(u4 u4Var) {
        return this.e.loadCustomResource(u4Var);
    }

    @Override // com.baidu.tts.v
    public int loadEnglishModel(v4 v4Var) {
        return this.e.loadEnglishModel(v4Var);
    }

    @Override // com.baidu.tts.v
    public int loadModel(w4 w4Var) {
        return this.e.loadModel(w4Var);
    }

    @Override // com.baidu.tts.v
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        return this.e.loadSuitedModel(hashMap);
    }

    @Override // com.baidu.tts.v
    public void synthesize(y4 y4Var) {
        this.e.synthesize(y4Var);
    }
}
