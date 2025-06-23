package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.HashMap;

/* loaded from: classes8.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public p f10030a;

    public abstract int a(u4 u4Var);

    public abstract int a(v4 v4Var);

    public int a(w4 w4Var) {
        return 0;
    }

    public abstract TtsError a(y4 y4Var) throws InterruptedException;

    public abstract <T> void a(T t);

    public abstract int b(u4 u4Var);

    public TtsError b() {
        return null;
    }

    public int a(HashMap<String, String> hashMap) {
        return 0;
    }

    public TtsError a() {
        return null;
    }

    public void a(p pVar) {
        this.f10030a = pVar;
        l1 a2 = l1.a();
        p pVar2 = this.f10030a;
        synchronized (a2) {
            a2.i = pVar2;
        }
    }
}
