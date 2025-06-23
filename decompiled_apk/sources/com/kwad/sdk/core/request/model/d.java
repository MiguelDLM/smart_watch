package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;

@KsJson
/* loaded from: classes11.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String aAS;
    public String aAT;
    public int aAU;
    public int aAV;

    public static d FM() {
        d dVar = new d();
        try {
            Context Lw = ServiceProvider.Lw();
            dVar.aAS = aw.cK(Lw);
            dVar.aAT = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yZ();
            dVar.aAU = ah.cx(Lw);
            dVar.aAV = ah.d(Lw, aw.cN(Lw), av.Nc());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d FN() {
        d dVar = new d();
        dVar.aAU = ah.cx(ServiceProvider.getContext());
        return dVar;
    }
}
