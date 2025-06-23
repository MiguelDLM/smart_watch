package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String Ot;
    public long Ou;
    public long Ov;
    public long Ow;

    /* renamed from: Ox, reason: collision with root package name */
    public String f18455Ox;

    public final b A(long j) {
        this.Ou = j;
        return this;
    }

    public final b B(long j) {
        this.Ov = j;
        return this;
    }

    public final b an(String str) {
        this.Ot = str;
        return this;
    }

    public final b ao(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b ap(String str) {
        this.f18455Ox = str;
        return this;
    }

    public final b aw(int i) {
        this.Ow = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ax, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }
}
