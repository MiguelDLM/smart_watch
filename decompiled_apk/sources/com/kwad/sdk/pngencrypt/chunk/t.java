package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes11.dex */
public abstract class t extends k {
    protected String aNV;
    protected String key;

    public t(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public final String Lf() {
        return this.aNV;
    }

    public final String getKey() {
        return this.key;
    }
}
