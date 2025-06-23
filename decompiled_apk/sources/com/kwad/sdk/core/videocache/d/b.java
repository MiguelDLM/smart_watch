package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class b implements c {
    private HashMap<String, n> aDR = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aDR.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eT(String str) {
        if (!this.aDR.containsKey(str)) {
            return null;
        }
        return this.aDR.get(str);
    }
}
