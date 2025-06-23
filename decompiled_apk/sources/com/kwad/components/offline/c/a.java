package com.kwad.components.offline.c;

import android.content.Context;

/* loaded from: classes11.dex */
public final class a implements com.kwad.components.core.n.a.d.b {
    @Override // com.kwad.components.core.n.a.d.b
    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        c.un().a(aVar);
    }

    @Override // com.kwad.components.core.n.a.d.b
    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        c.un().b(aVar);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<?> getComponentsType() {
        return com.kwad.components.core.n.a.d.b.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return 100;
    }
}
