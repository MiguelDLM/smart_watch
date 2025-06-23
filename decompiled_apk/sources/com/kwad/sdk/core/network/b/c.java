package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: classes11.dex */
public final class c {
    public static b ET() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.zp()) {
            return new d();
        }
        return new a();
    }
}
