package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.o;

/* loaded from: classes11.dex */
public final class g implements IOfflineTKCallHandler {
    private final o aeg;

    public g(o oVar) {
        this.aeg = oVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        o oVar = this.aeg;
        if (oVar != null) {
            oVar.callJS(str);
        }
    }
}
