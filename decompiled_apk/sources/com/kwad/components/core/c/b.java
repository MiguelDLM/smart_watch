package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.v;

/* loaded from: classes11.dex */
public final class b {
    private static void Z(String str) {
        if (mW() && com.kwad.sdk.l.zJ().yY()) {
            v.P(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        Z("使用缓存策略: " + eVar.na());
    }

    public static boolean mW() {
        return false;
    }
}
