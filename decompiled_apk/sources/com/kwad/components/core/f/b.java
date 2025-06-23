package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;

/* loaded from: classes11.dex */
public final class b implements e {
    @Override // com.kwad.sdk.core.a.e
    public final String am(String str) {
        return d.am(str);
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return e.class;
    }

    @Override // com.kwad.sdk.core.a.e
    public final String getResponseData(String str) {
        return d.getResponseData(str);
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }
}
