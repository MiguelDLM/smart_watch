package com.baidu.tts.client;

import com.baidu.tts.w2;

/* loaded from: classes8.dex */
public enum TtsMode {
    ONLINE(w2.ONLINE),
    OFFLINE(w2.OFFLINE),
    MIX(w2.MIX);


    /* renamed from: a, reason: collision with root package name */
    public final w2 f10053a;

    TtsMode(w2 w2Var) {
        this.f10053a = w2Var;
    }

    public String getDescription() {
        return this.f10053a.b;
    }

    public int getMode() {
        return this.f10053a.f10184a;
    }

    public w2 getTtsEnum() {
        return this.f10053a;
    }
}
