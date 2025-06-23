package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int rn = 1;
    public static int ro = 3;
    public int rp;
    public int rq;

    public b() {
        this.rp = STATUS_NONE;
    }

    public final void M(int i) {
        this.rq = i;
    }

    public final int gP() {
        return this.rq;
    }

    public final int getType() {
        return this.rp;
    }

    public b(int i) {
        this.rp = 1;
    }
}
