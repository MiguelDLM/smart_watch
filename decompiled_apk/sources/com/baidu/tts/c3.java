package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import java.util.Hashtable;

/* loaded from: classes8.dex */
public class c3 {
    public static volatile c3 b;

    /* renamed from: a, reason: collision with root package name */
    public Hashtable<x2, b3> f10047a = new Hashtable<>();

    public static c3 a() {
        if (b == null) {
            synchronized (c3.class) {
                try {
                    if (b == null) {
                        b = new c3();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public TtsError a(x2 x2Var) {
        b3 b3Var = this.f10047a.get(x2Var);
        if (b3Var == null) {
            b3Var = new b3(x2Var);
            this.f10047a.put(x2Var, b3Var);
        }
        TtsError ttsError = new TtsError();
        ttsError.setTtsErrorFlyweight(b3Var);
        return ttsError;
    }
}
