package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class f {
    private Map<Integer, AdResultData> JF = new ConcurrentHashMap();
    private AtomicInteger JG = new AtomicInteger(0);

    /* loaded from: classes11.dex */
    public static class a {
        static f JH = new f();
    }

    public static f ne() {
        return a.JH;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.JF.get(Integer.valueOf(i));
        this.JF.remove(Integer.valueOf(i));
        return adResultData;
    }

    public final int i(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.JG.incrementAndGet();
        this.JF.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
