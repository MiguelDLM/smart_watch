package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class gm extends gn implements gr {
    private static final String Code = "DisplayEventAgent";
    private static boolean V = gw.Code(gw.e);
    private final List<AdEvents> I = new ArrayList();

    @Override // com.huawei.hms.ads.gr
    public void Code(hg hgVar) {
        if (hgVar instanceof gk) {
            List<AdSession> V2 = ((gk) hgVar).V();
            if (V2.isEmpty()) {
                return;
            }
            for (AdSession adSession : V2) {
                if (adSession != null) {
                    this.I.add(AdEvents.createAdEvents(adSession));
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.gn, com.huawei.hms.ads.hl
    public void D() {
        if (this.I.isEmpty()) {
            fb.I(Code, "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            fb.V(Code, "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.gn, com.huawei.hms.ads.hl
    public void L() {
        fb.V(Code, "load");
        if (this.I.isEmpty()) {
            fb.V(Code, "load, AdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().loaded();
            }
        } catch (IllegalStateException unused) {
            fb.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.gr
    public void V() {
        this.I.clear();
    }

    @Override // com.huawei.hms.ads.gn, com.huawei.hms.ads.hl
    public void Code(hp hpVar) {
        VastProperties C;
        fb.V(Code, "load vastPropertiesWrapper");
        if (hpVar == null || !hp.Code() || (C = hpVar.C()) == null) {
            return;
        }
        Code(C);
    }

    @Override // com.huawei.hms.ads.gn
    public void Code(VastProperties vastProperties) {
        if (this.I.isEmpty()) {
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().loaded(vastProperties);
            }
        } catch (IllegalStateException unused) {
            fb.V(Code, "loaded, fail");
        }
    }

    public static boolean Code() {
        return V;
    }
}
