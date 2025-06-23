package com.alimm.tanx.core.bridge;

import java.util.AbstractMap;

public final /* synthetic */ class oIX0oI implements Callback {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ String f1163II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ TanxJsBridge f1164oIX0oI;

    public /* synthetic */ oIX0oI(TanxJsBridge tanxJsBridge, String str) {
        this.f1164oIX0oI = tanxJsBridge;
        this.f1163II0xO0 = str;
    }

    public final void call(boolean z, AbstractMap abstractMap) {
        this.f1164oIX0oI.lambda$flush$0(this.f1163II0xO0, z, abstractMap);
    }
}
