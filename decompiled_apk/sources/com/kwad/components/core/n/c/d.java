package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes11.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String Ot;
    public long Ou;
    public long Ov;

    /* renamed from: Ox, reason: collision with root package name */
    public String f18456Ox;
    public long Oy;

    public final d C(long j) {
        this.Ou = j;
        return this;
    }

    public final d D(long j) {
        this.Ov = j;
        return this;
    }

    public final d E(long j) {
        this.Oy = j;
        return this;
    }

    public final d aq(String str) {
        this.Ot = str;
        return this;
    }

    public final d ar(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d as(String str) {
        this.f18456Ox = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ay, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }
}
