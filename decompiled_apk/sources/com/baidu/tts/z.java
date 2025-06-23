package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class z extends s {
    public z(u uVar) {
        super(uVar);
    }

    public final void b(x4 x4Var) {
        x4Var.j = c3.a().a(x2.W);
        this.f10163a.b(x4Var);
    }

    @Override // com.baidu.tts.s, com.baidu.tts.i3
    public TtsError create() {
        u uVar = this.f10163a;
        uVar.getClass();
        p4.a();
        l1 a2 = l1.a();
        if (!a2.m) {
            a2.l.start();
            a2.m = true;
        }
        if (uVar.d == null) {
            uVar.d = new ArrayList();
        }
        uVar.c.a((p) new t(uVar));
        TtsError a3 = uVar.c.a();
        u uVar2 = this.f10163a;
        uVar2.e = uVar2.h;
        return a3;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public int freeCustomResource(u4 u4Var) {
        b(new x4());
        return -1;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public int loadCustomResource(u4 u4Var) {
        b(new x4());
        return -1;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public int loadEnglishModel(v4 v4Var) {
        b(new x4());
        return -1;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public int loadModel(w4 w4Var) {
        b(new x4());
        return -1;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public int loadSuitedModel(HashMap<String, String> hashMap) {
        b(new x4());
        return -1;
    }

    @Override // com.baidu.tts.s, com.baidu.tts.v
    public void synthesize(y4 y4Var) {
        b(x4.a(y4Var));
    }
}
