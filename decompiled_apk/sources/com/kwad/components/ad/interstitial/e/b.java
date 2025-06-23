package com.kwad.components.ad.interstitial.e;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: classes11.dex */
public class b extends Presenter {
    public c jK;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.jK = (c) Kf();
    }

    public void cP() {
        List<Presenter> Ke = Ke();
        if (Ke == null) {
            return;
        }
        for (Presenter presenter : Ke) {
            if (presenter instanceof b) {
                ((b) presenter).cP();
            }
        }
    }

    public void cQ() {
        List<Presenter> Ke = Ke();
        if (Ke == null) {
            return;
        }
        for (Presenter presenter : Ke) {
            if (presenter instanceof b) {
                ((b) presenter).cQ();
            }
        }
    }
}
