package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.q;

/* loaded from: classes11.dex */
public final class h implements IOfflineTKRenderListener {
    private final q aeh;

    public h(q qVar) {
        this.aeh = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        q qVar = this.aeh;
        if (qVar != null) {
            qVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        q qVar = this.aeh;
        if (qVar != null) {
            qVar.onSuccess();
        }
    }
}
