package com.huawei.openalliance.ad.constant;

import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class bq {
    private static final String Code = "PlacementPlayState";
    private final byte[] I;
    private a V;

    /* loaded from: classes10.dex */
    public enum a {
        SINGLE_INST,
        MAIN_VIEW,
        BACKUP_VIEW
    }

    public bq() {
        this.V = a.SINGLE_INST;
        this.I = new byte[0];
    }

    public a Code() {
        a aVar;
        synchronized (this.I) {
            aVar = this.V;
        }
        return aVar;
    }

    public boolean I(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = !V(aVar);
        }
        return z;
    }

    public boolean V(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = aVar == this.V;
        }
        return z;
    }

    public bq(a aVar) {
        a aVar2 = a.SINGLE_INST;
        this.I = new byte[0];
        this.V = aVar;
    }

    public void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.I) {
            fb.V(Code, "switch to state: %s", aVar);
            this.V = aVar;
        }
    }
}
