package com.kwad.components.core.i;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* loaded from: classes11.dex */
public final class d {

    @Nullable
    private Object MG;

    public d(Object obj) {
        this.MG = obj;
    }

    public final void c(c cVar) {
        if (this.MG != null && cVar != null && cVar.getHost() != null) {
            try {
                ((KsInnerAd.KsInnerAdInteractionListener) this.MG).onAdClicked((KsInnerAd) cVar.getHost());
            } catch (Exception unused) {
            }
        }
    }

    public final void d(c cVar) {
        if (this.MG != null && cVar != null && cVar.getHost() != null) {
            try {
                ((KsInnerAd.KsInnerAdInteractionListener) this.MG).onAdShow((KsInnerAd) cVar.getHost());
            } catch (Exception unused) {
            }
        }
    }

    public final void destroy() {
        this.MG = null;
    }
}
