package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public final class i {
    private Map<String, List<AdTemplate>> qf;

    /* loaded from: classes11.dex */
    public static class a {
        private static final i qg = new i(0);
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static i gk() {
        return a.qg;
    }

    public final void C(String str) {
        this.qf.remove(str);
    }

    private i() {
        this.qf = new ConcurrentHashMap();
    }
}
